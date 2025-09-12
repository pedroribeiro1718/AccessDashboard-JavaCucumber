package com.qa.pribeiro.exercicioAula02.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/qa/pribeiro/exercicioAula02/features",
		glue = "com.qa.pribeiro.exercicioAula02.steps",
		plugin = { "pretty", "html:target/cucumber-report.html" }
		)
public class Runner {
	
}
