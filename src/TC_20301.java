import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_20301 extends BaseDriver {
    @Test
    public void TC_20301() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.cssSelector("[class='ico-login']"));
        dAct.moveToElement(login).click().build().perform();

        WebElement email = driver.findElement(By.id("Email"));
        dAct.moveToElement(email).click().sendKeys("testnomads01@gmail.com").build().perform();

        WebElement password = driver.findElement(By.name("Password"));
        dAct.moveToElement(password).click().sendKeys("07Nomad++").build().perform();

        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log in']"));
        dAct.moveToElement(loginButton).click().build().perform();

        WebElement logOut = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        dAct.moveToElement(logOut).click().build().perform();

        WebElement acLogin = driver.findElement(By.linkText("Log in"));
        Assert.assertNotNull("User is not directed to the login page!", acLogin);

        WaitAndClose();
    }
}