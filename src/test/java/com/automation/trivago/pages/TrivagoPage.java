package com.automation.trivago.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TrivagoPage {

    private WebDriver navegador;

    //mapear elementos
    private By campoPesquisa = By.id("input-auto-complete");
    private By botaoPesquisar = By.className("SearchButton_floatingSearchButton__ywzpY");
    private By BotaoOrdenar = By.id("sorting-selector");






    public TrivagoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    //metodos de interaçao com a pagina
    public void preencherPesquisa(String pesquisa) {
        WebElement inputPesquisa = navegador.findElement(campoPesquisa);
        inputPesquisa.sendKeys(pesquisa);
    }

    public void clicarPesquisar() {
        WebElement btnPesquisar = navegador.findElement(botaoPesquisar);
        btnPesquisar.click();
    }

    public void selecionarCombo() {

        WebElement comboBoxElement = navegador.findElement(By.id("sorting-selector"));
        Select comboBox = new Select(comboBoxElement);

        comboBox.selectByIndex(1);

    }

    public void validaHotel() {

        WebElement primeiroHotel = navegador.findElement(By.cssSelector("li[data-testid='accommodation-list-element']"));

        // 4. Verifique o nome do primeiro da lista
        String nomeDoHotel = primeiroHotel.findElement(By.cssSelector("button[data-testid='item-name'] span")).getText();
        System.out.println("Nome do hotel: " + nomeDoHotel);

        // 5. Verifique a avaliação do primeiro da lista
        String avaliacaoDoHotel = primeiroHotel.findElement(By.cssSelector("span[data-testid='aggregate-rating'] span[itemprop='ratingValue']")).getText();
        System.out.println("Avaliação do hotel: " + avaliacaoDoHotel);

        // 6. Verifique o valor do primeiro da lista
        String valorDoHotel = primeiroHotel.findElement(By.cssSelector("div[itemprop='priceSpecification'] p[data-testid='recommended-price']")).getText();
        System.out.println("Valor do hotel: " + valorDoHotel);

}
 }
