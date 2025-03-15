# Project Basic Information
_Environment: OpenJDK 17, Appium v2.0.1, Maven 3.8.4\
_Plugin: Cucumber for java, Gherkin\
_Tool: IDE IntelliJ

## Branch & Features
_Master\
_Feature: src/test/resources/features/android/Tutorials.feature\


## Execute test script
_Method 1: Using maven command line
```
mvn clean verify -D"cucumber.filter.tags=@Android_TC001"
```
_Method 2: Using CucumberTestSuite

## Reports
Reports will be generated automatically after the test script is finished running,\  
and it will be in the folder: "_target/site/serenity/index.html_"




