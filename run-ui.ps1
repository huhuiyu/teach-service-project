$currentyDir = Split-Path -Parent $MyInvocation.MyCommand.Definition;
Set-Location $currentyDir\ui
npm run serve
Set-Location $currentyDir