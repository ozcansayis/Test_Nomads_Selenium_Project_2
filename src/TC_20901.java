import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TC_20901 extends BaseDriver {
    @Test
    public void TC_20901() throws AWTException {
        driver.get("https://demowebshop.tricentis.com/");
        Robot dRob = new Robot();

        dAct.moveToElement(driver.findElement(By.linkText("Log in"))).click().perform();
        dAct.click(driver.findElement(By.cssSelector("input[id='Email']"))).sendKeys("testnomads01@gmail.com" + Keys.TAB + "07Nomad++" + Keys.ENTER).perform();

        WebElement logoutLink = driver.findElement(By.linkText("Log out"));
        Assert.assertNotNull("Login failed!", logoutLink);

        dAct.click(driver.findElement(By.cssSelector(".account"))).perform();
        WebElement accountInfo = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertTrue("Account information couldn't be displayed!", accountInfo.getText().contains("Customer info"));

        for (int i = 0; i < 17; i++) {// <--"Order" button.
            dRob.keyPress(KeyEvent.VK_TAB);
            dRob.keyRelease(KeyEvent.VK_TAB);
        }
        dRob.keyPress(KeyEvent.VK_ENTER);
        dRob.keyRelease(KeyEvent.VK_ENTER);

        WebElement ordersTitle = driver.findElement(By.cssSelector("div[class='page-title'] h1"));
        Assert.assertEquals("Orders couldn't be displayed!", "My account - Orders", ordersTitle.getText());

        List<WebElement> detailButtons = driver.findElements(By.xpath("//input[@type='button'][@value='Details']"));
        Assert.assertFalse("Details button not found!", detailButtons.isEmpty());
        dAct.click(detailButtons.get(0)).perform();

        WebElement pdfInvoiceButton = driver.findElement(By.xpath("//a[text()='PDF Invoice']"));
        Assert.assertNotNull("PDF Invoice button not found!", pdfInvoiceButton);

        WebElement orderNumber = driver.findElement(By.cssSelector("div[class='order-number'] strong"));
        String orderNumberStr = orderNumber.getText().replaceAll("[^0-9]", "");

        dAct.click(pdfInvoiceButton).build().perform();

        dRob.keyPress(KeyEvent.VK_CONTROL);//<--Downloads
        dRob.keyPress(KeyEvent.VK_J);
        dRob.keyRelease(KeyEvent.VK_CONTROL);
        dRob.keyRelease(KeyEvent.VK_J);
        MyFunction.Wait(1);
        Set<String> handlesBefore = driver.getWindowHandles();
        for (int i = 0; i < 2; i++) {
            dRob.keyPress(KeyEvent.VK_TAB);
            dRob.keyRelease(KeyEvent.VK_TAB);
        }
        dRob.keyPress(KeyEvent.VK_ENTER);
        dRob.keyRelease(KeyEvent.VK_ENTER);
        MyFunction.Wait(1);
        Set<String> handlesAfter = driver.getWindowHandles();
        handlesAfter.removeAll(handlesBefore);
        Iterator<String> orderTabHandle = handlesAfter.iterator();
        String handle = orderTabHandle.next();
        driver.switchTo().window(handle);
        Assert.assertTrue("Failed to download the requested invoice!", driver.getCurrentUrl().contains(orderNumberStr));

        WaitAndClose();
    }
}