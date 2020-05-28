package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaPrincipalPage {

    private WebDriverWait wait;

    public TelaPrincipalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(how = How.ID, using = "anunciosNovos")
    private WebElement campoCheckboxAnunciosNovos;

    @FindBy(how = How.ID, using = "anunciosUsados")
    private WebElement campoCheckboxAnunciosUsados;

    @FindBy(how = How.XPATH, using = "//*[@title='Marca']")
    private WebElement botaoMarca;

    @FindBy(how = How.XPATH, using ="//*[@title='Marca']/following-sibling::div/div/input")
    private WebElement campoTextoAutocompleteMarca;

    @FindBy(how = How.XPATH, using = "//*[@title='Modelo']")
    private WebElement botaoModelo;

    @FindBy(how = How.XPATH, using ="//*[@title='Modelo']/following-sibling::div/div/input")
    private WebElement campoTextoAutocompleteModelo;

    @FindBy(how = How.LINK_TEXT, using = "alterar")
    private WebElement linkAlterar;

    @FindBy(how = How.ID, using = "localizacaoBR")
    private WebElement campoCheckRadioTodoOBrasil;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Buscar')]")
    private WebElement botaoBuscar;

    private String URL_PAGINA_INICIAL_ICARROS = "https://www.icarros.com.br/principal/index.jsp";


    public void acessarPaginaInicial (WebDriver driver){
        driver.navigate().to(URL_PAGINA_INICIAL_ICARROS);
    }

    public void desmarcarAnunciosNovos(){
        wait.until(ExpectedConditions.visibilityOf(campoCheckboxAnunciosNovos));
        campoCheckboxAnunciosNovos.click();
    }

    public void selecionarMarca(String marca, WebDriver driver){
        botaoMarca.click();

        wait.until(ExpectedConditions.elementToBeClickable(campoTextoAutocompleteMarca));
        campoTextoAutocompleteMarca.click();
        campoTextoAutocompleteMarca.sendKeys(marca);
        driver.findElement(By.xpath("//*[@title='Marca']/following::div/ul/li/a/span[text()='" + marca + "']")).click();
    }

    public void selecionarModelo(String modelo, WebDriver driver){
       wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(botaoModelo, "aria-disabled","true")));
        botaoModelo.click();
        campoTextoAutocompleteModelo.click();
        campoTextoAutocompleteModelo.sendKeys(modelo);
        driver.findElement(By.xpath("//*[@title='Modelo']/following-sibling::div/ul/li/a/span[text()='" + modelo + "']")).click();
    }

    public void selecionarAlterarLocalizacao(String localizacao){
        wait.until(ExpectedConditions.visibilityOf(linkAlterar));
        linkAlterar.click();
        if (localizacao.equals("TodoBrasil")){
            selecionarPesquisarLocalizacaoEmTodoBrasil();
        }
    }

    public void selecionarPesquisarLocalizacaoEmTodoBrasil(){
        wait.until(ExpectedConditions.visibilityOf(campoCheckRadioTodoOBrasil));
        campoCheckRadioTodoOBrasil.click();
    }

    public void clicarBotaoBuscar(){
        botaoBuscar.click();
    }




}
