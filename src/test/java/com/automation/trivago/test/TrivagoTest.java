package com.automation.trivago.test;

import com.automation.trivago.core.DriverFactory;
import com.automation.trivago.pages.TrivagoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DisplayName("Teste acesso ao Trivago")
public class TrivagoTest {




    private WebDriver navegador;
    private TrivagoPage trivago;
    private DriverFactory driverFactory;




    @BeforeEach
    public void setUp() {
        driverFactory = new DriverFactory();
        navegador = driverFactory.initWebDriver();
        trivago = new TrivagoPage(navegador);


        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driverFactory.openSite("https://www.trivago.com.br/");


    }

    @Test
    public void testBuscaTrivago() throws InterruptedException {

        trivago.preencherPesquisa("Manaus");
        Thread.sleep(5000);
        trivago.clicarPesquisar();
        Thread.sleep(5000);
        trivago.clicarPesquisar();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        Thread.sleep(10000);
        trivago.selecionarCombo();
        Thread.sleep(5000);
        trivago.validaHotel();


    }

}