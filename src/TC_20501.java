import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_20501 extends BaseDriver {
    @Test
    public void TC_0501() {
        driver.get("https://demowebshop.tricentis.com");

        WebElement Login = driver.findElement(By.linkText("Log in"));
        dAct.moveToElement(Login).click().build().perform();

        //Empty email, empty password
        WebElement Longin2 = driver.findElement(By.xpath("//input[@value='Log in']"));
        dAct.moveToElement(Longin2).click().build().perform();
        WebElement msg1 = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul>li"));
        Assert.assertTrue(msg1.getText().contains("No customer account found"));

        WebElement email = driver.findElement(By.cssSelector("input[id='Email']"));
        WebElement password = driver.findElement(By.cssSelector("input[type='Password']"));
        MyFunction.Wait(2);
        //B) Current email, empty password
        dAct.moveToElement(email).sendKeys("ozcansayis@gmail.com").build().perform();
        MyFunction.Wait(2);
        dAct.moveToElement(driver.findElement(By.xpath("//input[@value='Log in']"))).click().build().perform();
        MyFunction.Wait(2);
        WebElement msg2 = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul>li"));
        Assert.assertTrue(msg2.getText().contains("The credentials provided are incorrect"));

        //C) Empty email, valid password
        driver.findElement(By.cssSelector("input[id='Email']")).clear();

        MyFunction.Wait(2);

        dAct.moveToElement(driver.findElement(By.cssSelector("input[type='Password']"))).click().sendKeys("369258+").build().perform();
        MyFunction.Wait(2);
        dAct.moveToElement(driver.findElement(By.xpath("//input[@value='Log in']"))).click().build().perform();
        WebElement msg3 = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul>li"));
        Assert.assertTrue(msg3.getText().contains("No customer account found"));
        MyFunction.Wait(2);

        //D) invalid email, invalid password
        dAct.moveToElement(driver.findElement(By.cssSelector("input[id='Email']"))).sendKeys("Rastgele@gmail.com").build().perform();
        MyFunction.Wait(2);

        dAct.moveToElement(driver.findElement(By.cssSelector("input[type='Password']"))).click().sendKeys("Rastgele123").build().perform();
        MyFunction.Wait(2);
        dAct.moveToElement(driver.findElement(By.xpath("//input[@value='Log in']"))).click().build().perform();
        WebElement msg4 = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul>li"));
        Assert.assertTrue(msg4.getText().contains("No customer account found"));
        MyFunction.Wait(2);

        WaitAndClose();

    }
}
