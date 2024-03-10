import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TC_20801 extends BaseDriver {
    @Test
    public void TC_20801() {
        driver.get("https://demowebshop.tricentis.com");

        WebElement loginLink = driver.findElement(By.className("ico-login"));
        dAct.click(loginLink).perform();

        dAct.sendKeys(driver.findElement(By.id("Email")), "testnomads01@gmail.com");
        dAct.sendKeys(driver.findElement(By.id("Password")), "07Nomad++");
        WebElement loginButton = driver.findElement(By.cssSelector("input[value = 'Log in']"));
        dAct.click(loginButton).perform();

        WebElement computersMenu = driver.findElement(By.linkText("Computers"));
        dAct.moveToElement(computersMenu).click().perform();

        WebElement notebooksSubMenu = driver.findElement(By.linkText("Notebooks"));
        dAct.moveToElement(notebooksSubMenu).click().perform();
        WebElement laptop = driver.findElement(By.linkText("14.1-inch Laptop"));
        dAct.click(laptop).perform();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button-31"));
        dAct.click(addToCartButton).perform();

        WebElement shoppingCartLink = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        dAct.click(shoppingCartLink).perform();
        WebElement applyCouponButton = driver.findElement(By.name("applydiscountcouponcode"));
        dAct.click(applyCouponButton).perform();

        WebElement couponMessage = driver.findElement(By.xpath("//div[@class='message']"));
        if (couponMessage.getText().contains("The coupon code you entered couldn't be applied to your order")) {
            System.out.println("UYARI: Kupon Kullanılamadı");
        }

        WebElement addGiftCardButton = driver.findElement(By.name("applygiftcardcouponcode"));
        dAct.click(addGiftCardButton).perform();

        WebElement giftCardMessage = driver.findElement(By.xpath("//div[@class='message']"));
        giftCardMessage.getText();
        if (giftCardMessage.getText().contains("The coupon code you entered couldn't be applied to your order")) {
            System.out.println("UYARI : Hediye kartı kullanılamadı.");
        }

        WebElement countryDropdown = driver.findElement(By.id("CountryId"));
        dAct.sendKeys(countryDropdown, "United States");

        WebElement stateDropdown = driver.findElement(By.id("StateProvinceId"));
        dAct.sendKeys(stateDropdown, "California");
        WebElement termsCheckbox = driver.findElement(By.id("termsofservice"));
        dAct.click(termsCheckbox).perform();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        dAct.click(checkoutButton).perform();

        List<WebElement> elements = driver.findElements(By.cssSelector("label[for='billing-address-select']"));
        if (elements.isEmpty()) {
            WebElement firstName = driver.findElement(By.id("BillingNewAddress_FirstName"));
            dAct.sendKeys(firstName, "Fatos");

            WebElement lastName = driver.findElement(By.id("BillingNewAddress_LastName"));
            dAct.sendKeys(lastName, "YILDIZ");

            WebElement companyName = driver.findElement(By.id("BillingNewAddress_Company"));
            dAct.sendKeys(companyName, "YILDIZ LTD.");

            WebElement countryDropdownSelect = driver.findElement(By.id("BillingNewAddress_CountryId"));
            dAct.sendKeys(countryDropdownSelect, "United States");

            WebElement stateDropdownSelect = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
            dAct.sendKeys(stateDropdownSelect, "California");

            WebElement cityText = driver.findElement(By.id("BillingNewAddress_City"));
            dAct.sendKeys(cityText, "TEST-ŞEHİR");

            WebElement addressText = driver.findElement(By.id("BillingNewAddress_Address1"));
            dAct.sendKeys(addressText, "TEST-address1");

            WebElement postaCodeText = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            dAct.sendKeys(postaCodeText, "06580");

            WebElement phoneText = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            dAct.sendKeys(phoneText, "123456789");
        }

        WebElement continueButton = driver.findElement(By.cssSelector("input[title='Continue']"));
        dAct.click(continueButton).perform();

        WebElement continueButton2 = driver.findElement(By.cssSelector("input[title='Continue']"));
        dAct.click(continueButton2).perform();

        WebElement continueButton3 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[onclick='Shipping.save()']"))));
        dAct.click(continueButton3).build().perform();

        WebElement continueButton4 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[onclick='ShippingMethod.save()']"))));
        dAct.click(continueButton4).perform();

        WebElement continueButton5 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"))));
        dAct.click(continueButton5).perform();

        WebElement continueButton6 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[onclick='PaymentInfo.save()']"))));
        dAct.click(continueButton6).perform();

        WebElement continueButton7 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[onclick='ConfirmOrder.save()']"))));
        dAct.click(continueButton7).perform();
        MyFunction.Wait(2);

        WebElement mesaj = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[class='title']>strong"))));
        System.out.println(mesaj.getText());
        Assert.assertEquals("Mesaj bulunamadı", "Your order has been successfully processed!", mesaj.getText());

        WaitAndClose();
    }
}