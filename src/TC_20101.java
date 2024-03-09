import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC_20101 extends BaseDriver {
    @Test
    public void TC_20101() {
        driver.get("https://demowebshop.tricentis.com/");
        MyFunction.Wait(1);

        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        dAct.moveToElement(register).click().build().perform();
        MyFunction.Wait(1);

        WebElement gender = driver.findElement(By.name("Gender"));
        dAct.moveToElement(gender).click().build().perform();
        MyFunction.Wait(1);

        WebElement firstName = driver.findElement(By.id("FirstName"));
        dAct.click(firstName).sendKeys("Test").build().perform();
        MyFunction.Wait(1);

        WebElement lastName = driver.findElement(By.cssSelector("input[id='LastName']"));
        dAct.click(lastName).sendKeys("Nomads").build().perform();
        MyFunction.Wait(1);

        WebElement email = driver.findElement(By.id("Email"));
        dAct.click(email).sendKeys("testnomads10@gmail.com").build().perform();
        MyFunction.Wait(1);

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        dAct.click(password).sendKeys("07Nomad++").build().perform();
        MyFunction.Wait(1);

        WebElement confirmPassword= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        dAct.click(confirmPassword).sendKeys("07Nomad++").build().perform();
        MyFunction.Wait(1);

        WebElement registerButton=driver.findElement(By.id("register-button"));
        dAct.moveToElement(registerButton).click().build().perform();



        //Your registration completed


        WaitAndClose();
    }
}