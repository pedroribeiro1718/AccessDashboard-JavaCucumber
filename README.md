## Authenticating, accessing the dashboard and the "pending review" page

This is a test-automation demo utilizing the following stack:
- Java
- Selenium Web Driver
- Cucumber
- JUnit 4

## Techniques

- Obtaining elements mainly by combining CSS selectors, which is potentially more stable and resilient to layout changes than automatically generated XPaths.  When XPath is used, instead of copying auto-generated values, we follow a more intentional logic so as to ensure the same level of resilience to layout changes.
	
- Asserting the presence of elements by accumulating meaningful semantic information into a standard Java ArrayList, and then comparing that information to our expected results. This is used to ensure that the "dashboard" page of the testing playground contains *all* the expected widgets. I'd argue that, at least for some situations, this is better than just "sampling" one or two page elements.

## Authorship

- Uses https://opensource-demo.orangehrmlive.com as a testing playground.
- Developed in collaboration with [Coti Informática](http://cotiinformatica.com.br).