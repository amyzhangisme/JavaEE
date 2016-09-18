# -*- coding: utf-8 -*-：
import socket   #socket模块
import threading
import commands   #执行系统命令模块
HOST='127.0.0.1'
PORT=3333
ANY = socket.gethostbyname('localhost')

def jonnyS(client, address):
    try:
    #设置超时时间
        client.settimeout(500)
    except socket.timeout:
        print 'time out'
    print'Connected by', address  # 输出客户端的IP地址
    while 1:
        c=''
        data = client.recv(1024).decode('utf8')  # 把接收的数据实例化
        print client
        print data
        if(data=='exit'):
            client.close()
            break
        client.sendall(data[::-1].encode('utf8'))

    # #将接收到的信息原样的返回到客户端中
    #     client.send(buf)
    #超时后显示退出

    #关闭与客户端的连接
    client.close()

def main():
    s= socket.socket(socket.AF_INET,socket.SOCK_STREAM)   #定义socket类型，网络通信，TCP
    print'Connected by'
    s.bind((HOST,PORT))   #套接字绑定的IP与端口
    print'Connected by'
    s.listen(20)         #开始TCP监听
    while 1:
           conn,addr=s.accept()   #接受TCP连接，并返回新的套接字与IP地址
           thread = threading.Thread(target=jonnyS, args=(conn,addr))
           thread.start()

    conn.close()     #关闭连接

if __name__=='__main__':
    main()
