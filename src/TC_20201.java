import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_20201 extends BaseDriver {
    @Test
    public void TC_20201() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        dAct.moveToElement(register).click().build().perform();

        WebElement gender = driver.findElement(By.name("Gender"));
        dAct.moveToElement(gender).click().build().perform();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        dAct.click(firstName).sendKeys("Test").build().perform();

        WebElement lastName = driver.findElement(By.cssSelector("input[id='LastName']"));
        dAct.click(lastName).sendKeys("Nomads").build().perform();

        WebElement email = driver.findElement(By.id("Email"));
        dAct.click(email).sendKeys("testnomads01@gmail.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        dAct.click(password).sendKeys("07Nomad++").build().perform();

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        dAct.click(confirmPassword).sendKeys("07Nomad++").build().perform();

        WebElement registerButton = driver.findElement(By.name("register-button"));
        dAct.click(registerButton).click().build().perform();

        WebElement alert = driver.findElement(By.cssSelector("[class='validation-summary-errors']"));
        Assert.assertEquals("Helper text does not appear.", "The specified email already exists", alert.getText());

        WaitAndClose();
    }
}