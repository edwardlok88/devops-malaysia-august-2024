# Day 4

## Functional Testing Overview
<pre>
- Whether the feature is working as per customer's requirement will be verified
- This doesn't focus on the performance aspect
- For instance, when we test a add method that computes addition of two double numbers, 2.0 + 5.0 should yield a resule of 7.0 is the functional testing 
- But if the 7.0 result is computed in 10 mintues, that is not verified in the functional testing
</pre>

## Non-Functional Testing Overview
<pre>
- Performance
- Usability
- user experience
- stability
- how the application performance when multiple users use the production at the time
- how many users can simultaneous use the product without seeing a performance degradation
- how security is it
  - database behind firewall, proxy
  - encyrption/decryption
  - ssl termination ( https )
  - certificates
</pre>

## TDD Overview
<pre>
- Test Driven Development
- is followed by Developers to automate Unit and Integration testing
- the test cases can only be understood by technically hands-on members
- Customers may not be able to review or understand these test cases
</pre>  

## BDD Overview
<pre>
- Behaviour Driven Development is generally used by QA team
- Non-technical members can also understand these cases as BDD uses an English like or spoken languages
- uses a Gherkin
  - supports many spoken languages
- Customers can also review or write these test cases
- In some cases, customers provide the acceptance criteria in the form of BDD test cases
- In some companies that follow Agile(SCRUM), the user stories or captures as BDD scenarios
- This is widely used in the industry
- Technically even unit, integration test cases can also be written using BDD but generally BDD test cases are end to end functionality test cases
- Examples
  - C/C++ - Cucumber Framework
  - Java - Cucumber Framework
  - C# - Specflow Framework ( C# native implementation of Cucumber Framework )
</pre>

## Selenium Overview
<pre>
- is a Framework that helps testing web applications
- normally used to test web applications on multiple web browsers
- supports Browser drivers for different Web browsers
  - Chrome Driver
  - Firefox Driver
</pre>

# What is BDD?
- Behaviour Driven Development
- Works similar to TDD
- BDD Test case scope
  - End to End Functionality Test
  - Performance Test
  - Smoke Test
  - Regression Test
  - Stress/Load Test

## BDD vs TDD?

Test Driven Development (TDD)
- Test First Approach
- is used by Developers to automate Unit/Integration Testing
- in this approach, the Developers start with one test case at a time and develop the application code as driven by the test cases.
- TDD always with a failing test case as the actual app code isn't developed initially
- To make the test case, we write minimal application code
- Once we are satisfied with the functionality and all different scenaries works as expected, we then review the code looking for code smells, refactor them to clean code
Drawbacks
- as the TDD test cases requires programming knowledge to understand, customers or the business folks, top management may not understand in case they aren't technical

## BDD Frameworks
- Test First Approach - test case will be written prior the application code development
- is used by QA Engineers to automate end-2-end Functionality test, Component Test, API Test, pretty much all the types of test that QA performs can be automated with BDD Test Frameworks
- Advantage
  - as the BDD test cases(scenarios) are written in a special Gherkin language ( supports more than 70 spoken language )
  - non-technical people can also understand BDD test cases as opposed to TDD cases which can only be understood if you are technially hands-on
 
Examples
- Cucumber - C/C++, Java, Ruby
- Specflow - C# ( It depends on NUnit/Moq for writing technical part of the test case )
  
## What is Gherkin?
- a simple language that a subset of spoken languages
- it uses a minimal set of keywords like
    - Feature
    - Scenario
    - Given
    - When
    - Then
    - And
    - Not
 
## Can I use Specflow for TDD?
- Yes, you can very well use Specflow for TDD for automating Developer test cases

## How a sample BDD Test case would look like
<pre>
Let's say, we need to create a new gmail account.

Feature : Gmail
   Gmail allows new user registration, checking and sending emails.

   Scenario: For new gmail account registration when you provide valid name and surname, it should take you to Basic info page
      Given I navigate to https://accounts.google.com/signup/v2/createaccount?flowName=GlifWebSignIn&flowEntry=SignUp
      And I type Firstname as "Bruce"
      And I type Surname as "Lee"
      When I click on Next button
      Then I expect to see the Basic Information Page
</pre>



# Selenium WebDriver Code Snippets

## Creating Chrome Web browser driver
```
ChromeDriver chromeDriver = new ChromeDriver();
```

## Navigating to a website URL using the web browser driver object
```
chromeDriver.Url = "www.google.com"
driver.Navigate();
```

## Assuming we are in web page and we would like to click on the back page
```
driver.Navigage().Back()
```

## Assuming we are in web page and we would like to click on the Forward page
```
driver.Navigage().Forward()
```

## Assuming we are in web page and we would like to refresh the page
```
driver.Navigate().Refresh()
```

## Retrieve Web page Elements by XPath
```
IWebelement element = driver.FindElement(By.xpath("xpath of our webelement));
```

### Retrieve Web page elements by Id
```
IWebelement element = driver.FindElement(By.Id("id of our webelement));
```

## Select values from a Combo box (Dropdown) control
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElement(element);
select.SelectByText("TekTutor");
```

## Dropdown control Select By Index
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElemnt(element);
select.SelectByIndex("4");
```

## Dropdown control Select By Value
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElemnt(element);
select.SelectByValue("TekTutor");
```

## Retrieving all the options from a dropdown control
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElement(element);

List<IWebelement> choices = select.Options;
int size = options.Count;
String value;
for (int index=0; index<options.size(); ++index) {
  value = size.elementAt(index).Text
  Console.WriteLine(value); //Just for debugging purpose
}
```

## Verifying if multi-select is supported by a dropdown control
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElement(element);

Boolean isMultiSelectSupported = select.IsMultiple();
```

## Clearing all selects from dropdown element
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElement(element);
select.DeSelectAll();
```

## Clearing all selects from dropdown element By Index
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElement(element);
select.DeSelectByIndex("2");
```

## Clearing all selects from dropdown element By Value
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElement(element);
select.DeSelectByValue("TekTutor");
```

## Clearing all selects from dropdown element By Value
```
IWebelement element = driver.FindElement(By.Id("control-id"));
SelectElement select = new SelectElement(element);
select.DeSelectByText("TekTutor");
```


## Ultimate QA Feature file
```
Feature: UltimateQAPortal

This web portal has many test components that can be used for learning Specflow with Selenium BDD Test framework

@elementByItsId
Scenario: Retrieve Element by Id and sending click event
	Given I opened Chrome Web browser
	When  navigate to "https://www.ultimateqa.com/simple-html-elements-for-automation";
	Then it should take me to the success web page
	And Its title should be "Button success - Ultimate QA"

@elementByItsClassName
Scenario: Retrieve Button Element by its className and sending click event
	Given I opened Chrome Web browser
	And  navigate to "https://www.ultimateqa.com/simple-html-elements-for-automation";
	And I click the button with className "buttonClass"
	Then it should take me to the success web page with url "https://ultimateqa.com/button-success?"
	And Its title should be "Button success - Ultimate QA"

@elementByItsName
Scenario: Retrieve Button Element by its Name and sending click event
	Given I opened Chrome Web browser
	And  navigate to "https://www.ultimateqa.com/simple-html-elements-for-automation";
	And I click the button with Name "button1"
	Then it should take me to the success web page with url "https://ultimateqa.com/button-success/?button1="
	And Its title should be "Button success - Ultimate QA"

@elementByLinkText
Scenario: Retrieve anchor Element by its link text and sending click event
	Given I opened Chrome Web browser
	And  navigate to "https://www.ultimateqa.com/simple-html-elements-for-automation";
	And I click the anchor link that has a text "Click me using this link text!"
	Then it should take me to the success web page with url "https://ultimateqa.com/link-success/"
	And Its title should be "Link success - Ultimate QA"


@elementByType
Scenario: Select a value from drop down list and retrieve its value
	Given I opened Chrome Web browser
	And  navigate to "https://www.ultimateqa.com/simple-html-elements-for-automation";
	When I select a value "Opel" from the drop down
	Then it should shown the "Opel" option in the top of the drop down list
```

## Orange HRM BDD Feature file
```
Feature: OrangeHRM

A short summary of the feature

@addnewuser
Scenario: Create new admin user in Orange HRM 
	Given I have successfully logged in as Administrator in Orange HRM website
	When I click on Admin menu and Add new Admin user
	Then I should be able to create a new admin user
```

## Orange HRM BDD Steps Definition
```
using OpenQA.Selenium;
using System;
using TechTalk.SpecFlow;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System.Xml.Linq;

namespace OrangeHRMBDD.StepDefinitions
{
    [Binding]
    public class OrangeHRMStepDefinitions
    {
        private IWebDriver _driver;
        private String randomUsername;

        [Before]
        public void InitializeBeforeEachScenario()
        {
            _driver = new ChromeDriver();
        }

        [After]
        public void CloseBrowserWindow()
        {
            _driver.Close();
            _driver.Dispose();
        }


        [Given(@"I have successfully logged in as Administrator in Orange HRM website")]
        public void GivenIHaveSuccessfullyLoggedInAsAdministratorInOrangeHRMWebsite()
        {
            _driver.Navigate().GoToUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            //When the browser window is not fullscreen, it is possible the dynamic html elements we are trying
            //to find might be invisible, hence we need to ensure the browser window is maximized
            _driver.Manage().Window.FullScreen();

            //Delay for 3 seconds
            Thread.Sleep(3000);

            //username
            var userField = _driver.FindElement(By.XPath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
            userField.SendKeys("Admin");
            
            //password
            var passwordField = _driver.FindElement(By.XPath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
            passwordField.SendKeys("admin123");

            var loginButton = _driver.FindElement(By.XPath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
            loginButton.Click();
        }


        private string GenerateRandomName()
        {
            const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

            Random random = new Random();

            return new string(Enumerable.Repeat(chars, 5).Select(name => name[random.Next(name.Length)]).ToArray());
        }

        [When(@"I click on Admin menu and Add new Admin user")]
        public void ThenAddANewuser()
        {

            _driver.Manage().Window.FullScreen();
            Thread.Sleep(3000);


            var adminMenu = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
            adminMenu.Click();

            //Delay for 3 seconds
            Thread.Sleep(3000);

            var addButton = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
            addButton.Click();

            _driver.Manage().Window.FullScreen();
            Thread.Sleep(3000);

            var typeOfUser = _driver.FindElements(By.XPath("//div[@class=\"oxd-select-text oxd-select-text--active\"]")).FirstOrDefault();
            typeOfUser.Click();
            Thread.Sleep(3000);
            var choosetypeofuser = _driver.FindElements(By.XPath("//div[@role=\"listbox\"]")).FirstOrDefault();
            var textForChoosetypeofuser = choosetypeofuser.FindElements(By.TagName("div"));
            textForChoosetypeofuser[1].Click();


            var employeename = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
            employeename.SendKeys("Dominic Chase");
            Thread.Sleep(3000);
            var chooseEmployee = _driver.FindElements(By.XPath("//div[@role=\"listbox\"]")).FirstOrDefault();
            var textchooseEmployee = chooseEmployee.FindElements(By.TagName("div"));
            textchooseEmployee[0].Click();

            var statusElement = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]"));
            statusElement.Click();
            var chooseStatus = _driver.FindElements(By.XPath("//div[@role=\"listbox\"]")).FirstOrDefault();
            var textChooseStatus = chooseStatus.FindElements(By.TagName("div"));
            textChooseStatus[1].Click();

            var username = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));

            randomUsername = "Yourname" + GenerateRandomName();
            
            username.SendKeys(randomUsername);

            var pass1 = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
            pass1.SendKeys("auth123");

            var pass2 = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
            pass2.SendKeys("auth123");

            _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).Click();
            _driver.Manage().Window.FullScreen();
            Thread.Sleep(5000);
        }

        [Then(@"I should be able to create a new admin user")]
        public void then()
        {
            _driver.Manage().Window.FullScreen();

            //We are forcing a delay of 5 secs, this may not work on all systems at all times
            //Thread.Sleep(5000);

            //As an alternate, Let's wait until page is loaded using Javascript
            var timespan = TimeSpan.FromMilliseconds(TimeoutMillis);
            new WebDriverWait(_driver, timespan).Until(
               e => ((IJavaScriptExecutor)e).ExecuteScript("return document.readyState").Equals("complete")
            );


            var searchUsername = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
            searchUsername.SendKeys(randomUsername);

            var searchButton = _driver.FindElement(By.XPath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
            searchButton.Click();

            _driver.PageSource.ToString().Contains(randomUsername);
            _driver.PageSource.ToString().Contains("Admin");

        }

    }
}
```

## JMeter Overview
<pre>
- is developed in Core Java but supports performing functional and performance testing of applications developed in any programming language
- supports Testing stand-alone applications, web applications, etc.,
- supports load, stress testing
- is an opensource tool
</pre>

## Cucumber Performance Overview
<pre>
- Cucumber BDD framework also supports a new framework called cucumber-performance ( performance library ) 
- Hence, it is possible to perform performance testing products developed in most popular programming languages with Cucumber + Cucumber performance library/framework 
</pre>

## Lab - Installing JMeter in Linux
```
cd ~
wget https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.6.3.tgz
tar xvfz apache-jmeter-5.6.3.tgz
cd apache-jmeter-5.6.3/bin
```

## Info - Installing JMeter in Windows/Mac
You can download, unzip and start using JMeter as it is in Linux, Mac OS-X or Windows.  The JMeter testing tool comes as an java jar file which works on any OS, hence the installation procedure is same for all OS.
```
https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.6.3.zip
```

## Info - Official Jmeteral documentation for further learning
<pre>
https://jmeter.apache.org/usermanual/index.html  
</pre>

## Lab - Launching JMeter Testing application
```
cd ~/apache-jmeter-5.6.3/bin
java -jar ./ApacheJMeter.jar
```

Expected output
![image](https://github.com/user-attachments/assets/0107f94d-f844-451e-b999-ecb1b01f4b2d)
![image](https://github.com/user-attachments/assets/203b733b-59be-40a5-b856-28dcb471be3b)
![image](https://github.com/user-attachments/assets/c708dae8-83f9-48ac-a06f-0c415a80c00c)


## Lab - Create your first test plan in JMeter test application
We will try access the OrangeHRMS applicaiton at url https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

In JMeter, right click the Test Plan
![image](https://github.com/user-attachments/assets/c5c6fcf8-2de5-4ce5-af85-98e7ca7ca624)
Add ThreadGroup
![image](https://github.com/user-attachments/assets/2b8961a0-d3bc-4c1d-a69b-b46000cb1f68)
Update the ThreadGroup as shown below
![image](https://github.com/user-attachments/assets/916fd865-68c6-4e4c-9158-fbe86a4afccd)
Right click on the ThreadGroup and add a HttpRequest under sampler
![image](https://github.com/user-attachments/assets/e8ded43e-195d-412e-a8da-917b6a4a8be6)
![image](https://github.com/user-attachments/assets/3cba6d77-cbe3-4e38-b009-4f1acfa00335)
![image](https://github.com/user-attachments/assets/fd268a2d-3b20-4563-a207-b1a04870f824)

Right click the ThreadGroup and Add a Listener named "View Results Tree" as shown below
![image](https://github.com/user-attachments/assets/d63f89f2-849c-4fe2-a011-b8ab82b57b65)
![image](https://github.com/user-attachments/assets/85c3bf9f-b878-481f-a8a2-003a1db4d222)

File Menu --> Save Test Plan as
![image](https://github.com/user-attachments/assets/e761b7a5-ce38-4c48-aeea-302ba640caf2)
![image](https://github.com/user-attachments/assets/586eb4ab-9f44-4b89-aa27-4f40370e962d)
Click Save
![image](https://github.com/user-attachments/assets/b6940345-aa45-4514-980f-871d7c4aee55)


In the JMeter Test application, click on the Green start button to run the test plan
![image](https://github.com/user-attachments/assets/c8d230c4-16e8-446e-9134-3b63af18b0f9)

You can view the Test execution output under the View Results Tree
![image](https://github.com/user-attachments/assets/4c1d43df-603c-44b3-9056-91bb144d5472)
![image](https://github.com/user-attachments/assets/8ffbc99e-a9a5-4f8b-bac9-391d450278d0)
![image](https://github.com/user-attachments/assets/d177fae9-e895-4835-a07a-6d9ddc4613b9)
![image](https://github.com/user-attachments/assets/1629190a-df70-4031-9cae-dd8706608b69)
![image](https://github.com/user-attachments/assets/581cfe88-d72f-4269-a74d-734d7dd73189)
