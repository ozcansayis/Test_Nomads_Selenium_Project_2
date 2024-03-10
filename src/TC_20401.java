import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC_20401 extends BaseDriver {
    @Test
    public void TC_20401() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        dAct.moveToElement(login).click().build().perform();

        WebElement email = driver.findElement(By.cssSelector("input[id='Email']"));
        dAct.moveToElement(email).click().sendKeys("testnomads01@gmail.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        dAct.moveToElement(password).click().sendKeys("07Nomad++").build().perform();

        WebElement login2 = driver.findElement(By.cssSelector("input[value='Log in']"));
        dAct.moveToElement(login2).click().build().perform();

        List<WebElement> logoutButton = driver.findElements(By.xpath("//a[text()='Log out']"));
        Assert.assertFalse("Login failed!", logoutButton.isEmpty());

        WaitAndClose();
    }
}
