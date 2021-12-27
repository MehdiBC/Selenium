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

  |                       Pros                             |                                Cons                                |
  | ------------------------------------------------------ | ------------------------------------------------------------------ |
  | + Very easy to use and install                         |     - Designed only for prototypes of tests                        | 
  | + No programming knowledge is required though knowledge of HTML and DOM is needed         |     - No support for iterations and conditional operations         | 
  | + Can export tests to formats to be used by WebDriver and Selenium RC    |     - Test execution is slow compared to WebDriver and Selenium RC                  |                                                                           
  | + Generates reports of tests results                   |                                                                    |
  | + Provides support for extensions                      |                                                                    |     

    
## Selenium WebDriver
**WebDriver** is a web automation framework.
It allows you to execute your tests against different browsers using a programming language. You can now perform iterations and conditional operations.

  - It controls the browser from the OS level
  - You can use different programming languages
  - Testing web applications across different browsers
  
Read more on the WebDriver architecture: https://www.browserstack.com/guide/selenium-webdriver-tutorial

## Selenium RC
**Selenium RC** (*Depricated from selenium 3.0*) is a test automation tool supporting different programming languages.
It comprises of two parts: 
  - Client libraries for the prefered computer language
  - Server that launches and kills browsers automatically

## WebDriver VS Selenium RC
  - WebDriver is faster than Selenium RC because it has a simpler achitecture ( WebDriver interacts with the Browser through the operating system )
  - WebDriver's API is more concise than Selenium RC's.
  
## Selenium Grid
  **Selenium Grid** is a tool used to run parallel tests across different machines and different browsers all at the same time. 
  

## Selenium VS QTP
![image](https://user-images.githubusercontent.com/53980293/147346403-29f54da3-ead3-4561-b8f0-4d8233879400.png)
![image](https://user-images.githubusercontent.com/53980293/147346463-afea20f1-69fc-477c-afc6-c5602568c25d.png)


## Selenium WebDriver API Documentation
Link: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html

### First we need to set up the driver binary:
`WebDriverManager.chromedriver().setup();`

### The driver instance to execute selenium commands:
`WebDriver driver = new WebDriver();`

### Navigation:
`driver.get(URL_STRING)`\
`driver.navigate().to(URL_STRING)`

### Get information on current document:
`driver.getCurrentUrl()`\
`driver.getTitle()`

### Forward, Backward and Refresh:
`driver.forward()`\
`driver.back()`\
`driver.refresh()`

### Create and switch to a new window / tab:
`driver.switchTo().newWindow(WindowType.WINDOW)`\
`driver.switchTo().newWindow(WindowType.TAB)`

### Close a window:
`driver.close()`: Closes only the current window. The WebDriver session remains active.\
`driver.quit()`: Closes all opened windows and ends the WebDriver session.

### Resize window:
```
driver.manage().window().minimize();
driver.manage().window().maximize();
driver.manage().getSize().getHeight(); 
driver.manage().getSize().getWidth();
```

### Screenshots:
```
File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File elementScreenshotFile = element.getScreenshotAs(OutputType.FILE);
```

### Javascript:
```
JavascriptExecutor js = (JavascriptExecutor)driver;
WebElement button = driver.findElement(By.id("submit"));
js.executeScript("argument[0].click();", button); // executing script
```

### Locating elements:
```
try {
  WebElement element = driver.findElement(By.id()); // finding one element by id.
} catch(NoSuchElementException nse) {
  nse.printStackTrace();
}
```
```
List<WebElement> elements = driver.findElements(By.className()); 
// finding elements by class name. findElements returns an empty list object if elements not found.
```
![image](https://user-images.githubusercontent.com/53980293/147493762-5820efa0-6917-4197-9d0d-57ee7784f95d.png)
`driver.findElement(RelativeLocator.with(By.tagName("input")).above(buttonRecherche)` finding element which is above / near / toLeft or toRight of a referenced element.

## Implicit wait Vs Explicit wait:
### Implicit wait:
Implicit Wait directs the Selenium WebDriver to wait for a certain measure of time before throwing an exception. Once this time is set, WebDriver will wait for the element before the exception occurs.\
Once the command is in place, Implicit Wait stays in place for the entire duration for which the browser is open. It’s default setting is 0, and the specific wait time needs to be set by the following protocol.
```
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

### Explicit wait:
By using the Explicit Wait command, the WebDriver is directed to wait until a certain condition occurs before proceeding with executing the code.
```
WebDriverWait waitVar = new WebDriverWait(driver, TIMEOUT);
try {
  waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
  driver.findElement(By.id("username")).sendKeys("Mehdi");
} catch(TimeoutException timeoutException) {
  timeoutException.printStackTrace();
}
```

Reference https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
