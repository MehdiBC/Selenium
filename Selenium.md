# Selenium
Selenium is a free and open-source test automation suite used for automating web-based applications. 
It supports automation across different browsers, platforms, and programming languages.

Selenium is not just a single tool but a suite of software's, It has four components:
  - Selenium IDE (Integrated Development Environement)
  - Selenium RC (Remote Control)
  - Selenium WebDriver
  - Selenium Grid
  
  
## Selenium IDE:
Selenium Integrated Development Environment (IDE) is the simplest framework in the Selenium suite and is the easiest one to learn.

    |                  Pros                                |                               Cons                                |
    |------------------------------------------------------|-------------------------------------------------------------------|
    |+ Very easy to use and install                        |     - Designed only for prototypes of tests                       | 
    |+ No programming knowledge is required though         |     - No support for iterations and conditional operations        | 
    |knowledge of HTML and DOM is needed                   |     - Test execution is slow compared to WebDriver and Selenium RC|
    |+ Can export tests to formats to be used by           |                                                                   | 
    |WebDriver and Selenium RC                             |                                                                   |
    |+ Generates reports of tests results                  |                                                                   |
    |+ Provides support for extensions                     |                                                                   |     
    
    
    
## Selenium WebDriver
**WebDriver** is a web automation framework.
It allows you to execute your tests against different browsers using a programming language. You can now perform iterations and conditional operations.

  - It controls the browser from the OS level
  - You can use different programming languages
  - Testing web applications across different browsers
  
Read more on the WebDriver architecture: https://www.browserstack.com/guide/selenium-webdriver-tutorial

## Selenium RC
**Selenium RC** is a test automation tool supporting different programming languages.
It comprises of two parts: 
  - Client libraries for the prefered computer language
  - Server that launches and kills browsers automatically
  
## WebDriver VS Selenium RC
  - WebDriver is faster than Selenium RC because it has a simpler achitecture ( WebDriver interacts with the Browser through the operating system )
  - WebDriver's API is more concise than Selenium RC's.
  
## Selenium Grid
  **Selenium Grid** is a tool used together with Selenium RC to run parallel tests across different machines and different browsers all at the same time. 
  

## Selenium VS QTP
![image](https://user-images.githubusercontent.com/53980293/147346403-29f54da3-ead3-4561-b8f0-4d8233879400.png)
![image](https://user-images.githubusercontent.com/53980293/147346463-afea20f1-69fc-477c-afc6-c5602568c25d.png)


## Selenium WebDriver API Documentation
Link: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html

First we need to set up the driver binary:
`WebDriverManager.chromedriver().setup();`

The driver instance to execute selenium commands:
`WebDriver driver = new WebDriver();`

