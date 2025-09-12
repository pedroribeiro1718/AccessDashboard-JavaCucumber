package com.qa.pribeiro.exercicioAula02.helpers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenshotHelper {
	public static void captureScreenshot(WebDriver driver, String scenario) {
		
		try {
			
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File(scenario + "_" + timestamp + ".png");
			FileUtils.copyFile(srcFile, targetFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
