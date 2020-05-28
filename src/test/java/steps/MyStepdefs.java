package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.TelaPrincipalPage;

import java.io.File;
import java.io.IOException;

public class MyStepdefs {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\workspace-teste\\src\\test\\resources\\driver\\windows\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
    }

    @Given("Acesso a tela inicial do sistema")
    public void acessoATelaInicialDoSistema() {
        TelaPrincipalPage telaPrincipalPage = new TelaPrincipalPage(driver);
        telaPrincipalPage.acessarPaginaInicial(driver);
    }

    @And("Seleciono somente o tipo de anuncio de carro usado")
    public void selecionoSomenteTipoAnuncioUsado(){
        TelaPrincipalPage telaPrincipalPage = new TelaPrincipalPage(driver);
        telaPrincipalPage.desmarcarAnunciosNovos();
    }

    @And("^Seleciono as opcoes de marca(.*) modelo(.*) e localizacao(.*)$")
    public void selecionoOpcoesMarcaModeloLocalizacao(String marca, String modelo, String localizacao){
        TelaPrincipalPage telaPrincipalPage = new TelaPrincipalPage(driver);
        telaPrincipalPage.selecionarMarca(marca, driver);
        telaPrincipalPage.selecionarAlterarLocalizacao(localizacao);
        telaPrincipalPage.selecionarModelo(modelo, driver);
        telaPrincipalPage.clicarBotaoBuscar();
    }

    @And("Valido os dados dos dois primeiros registros")
    public void validoDadosDoisPrimeirosRegistros(){

    }

    @And("Crio arquivo de dados com resultados da primeira pagina")
    public void CrioArquivoDeDadosComResultadosDaPrimeiraPagina(){

    }

    @And("Valido os dados com arquivo excel ")
    public void validoDadosComArquivoExcel(String path){

    }

}
