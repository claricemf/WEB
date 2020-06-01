package tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CapturarTela {

    public void capturarTela(WebDriver webdriver, String nomeTela) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HHmmss");
        String data = LocalDateTime.now().format(formatter);
        String fileWithPath = "src/test/resources/evidencias/capturaTela/" +nomeTela+"/"+ data + nomeTela +".png";

        System.out.println(fileWithPath);

        // Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File DestFile = new File(fileWithPath);



        // Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
