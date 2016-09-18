# -*- coding: utf-8 -*-：
import socket
ANY = socket.gethostbyname('localhost')
HOST='127.0.0.1'
PORT=3332
s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)      #定义socket类型，网络通信，TCP
s.connect((HOST,PORT))       #要连接的IP与端口
while 1:
       cmd=raw_input("Please input(exit中止对话):")       #与人交互，输入命令
       s.sendall(cmd)      #把命令发送给对端
       data=s.recv(1024)     #把接收的数据定义为变量
       print data
       if(data=='!'):
              print '服务器已关闭'  # 输出变量
              s.close()
s.close()   #关闭连接