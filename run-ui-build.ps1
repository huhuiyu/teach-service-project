$currentyDir = Split-Path -Parent $MyInvocation.MyCommand.Definition;
$serverProjectPath = "D:\git\code.aliyun\huhuiyu.top.server"
Set-Location $currentyDir\ui
npm run build
Set-Location $serverProjectPath\teach-service-ui
git pull
git add *
git commit -m "teach service ui update==>$(Get-Date)"
.\push.ps1
Start-Process $serverProjectPath\teach-service-ui
Set-Location $currentyDir