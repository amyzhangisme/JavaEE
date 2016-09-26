
import threading
import socket
import os

import time

import StringIO
import sys
SERVER_STRING = "Server: jdbhttpd/0.1.0\r\n"
global host
PORT=3322
global thedata
global method
RES_FILE_DIR = "."

class WSGIServer(object):

    def get_data_string(self):
        now = time.time()
        clock_now = time.localtime(now)
        cur_time = list(clock_now)
        date_string = "%d-%d-%d-%d-%d-%d" % (cur_time[0],
                                             cur_time[1], cur_time[2], cur_time[3], cur_time[4], cur_time[5])
        return date_string


    def bad_request(self,client):


        buf="HTTP/1.0 400 BAD REQUEST\r\n"+"Content-type: text/html\r\n"+"\r\n"+"<P>Your browser sent a bad request, "+"such as a POST without a Content-Length.\r\n"
        client.send(buf)
    def not_found(self,client):
        buf="HTTP/1.0 404 NOT FOUND\r\n"+SERVER_STRING+"Content-Type: text/html\r\n"+"\r\n"+"<HTML><TITLE>Not Found</TITLE>\r\n"+"<BODY><P>The server could not fulfill\r\n"+"your request because the resource specified\r\n"+"is unavailable or nonexistent.\r\n"+"</BODY></HTML>\r\n"
        client.send(buf)

    def headers(self,client):
        buf= "HTTP/1.0 200 OK\r\n"+SERVER_STRING+"Content-Type: text/html\r\n"+"\r\n"
        client.send(buf)

    def cannot_execute(self,client):
        buf="HTTP/1.0 500 Internal Server Error\r\n"+"Content-type: text/html\r\n"+ "\r\n"+"<P>Error prohibited CGI execution.\r\n"
        client.send(buf)


    def unimplemented(self,client):

        buf="HTTP/1.0 501 Method Not Implemented\r\n"+SERVER_STRING+"Content-Type: text/html\r\n"+"<HTML><HEAD><TITLE>Method Not Implemented\r\n"+"</TITLE></HEAD>\r\n"+"<BODY><P>HTTP request method not supported.\r\n"+"</BODY></HTML>\r\n"
        client.send(buf)

    def cat(self,client, file1):
        line_mc=file1.readline()
        client.send(line_mc)
        while (line_mc):
            client.send(line_mc)
            line_mc = file1.readline()





    def get_environ(self,line):
            env = {}
            env['wsgi.version'] = (1, 0)
            env['wsgi.url_scheme'] = 'http'
            env['wsgi.input'] = StringIO.StringIO(line.split()[1])
            env['wsgi.errors'] = sys.stderr
            env['wsgi.multithread'] = False
            env['wsgi.multiprocess'] = False
            env['wsgi.run_once'] = False
            # Required CGI variables
            env['REQUEST_METHOD'] = line.split()[0]
            env['PATH_INFO'] = line.split()[1]
            env['SERVER_NAME'] = socket.getfqdn(host)
            env['SERVER_PORT'] = port
            env['QUERY_STRING'] = str(self.query_string)
            return env

    def accept_request(self,client):
        self.query_string = ''
        cgi=0
        thedata = client.recv(1024)
        datasplit = thedata.splitlines()
        print(''.join(
            '< {line}\n'.format(line=line)
            for line in datasplit
        ))
        s=str(thedata)
        line = s.splitlines()[0].rstrip('\r\n')
        self.canshu =s.splitlines()[len(s.splitlines())-1].rstrip('\r\n')
        print line
        if len(line.split())<3:
            self.bad_request(client)
        method,url,version = line.split()
        print method
        print url
        print version
        judge = str(url).split("?")[0].split("/")[len(str(url).split("/"))-1]
        file=judge.split(".")
        if len(file)==1 :
            cgi=1
        else:
            if file[1]=='html':
                cgi = 0
            else:
                cgi = 1

        if ((method!= "GET") and (method!= "POST")):
            self.unimplemented(client)
            return
        if ((method=="POST")):
            self.url = url
            print datasplit[len(datasplit)-1]
            self.query_string = datasplit[len(datasplit)-1]
        if (method == "GET"):
            if(len(str(url).split("?"))>1):
                self.query_string = str(url).split("?")[1]
                self.url = str(url).split("?")[0]
                print self.query_string
        path = url
        if (path[len(path) - 1] == '/'):
            path += "index.html"

        else:
            if (not cgi):
                if path!='/favicon.ico':
                    self.serve_file(client, path)
            else:
                result =self.application(self.get_environ(line), self.start_response)
                self.finish_response(result,client)
            client.close()


    def finish_response(self, result,client):
        try:
            status, response_headers = self.headers_set
            response = 'HTTP/1.1 {status}\r\n'.format(status=status)
            for header in response_headers:
                response += '{0}: {1}\r\n'.format(*header)
            response += '\r\n'
            for data in result:
                response += data
            # Print formatted response data a la 'curl -v'
            print(''.join(
                '> {line}\n'.format(line=line)
                for line in response.splitlines()
            ))
            client.sendall(response)
        finally:
            client.close()



    def start_response(self, status, response_headers,exc_info=None):
            # Add necessary server headers
            print self
            server_headers = [
                ('Date', self.get_data_string()),
                ('Server', 'WSGIServer 0.2'),
                ('Result','result')
            ]

            self.headers_set = [status, response_headers + server_headers]

    def error_die(sc):
        print sc
        exit(1)

    #*********************************************************************/
    def application(self,environ, start_response):

        response_body = 'hello %s' % environ['PATH_INFO']
        status = '200 OK'
        response_headers = [('Content-Type', 'text/plain'),
                            ('Content-Length', str(len(response_body)))]
        start_response(status, response_headers)
        return [response_body]

    def serve_file(self,client, path):
        if(os.path.exists(path)):
            resource = open(path, "r")
            print resource
            if (resource == None):
                self.not_found(client)
            else:
                self.headers(client)
                self.cat(client, resource)
            resource.close()
        else:
            self.not_found(client)


    def startup(self,port):

        httpd = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
        if httpd==-1:
            self.error_die("socket")
        httpd.bind((host, port))
        httpd.listen(50)
        return httpd



if __name__ == '__main__':
    host = '127.0.0.1'
    port = 8888
    server = WSGIServer()
    server_sock = server.startup(port)
    print "httpd running on port %d\n", port
    while (1):
            conn, addr = server_sock.accept()
            if (conn == -1):
                server.error_die("accept")
            thread = threading.Thread(target=server.accept_request(conn), args=(conn, addr))
            thread.start()
    server_sock.close()










