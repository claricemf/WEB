package pageObjects;

import model.ResultadoConsulta;
import tools.CapturarTela;
import tools.GeradorDadosArquivoCSV;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.LerDadosArquivoCSV;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.*;

public class TelaResultadoConsultaPage {

    @FindBy(how = How.ID, using = "anunciosForm")
    private WebElement formAnuncios;

    private WebDriverWait wait;

    private static final String CSV_FILE_PATH = "src/test/resources/arquivoDados/DadosConsultaCarrosTestData.csv";

    public TelaResultadoConsultaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 40);
    }

    public void validoResultadoDoisPrimeirosRegistros(WebDriver driver) {
        wait.until(ExpectedConditions.visibilityOf(formAnuncios));

        ResultadoConsulta primeiroCarro = new ResultadoConsulta();
        primeiroCarro.setModelo("Chevrolet Prisma 1.0 SPE/4 Eco Joy");
        primeiroCarro.setValorTratado("R$ 31.975");

        ResultadoConsulta segundoCarro = new ResultadoConsulta();
        segundoCarro.setModelo("Chevrolet Prisma 1.0 SPE/4 Eco Joy");
        segundoCarro.setValorTratado("R$ 31.979");


        String modeloPrimeiroCarro = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(1) + "]/div/a/h2")).getText();
        String valorPrimeiro = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(1) + "]/div/a/h3")).getText();
        String valorPrimeiroCarro = valorPrimeiro.substring(0, 9);

        String modeloSegundoCarro = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(2) + "]/div/a/h2")).getText();
        String valorSegundo = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(2) + "]/div/a/h3")).getText();
        String valorSegundoCarro = valorSegundo.substring(0, 9);

        assertEquals(primeiroCarro.getModelo(), modeloPrimeiroCarro);
        assertEquals(primeiroCarro.getValorTratado(), valorPrimeiroCarro);

        assertEquals(segundoCarro.getModelo(), modeloSegundoCarro);
        assertEquals(segundoCarro.getValorTratado(), valorSegundoCarro);
    }

    public void geraArquivoResultadoConsultaPrimeiraPagina(WebDriver driver) throws IOException {
        List<String[]> Dados = new ArrayList<String[]>();

        wait.until(ExpectedConditions.visibilityOf(formAnuncios));

        CapturarTela capturarTela = new CapturarTela();
        capturarTela.capturarTela(driver, "ResultadoConsulta");

        for (int i = 1; i <= 20; i++) {
            String marca = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/a/h2/span/span")).getText();
            String modelo = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/a/h2")).getText();
            String ano = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/div[2]/div[1]/a/ul/li[1]/p")).getText();
            String km = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/div[2]/div[1]/a/ul/li[2]/p")).getText();
            String cor = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/div[2]/div[1]/a/ul/li[3]/p")).getText();
            String cambio = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/div[2]/div[1]/a/ul/li[4]/p")).getText();
            String valor = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/a/h3")).getText();
            String valotTratado = valor.substring(0, 12);

            String[] data1 = {marca, modelo, ano, km, cor, cambio, valotTratado};

            Dados.add(data1);
        }

        GeradorDadosArquivoCSV geradorDadosArquivoCSV = new GeradorDadosArquivoCSV();
        geradorDadosArquivoCSV.addDataToCSV(CSV_FILE_PATH, Dados);
    }

    public void lerArquivoResultaConsultaPrimeiraPagina(WebDriver driver) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anunciosForm\"]/ul/li[1]/div/a/h3")));
        LerDadosArquivoCSV lerDadosArquivoCSV = new LerDadosArquivoCSV();
        lerDadosArquivoCSV.readDataLineByLine(CSV_FILE_PATH, driver);
    }

}
