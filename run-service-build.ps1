$currentyDir = Split-Path -Parent $MyInvocation.MyCommand.Definition;
$serverProjectPath = "D:\git\student\shuailanjun.top.server"
Set-Location $currentyDir\scripts
.\java-home.ps1
.\gradle-home.ps1
Set-Location $currentyDir\teach-service\huhuiyu.teach.service
gradle build
Copy-Item .\build\libs\huhuiyu.teach.service-1.0.0.war $serverProjectPath\java\
Set-Location $serverProjectPath\java\
git pull
git add *
git commit -m "teach service update==>$(Get-Date)"
git push
Start-Process $serverProjectPath\java\
Set-Location $currentyDir