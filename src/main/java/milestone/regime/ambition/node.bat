
java -Dwebdriver.chrome.driver=%driver% -jar selenium-server-standalone.jar -role node -hub http://192.168.0.115:4444/grid/register -maxSession 40 -browser "browserName=chrome,maxInstances=40" -port 5555






