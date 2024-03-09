import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_20101 extends BaseDriver {
    @Test
    public void TC_20101() {
        driver.get("https://demowebshop.tricentis.com/");
        MyFunction.Wait(1);

        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        MyFunction.Wait(1);

        WebElement gender = driver.findElement(By.name("Gender"));
        gender.click();
        MyFunction.Wait(1);

        WebElement name = driver.findElement(By.id("FirstName"));
        name.sendKeys("Test");
        MyFunction.Wait(1);

        WebElement surName = driver.findElement(By.cssSelector("input[id='LastName']"));
        surName.sendKeys("Nomads");
        MyFunction.Wait(1);

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("testnomads01@gmail.com");

        WaitAndClose();
    }
}