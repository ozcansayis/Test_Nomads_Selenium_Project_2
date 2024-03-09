import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class TC_20901 extends BaseDriver {
    @Test
    public void TC_20901() throws AWTException {
        driver.get("https://demowebshop.tricentis.com/");
        Robot dRob = new Robot();
        // credentials will be updated!!!!!!!!!!!!!
        dAct.moveToElement(driver.findElement(By.linkText("Log in"))).click().build().perform();
        dAct.click(driver.findElement(By.cssSelector("input[id='Email']"))).sendKeys("ozcansayis@gmail.com" + Keys.TAB + "369258+" + Keys.ENTER).build().perform();

        List<WebElement> aCrit1 = driver.findElements(By.linkText("Log out"));
        Assert.assertFalse("Login failed!", aCrit1.isEmpty());

        dAct.click(driver.findElement(By.cssSelector(".account"))).build().perform();
        WebElement aCrit2 = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertTrue("Account information couldn't be displayed!", aCrit2.getText().contains("Customer info"));

        for (int i = 0; i < 17; i++) {// <--"Order" button.
            dRob.keyPress(KeyEvent.VK_TAB);
            dRob.keyRelease(KeyEvent.VK_TAB);
        }
        dRob.keyPress(KeyEvent.VK_ENTER);
        dRob.keyRelease(KeyEvent.VK_ENTER);

        List<WebElement> aCrit3 = driver.findElements(By.cssSelector("div[class='page-title'] h1"));
        Assert.assertTrue("Orders couldn't be displayed!", !aCrit3.isEmpty() && aCrit3.get(0).getText().equals("My account - Orders"));

        List<WebElement> aCrit4 = driver.findElements(By.xpath("//input[@type='button'][@value='Details']"));
        Assert.assertFalse("Details button not found!", aCrit4.isEmpty());

        dAct.click(driver.findElement(By.cssSelector("input[onclick=\"setLocation('/orderdetails/1640807')\"]"))).build().perform();

        List<WebElement> aCrit5= driver.findElements(By.xpath("//a[text()='PDF Invoice']"));
        Assert.assertFalse("PDF Invoice button not found!",aCrit5.isEmpty());

        dAct.click(driver.findElement(By.linkText("PDF Invoice"))).build().perform();

        dRob.keyPress(KeyEvent.VK_CONTROL);//<--Downloads
        dRob.keyPress(KeyEvent.VK_J);
        dRob.keyRelease(KeyEvent.VK_CONTROL);
        dRob.keyRelease(KeyEvent.VK_J);
        MyFunction.Wait(1);
        for (int i = 0; i < 2; i++) {
            dRob.keyPress(KeyEvent.VK_TAB);
            dRob.keyRelease(KeyEvent.VK_TAB);
        }
        dRob.keyPress(KeyEvent.VK_ENTER);
        dRob.keyRelease(KeyEvent.VK_ENTER);

        WaitAndClose();
    }
}