cd D:\apache-tomcat-8.5.6-windows-x64\apache-tomcat-8.5.6\webapps\elimination\WEB-INF\classes\com\translation\utils\
cd /d D:
set da="C:\Program Files (x86)\Google\Chrome\Application\chromedriver.exe"
java -Dwebdriver.chrome.driver=%da% -jar selenium-server-standalone.jar -role node -hub http://192.168.0.115:4444/grid/register -maxSession 40 -browser "browserName=chrome,maxInstances=40" -port 5555





