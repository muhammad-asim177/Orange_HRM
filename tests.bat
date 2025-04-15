@echo off
echo ===============================
echo Running Maven Selenium Project
echo ===============================

REM Navigate to your project directory
cd /d "C:\Users\Kinectro\Documents\New Test\Orange_HRM"

REM Clean and install using Maven
echo Cleaning and building the project...
mvn clean install

REM Check if build succeeded
IF %ERRORLEVEL% NEQ 0 (
    echo Build failed. Exiting.
    pause
    exit /b %ERRORLEVEL%
)

echo ===============================
echo Build Success! Tests Completed
echo ===============================
pause
