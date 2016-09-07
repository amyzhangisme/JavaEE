# -*- coding: utf-8 -*-：
import socket   #socket模块
import commands   #执行系统命令模块
HOST='10.0.0.27'
PORT=1501
ANY = socket.gethostbyname('localhost')
s= socket.socket(socket.AF_INET,socket.SOCK_STREAM)   #定义socket类型，网络通信，TCP
hello = 'Hello world!'
print'Connected by'
s.bind((ANY,PORT))   #套接字绑定的IP与端口
print'Connected by'
s.listen(1)         #开始TCP监听
while 1:
       conn,addr=s.accept()   #接受TCP连接，并返回新的套接字与IP地址
       print'Connected by',addr    #输出客户端的IP地址
       while 1:
                data=conn.recv(1024)    #把接收的数据实例化
                print data

                conn.sendall('!dlrow olleH')
                
conn.close()     #关闭连接