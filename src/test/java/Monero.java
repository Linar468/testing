import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Monero extends BaseTest{
    Date date = new Date();
    String URL = "https://investing.com/crypto/monero";
    String currentCourse = "";
    String deviation = "";
    String percent = "";
    String writeLine = "";


    @Test(priority = 1)
    public void readValues(){
        getDriver().get(URL);
        currentCourse = getDriver().findElement(By.cssSelector("span[id='last_last']")).getText();
        deviation = getDriver().findElement(By.xpath("//span[2][@dir='ltr']")).getText();
        percent = getDriver().findElement(By.xpath("//span[contains(@class, 'arial_20')]/following-sibling::span[2]")).getText();
        writeLine = (currentCourse + "   " + deviation + "   "+ percent + "   " + date.toString());
        System.out.println(writeLine);
    }
    @Test (priority = 2)
    public void write(){
        try(FileWriter writer = new FileWriter("monero.txt", true))
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
