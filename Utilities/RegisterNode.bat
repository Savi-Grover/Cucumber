Echo off
Title Server NODE on default port 4442

Echo Setting Project Location
set projectLocation=C:\Framework\CucumberFramework\Utilities
pushd %projectLocation%

Echo Loading NODE on default port 4444
REM To register node in the same machine where hub is registered
java -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.gecko.driver=geckodriver.exe -Dwebdriver.msedge.driver=msedgedriver.exe -jar selenium-server-4.1.2.jar node

REM -browser "browserName=chrome,version=ANY,platform=WINDOWS,maxInstances=5" -maxSession 20 -port 4442

REM To register a node machine which is different from Hub Machine and REM execute tests, use the below command. The IP address is the HUB's
REM java -jar selenium-server-4.1.2.jar node --detect-drivers true --publish-events tcp://19.199.254.181:4442 --subscribe-events tcp://19.199.254.181:4443


pause
