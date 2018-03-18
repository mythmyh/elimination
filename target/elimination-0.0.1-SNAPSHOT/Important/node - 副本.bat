@echo off

start  cmd /k cd  C:\Users\Administrator\Downloads
java -Dwebdriver.chrome.driver=¡°C:\Program Files (x86)\Google\Chrome\Application\chromedriver.exe¡± -jar selenium-server-standalone.jar -role node -hub http://192.168.0.115:4444/grid/register -maxSession 40 -browser "browserName=chrome,maxInstances=40" -port 5555






