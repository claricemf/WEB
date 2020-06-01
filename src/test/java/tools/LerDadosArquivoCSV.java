package tools;

import com.opencsv.CSVReader;
import model.ResultadoConsulta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.lang.*;

import static org.junit.Assert.assertEquals;

public class LerDadosArquivoCSV {

    public static void readDataLineByLine(String CSV_FILE_PATH, WebDriver driver) {
        try {
            // Create an object of filereader class
            // with CSV file as a parameter.
            FileReader filereader = new FileReader(CSV_FILE_PATH);

            // create csvReader object passing
            // filereader as parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            int i = 1;
            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                String cell = nextRecord[0];

                System.out.println("Cell0: " + cell);

                String[] textoSeparado = cell.split(";");

                ResultadoConsulta resultadoConsulta = new ResultadoConsulta();
                resultadoConsulta.setMarca(textoSeparado[0]);
                resultadoConsulta.setModelo(textoSeparado[1]);
                resultadoConsulta.setAno(textoSeparado[2]);
                resultadoConsulta.setKm(textoSeparado[3]);
                resultadoConsulta.setCor(textoSeparado[4]);
                resultadoConsulta.setCambio(textoSeparado[5]);
                resultadoConsulta.setValorTratado(textoSeparado[6]);

                resultadoConsulta.imprimirDados();


                String marca = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/a/h2/span/span")).getText();
                String modelo = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/a/h2")).getText();
                String ano = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/div[2]/div[1]/a/ul/li[1]/p")).getText();
                String km = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/div[2]/div[1]/a/ul/li[2]/p")).getText();
                String cor = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/div[2]/div[1]/a/ul/li[3]/p")).getText();
                String cambio = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/div[2]/div[1]/a/ul/li[4]/p")).getText();
                String valor = driver.findElement(By.xpath("//*[contains(@class, \"anuncio anuncio_1ª_prioridade\")][" + String.valueOf(i) + "]/div/a/h3")).getText();
                String valotTratado = valor.substring(0, 9);
                i++;


                assertEquals(resultadoConsulta.getMarca(), marca);
                assertEquals(resultadoConsulta.getModelo(), modelo);
                assertEquals(resultadoConsulta.getAno(), ano);
                assertEquals(resultadoConsulta.getKm(), km);
                assertEquals(resultadoConsulta.getCor(), cor);
                assertEquals(resultadoConsulta.getCambio(), cambio);
                assertEquals(resultadoConsulta.getValorTratado(), valotTratado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
