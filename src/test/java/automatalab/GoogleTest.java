package automatalab;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	private WebDriver driver;
	private String URL_BASE = "https://www.google.com";
	private String PATH_DRIVE = "C:\\AulaTestes\\Selenium\\automatalab\\src\\test\\resources\\chromedriver.exe";
	
	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@Test
	public void pesquisarNoGoogle() {
		//Cenário
		iniciar();
		
		//Preparação
		WebElement inputPesquisa = driver.findElement(By.name("q"));
		inputPesquisa.sendKeys("jogo do brasil" + Keys.ENTER);
		
		//Execução
		String resultado = driver.findElement(By.id("result-stats")).getText();
		
		//Verificação
		assertTrue(resultado, resultado.contains("Aproximadamente"));
	}
}
