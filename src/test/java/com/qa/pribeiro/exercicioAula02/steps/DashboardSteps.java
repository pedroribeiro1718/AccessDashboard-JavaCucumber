package com.qa.pribeiro.exercicioAula02.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.pribeiro.exercicioAula02.helpers.ScreenshotHelper;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class DashboardSteps {
	
	private ChromeDriver driver;
	
	@Dado("que estou na página de login do sistema")
	public void que_estou_na_página_de_login_do_sistema() {
		
		// Configuração para execução dos testes em modo headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // necessário em CI
       	options.addArguments("--no-sandbox"); // necessário em GitHub Actions
       	options.addArguments("--disable-dev-shm-usage"); // necessário em CI/Linux
       	options.addArguments("--remote-allow-origins=*");
       	
		// Abrir o mavegador
		driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com");
	}

	@E("eu informo o nome do usuário {string}")
	public void eu_informo_o_nome_do_usuário(String username) {
		WebElement element = driver.findElement(By.cssSelector("input.oxd-input[name='username']"));
        element.clear();
        element.sendKeys(username);
	}

	@E("eu informo a senha {string}")
	public void eu_informo_a_senha(String password) {
		WebElement element = driver.findElement(By.cssSelector("input.oxd-input[name='password']"));
        element.clear();
        element.sendKeys(password);
	}

	@Quando("eu solicito o acesso ao sistema")
	public void eu_solicito_o_acesso_ao_sistema() {
		WebElement element = driver.findElement(By.cssSelector("button.orangehrm-login-button"));
		element.click();
	}

	@Então("eu sou autenticado com sucesso")
	public void eu_sou_autenticado_com_sucesso() {
		driver.findElement(By.cssSelector("li.oxd-userdropdown"));
		String urlAtual = driver.getCurrentUrl();
		assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", urlAtual);
		ScreenshotHelper.captureScreenshot(driver, "Screenshot - Autenticação bem-sucedida");
	}

	@Dado("que estou na página de dashboard")
	public void que_estou_na_página_de_dashboard() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		String urlAtual = driver.getCurrentUrl();
		assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", urlAtual);
	}

	@Então("o sistema exibe os indicadores principais da aplicação")
	public void o_sistema_exibe_os_indicadores_principais_da_aplicação() {
        List<WebElement> widgetHeaders = driver.findElements(By.cssSelector(".orangehrm-dashboard-widget-header"));
        
        List<String> headerTitles = new ArrayList<>();
        for (WebElement header : widgetHeaders) {
            headerTitles.add(header.findElement(By.tagName("p")).getText());
        }
        
        assertTrue("Did not find all expected header titles. Header titles found: " + headerTitles,
        		headerTitles.containsAll(
	        		List.of(
		        		"Time at Work", 
		        		"My Actions", 
		        		"Quick Launch", 
		        		"Buzz Latest Posts", 
		        		"Employees on Leave Today",
		        		"Employee Distribution by Sub Unit",
		        		"Employee Distribution by Location"
	        		)
        		)
		);
        
		ScreenshotHelper.captureScreenshot(driver, "Screenshot - Acesso ao dashboard principal");
	}

	@Quando("acesso a opção de visualizar reviews de performance pendentes")
	public void acesso_a_opção_de_visualizar_reviews_de_performance_pendentes() {
		WebElement link = driver.findElement(By.xpath(
			    "//div[contains(@class,'orangehrm-todo-list-item')]" + "[.//p[contains(normalize-space(.),'Pending Self Review')]]"
			));
		link.click();
	}

	@Então("o sistema exibe ao menos um review de performance pendente")
	public void o_sistema_exibe_ao_menos_um_review_de_performance_pendente() {
		List<WebElement> rows = driver.findElements(By.cssSelector("div.oxd-table-row--clickable"));
		assertTrue("No clickable table rows found", !rows.isEmpty());
		ScreenshotHelper.captureScreenshot(driver, "Screenshot - Reviews de performance pendentes");
	}
}
