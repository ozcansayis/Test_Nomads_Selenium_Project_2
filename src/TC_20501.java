import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_20501 extends BaseDriver {
    @Test
    public void TC_20501() {
        driver.get("https://demowebshop.tricentis.com");

        WebElement Login = driver.findElement(By.linkText("Log in"));
        dAct.moveToElement(Login).click().build().perform();

        WebElement Longin2 = driver.findElement(By.xpath("//input[@value='Log in']"));
        dAct.moveToElement(Longin2).click().build().perform();

        WebElement msg1 = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul>li"));
        Assert.assertTrue(msg1.getText().contains("No customer account found"));

        WebElement email = driver.findElement(By.cssSelector("input[id='Email']"));
        dAct.moveToElement(email).sendKeys("testnomads01@gmail.com").build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//input[@value='Log in']"))).click().build().perform();
        MyFunction.Wait(1);
        WebElement msg2 = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul>li"));
        Assert.assertTrue(msg2.getText().contains("The credentials provided are incorrect"));

        driver.findElement(By.cssSelector("input[id='Email']")).clear();
        MyFunction.Wait(1);
        dAct.moveToElement(driver.findElement(By.cssSelector("input[type='Password']"))).click().sendKeys("07Nomad++").build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//input[@value='Log in']"))).click().build().perform();
        MyFunction.Wait(1);
        WebElement msg3 = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul>li"));
        Assert.assertTrue(msg3.getText().contains("No customer account found"));

        dAct.moveToElement(driver.findElement(By.cssSelector("input[id='Email']"))).sendKeys("Rastgele@gmail.com").build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("input[type='Password']"))).click().sendKeys("Rastgele123").build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//input[@value='Log in']"))).click().build().perform();
        MyFunction.Wait(1);
        WebElement msg4 = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul>li"));
        Assert.assertTrue(msg4.getText().contains("No customer account found"));

        WaitAndClose();
    }
}