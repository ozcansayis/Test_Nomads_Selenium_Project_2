import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC_20301 extends BaseDriver {
    @Test
    public void TC_20301() {

        driver.get("https://demowebshop.tricentis.com/");
        Actions demowe = new Actions(driver);

        WebElement login= driver.findElement(By.cssSelector("[class='ico-login']"));
        demowe.moveToElement(login).click().build().perform();
        MyFunction.Wait(1);

        WebElement email= driver.findElement(By.id("Email"));
        demowe.moveToElement(email).click().sendKeys("testnomads06@gmail.com").build().perform();
        MyFunction.Wait(1);

        WebElement password= driver.findElement(By.name("Password"));
        demowe.moveToElement(password).click().sendKeys("07Nomad++").build().perform();

        WebElement loginButton=driver.findElement(By.cssSelector("input[value='Log in']"));
        demowe.moveToElement(loginButton).click().build().perform();
        MyFunction.Wait(1);

        WebElement logOut= driver.findElement(By.xpath("//a[@class='ico-logout']"));
        demowe.moveToElement(logOut).click().build().perform();
        MyFunction.Wait(1);


        WaitAndClose();
    }
}
