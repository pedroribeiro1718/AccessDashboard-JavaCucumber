## Authenticating, accessing the dashboard and the "pending review" page

This is a test-automation demo utilizing the following stack:
- Java
- Selenium
- Cucumber
- JUnit 4

It showcases the following techniques:
- Obtaining elements mainly by combining CSS selectors, which is potentially more stable and resilient to layout changes than automatically generated XPaths.
- Asserting the presence of elements by way of standard Java types such as ArrayList. In the present example, this is used to ensure that the "dashboard" page of the testing playground contains all the expected widgets.

## Authorship

- Uses https://opensource-demo.orangehrmlive.com as a testing playground
- Developed in collaboration with [Coti Informática](http://cotiinformatica.com.br)