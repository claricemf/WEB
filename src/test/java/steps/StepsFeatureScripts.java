package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.TelaPrincipalPage;
import pageObjects.TelaResultadoConsultaPage;

import java.io.IOException;

public class StepsFeatureScripts {
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
        TelaResultadoConsultaPage telaResultadoConsultaPage = new TelaResultadoConsultaPage(driver);
        telaResultadoConsultaPage.validoResultadoDoisPrimeirosRegistros();
    }

    @And("Crio arquivo de dados com resultados da primeira pagina")
    public void crioArquivoDeDadosComResultadosDaPrimeiraPagina() throws IOException {
        TelaResultadoConsultaPage telaResultadoConsultaPage = new TelaResultadoConsultaPage(driver);
        telaResultadoConsultaPage.geraArquivoResultadoConsultaPrimeiraPagina(driver);
    }

    @And("Leio o arquivo de resultados e valido os dados com a consulta")
    public void leioArquivoResultadoEValidoDadosComConsulta(){
        TelaResultadoConsultaPage telaResultadoConsultaPage = new TelaResultadoConsultaPage(driver);
        telaResultadoConsultaPage.lerArquivoResultaConsultaPrimeiraPagina(driver);
    }

}
