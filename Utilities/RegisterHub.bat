Echo off
Title Server HUB on default port 4444


Echo Setting Project Location
set projectLocation=C:\Framework\CucumberFramework\Utilities
pushd %projectLocation%

Echo Loading HUB on default port 4444
java -jar selenium-server-4.1.2.jar hub
pause