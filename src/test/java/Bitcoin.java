import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Bitcoin extends BaseTest{
    Date date = new Date();
    String URL = "https://www.investing.com/crypto/bitcoin";
    String currentCourse = "";
    String deviation = "";
    String percent = "";
    String writeLine = "";
    @Test
    public void readValues(){
        getDriver().get(URL);
        currentCourse = getDriver().findElement(By.cssSelector("span[id='last_last']")).getText();
        deviation = getDriver().findElement(By.xpath("//span[2][@dir='ltr']")).getText();
        percent = getDriver().findElement(By.xpath("//span[contains(@class, 'arial_20')]/following-sibling::span[2]")).getText();
        writeLine = (currentCourse + "   " + deviation + "   "+ percent + "   " + date.toString());
        System.out.println(writeLine);

        try(FileWriter writer = new FileWriter("data/bitcoin.txt", true))
        {
            writer.write(writeLine);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

