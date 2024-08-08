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
```
```
