import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TC_20601 extends BaseDriver {
    @Test
    public void TC_20601() {
        driver.get("https://demowebshop.tricentis.com/");

        dAct.moveToElement(driver.findElement(By.xpath("//a[text()='Log in']"))).click().build().perform();

        dAct.moveToElement(driver.findElement(By.cssSelector("input[id='Email']"))).click().sendKeys("testnomads007@gmail.com").build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//input[@name='Password']"))).click().sendKeys("07Nomad++").build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("input[value='Log in']"))).click().build().perform();

        dAct.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]"))).build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("[class='sublist firstLevel active']>:nth-child(2)"))).click().build().perform();

        dAct.scrollToElement(driver.findElement(By.xpath("//div[@class='footer']"))).build().perform();

        dAct.moveToElement(driver.findElement(By.cssSelector("div[class='product-item']>div>a>img"))).click().build().perform();

        dAct.click(driver.findElement(By.cssSelector("input[class='button-1 add-to-cart-button']"))).build().perform();

        dAct.moveToElement(driver.findElement(By.xpath("//span[text()='Shopping cart']"))).click().build().perform();

        WebElement country = driver.findElement(By.cssSelector("select[name='CountryId']"));
        Select countrySel = new Select(country);
        countrySel.selectByValue("77");
        dAct.moveToElement(driver.findElement(By.xpath("//select[@id='StateProvinceId']"))).click().build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//input[@id='ZipPostalCode']"))).click().sendKeys("07000").build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("input[name='termsofservice']"))).click().build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//button[@class='button-1 checkout-button']"))).click().build().perform();

        List<WebElement> addInformation = driver.findElements(By.cssSelector("label[for='billing-address-select']"));
        if (!addInformation.isEmpty()) {
            dAct.click(driver.findElement(By.cssSelector("input[onclick='Billing.save()']"))).build().perform();
        } else {
            WebElement country2 = driver.findElement(By.cssSelector("select[id='BillingNewAddress_CountryId']"));
            Select countrySel2 = new Select(country2);
            countrySel2.selectByValue("77");
            dAct.moveToElement(driver.findElement(By.cssSelector("select[name='BillingNewAddress.StateProvinceId']"))).click().build().perform();
            dAct.moveToElement(driver.findElement(By.cssSelector("input[name='BillingNewAddress.City']"))).click().sendKeys("Antalya").build().perform();
            dAct.moveToElement(driver.findElement(By.xpath("//input[@name='BillingNewAddress.Address1']"))).click().sendKeys("Türkiye").build().perform();
            dAct.moveToElement(driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"))).click().sendKeys("07000").build().perform();
            dAct.moveToElement(driver.findElement(By.cssSelector("input[data-val-required='Phone is required']"))).click().sendKeys("0007 007 07 07").build().perform();
            dAct.click(driver.findElement(By.xpath("//input[@onclick='Billing.save()']"))).build().perform();
        }

        dAct.click(driver.findElement(By.cssSelector("input[onclick='Shipping.togglePickUpInStore(this)']"))).build().perform();
        dAct.click(driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"))).build().perform();
        MyFunction.Wait(3);

        dAct.moveToElement(driver.findElement(By.cssSelector("input[id='paymentmethod_2']"))).click().build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"))).click().build().perform();

        dAct.click(driver.findElement(By.xpath("//input[@name='CardholderName']"))).sendKeys("Test Nomads").build().perform();
        dAct.click(driver.findElement(By.cssSelector("input[id='CardNumber']"))).sendKeys("4242 4242 4242 4242").build().perform();
        Select dateM = new Select(driver.findElement(By.id("ExpireMonth")));
        dateM.selectByValue("1");
        Select dateY = new Select(driver.findElement(By.id("ExpireYear")));
        dateY.selectByValue("2032");
        dAct.click(driver.findElement(By.xpath("//input[@name='CardCode']"))).sendKeys("123").build().perform();
        dAct.click(driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"))).build().perform();

        dAct.scrollToElement(driver.findElement(By.cssSelector("div[class='footer-menu-wrapper']"))).build().perform();

        WebElement subTotal = driver.findElement(By.cssSelector("td[class='cart-total-right']>span>span"));
        WebElement total = driver.findElement(By.cssSelector("span[class='product-price order-total']"));

        if (subTotal.getText().equals(total.getText())) {
            dAct.click(driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"))).build().perform();
            WebElement message = driver.findElement(By.xpath("//div[@class='title']/strong"));
            Assert.assertEquals("Helper text doesn't appear.", "Your order has been successfully processed!", message.getText());
        } else {
            System.out.println("The total price of the product is not equal to the calculated sum.");
        }
        WaitAndClose();

    }
}
