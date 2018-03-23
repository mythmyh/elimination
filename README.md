1：需要改动com.translation.utils的两个bat文件,根据自己的tomcat地址修改这一部分：D:\apache-tomcat-8.5.6-windows-x64\apache-tomcat-8.5.6\
  原文：cd /d D:\apache-tomcat-8.5.6-windows-x64\apache-tomcat-8.5.6\webapps\elimination\WEB-INF\classes\com\translation\utils\
2：需要合适的chromedriver和chrome，chromedriver版本自己百度一下

3：修改/view/chinese.jsp中的ip地址和端口
    new WebSocket('ws://192.168.0.115:9000/elimination/websocketMain');
