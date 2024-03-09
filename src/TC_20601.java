import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TC_20601 extends BaseDriver {
    @Test
    public void TC_20601() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Log in']"));
        dAct.moveToElement(loginButton).click().build().perform();

        dAct.moveToElement(driver.findElement(By.cssSelector("input[id='Email']"))).click().sendKeys("testnomads007@gmail.com").build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//input[@name='Password']"))).click().sendKeys("07Nomad++").build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("input[value='Log in']"))).click().build().perform();
        MyFunction.Wait(2);

        // US- 3.Adım
        dAct.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]"))).build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("[class='sublist firstLevel active']>:nth-child(2)"))).click().build().perform();
        MyFunction.Wait(1);

        dAct.scrollToElement(driver.findElement(By.xpath("//input[@value='Add to cart']"))).build().perform();  //******

        dAct.moveToElement(driver.findElement(By.cssSelector("div[class='product-item']>div>a>img"))).click().build().perform();

        //4.
        dAct.click(driver.findElement(By.cssSelector("input[class='button-1 add-to-cart-button']"))).build().perform();
        //5.
        dAct.moveToElement(driver.findElement(By.xpath("//span[text()='Shopping cart']"))).click().build().perform();
        //6.7.
        WebElement country = driver.findElement(By.cssSelector("select[name='CountryId']"));
        Select countrySel = new Select(country);
        countrySel.selectByValue("77");

        dAct.moveToElement(driver.findElement(By.xpath("//select[@id='StateProvinceId']"))).click().build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//input[@id='ZipPostalCode']"))).click().sendKeys("07000").build().perform();
        //8.
        dAct.moveToElement(driver.findElement(By.cssSelector("input[name='termsofservice']"))).click().build().perform();
        //9.
        dAct.moveToElement(driver.findElement(By.xpath("//button[@class='button-1 checkout-button']"))).click().build().perform();

        // Billing Address
        List<WebElement> addInformation=driver.findElements(By.cssSelector("label[for='billing-address-select']"));
        if (addInformation.size()>0){
          //  dAct.click(driver.findElement(By.xpath("//select[@id='billing-address-select']/option[1]"))).build().perform();
            dAct.click(driver.findElement(By.cssSelector("input[onclick='Billing.save()']"))).build().perform();
        }else {
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
        // Shipping Address ->
        dAct.click(driver.findElement(By.cssSelector("input[onclick='Shipping.togglePickUpInStore(this)']"))).build().perform();
        dAct.click(driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"))).build().perform();

        // Payment Method -> Credit Card

       // dAct.moveToElement(driver.findElement(By.xpath("//ul[@class='method-list']/li[3]"))).click().build().perform();

        dAct.moveToElement(driver.findElement(By.xpath("//input[@id='paymentmethod_2']"))).click().build().perform();
        MyFunction.Wait(2);

        dAct.click(driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"))).build().perform();



       // dAct.moveToElement(driver.findElement(By.cssSelector("select[id='CreditCardType']"))).click().build().perform();
       // dAct.moveToElement(driver.findElement(By.xpath("//select[@id='CreditCardType']/option[1]"))).click().build().perform();
       // dAct.click(driver.findElement(By.xpath("//input[@name='CardholderName']"))).click().sendKeys("Test Nomads").build().perform();

      //  WaitAndClose();
    }
}
