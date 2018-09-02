# ActiveMQ的安装(Windows版)

## 下载

ActiveMQ 官网：http://activemq.apache.org/

ActiveMQ 下载地址：http://activemq.apache.org/download.html

## 安装

解压

![01](ActiveMQ的安装/01.png)

解压后的目录如下

![02](ActiveMQ的安装/02.png)

开启

进入 apache-activemq-5.15.5\bin\win64 ，找到 activemq.bat，双击 activemq.bat 即可

![03](ActiveMQ的安装/03.png)

![04](ActiveMQ的安装/04.png)

验证

ActiveMQ默认启动时，启动了内置的jetty服务器，提供一个用于监控ActiveMQ的admin应用。 

```
地址：http://127.0.0.1:8161/admin/
默认账号：admin
默认密码：admin
```

![05](ActiveMQ的安装/05.png)

![06](ActiveMQ的安装/06.png)