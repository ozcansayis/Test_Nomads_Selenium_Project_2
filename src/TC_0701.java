import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TC_0701 extends BaseDriver {
   @Test
    public void TC_0701() {
    driver.get("https://demowebshop.tricentis.com/");
        WebElement poll = driver.findElement(By.cssSelector("[class='block block-poll'] div:nth-child(1)"));
        Assert.assertTrue("poll is not displayed", poll.isDisplayed());


        List<WebElement> pollOpt = driver.findElements(By.cssSelector("[id^='pollanswers']"));
        for (WebElement x : pollOpt) {

            dAct.click(x).build().perform();
            Assert.assertTrue(x.getAccessibleName() + " is not clikable", x.isSelected());
        }

        WebElement voteButton = driver.findElement(By.xpath("//*[@id='vote-poll-1']"));
        Assert.assertTrue("button is not displayed", voteButton.isDisplayed());
        dAct.click(pollOpt.get(2)).perform();
        dAct.click(voteButton).build().perform();
        WebElement helperText = driver.findElement(By.cssSelector("[id='block-poll-vote-error-1']"));
        Assert.assertTrue(helperText.getAccessibleName() + " is not displayed", helperText.isDisplayed() || helperText.getText().equals("Only registered users can vote."));

        WebElement logIn = driver.findElement(By.xpath("//*[@class='ico-login']"));
        dAct.click(logIn).build().perform();

        WebElement id = driver.findElement(By.id("Email"));
        dAct.sendKeys(id, "testnomads01@gmail.com").build().perform();
        WebElement password = driver.findElement(By.id("Password"));
        dAct.sendKeys(password, "07Nomad++").build().perform();


        WebElement logIn2 = driver.findElement(By.cssSelector("div[class='buttons'] [value='Log in']"));
        dAct.sendKeys(logIn2).build().perform();

        List<WebElement> votes = driver.findElements(By.cssSelector("ul[class='poll-results'] .answer"));
        List<WebElement> voteButtons = driver.findElements(By.cssSelector("[id^='pollanswers']"));
        if (!votes.isEmpty()) {
            for (WebElement element : votes) {
                Assert.assertTrue("error", element.getText().contains("vote(s)"));
            }
        } else if (!voteButtons.isEmpty()) {
            dAct.click(voteButtons.get(2)).build().perform();
            WebElement voteButtton = driver.findElement(By.cssSelector("input[id='vote-poll-1']"));
            wait.until(ExpectedConditions.elementToBeClickable(voteButtton));
            dAct.click(voteButtton).build().perform();
            MyFunction.Wait(2);
            List<WebElement> votes2 = driver.findElements(By.cssSelector("ul[class='poll-results'] .answer"));
            for (WebElement element2 : votes2) {
                Assert.assertTrue("error", element2.getText().contains("vote(s)"));
            }
        }
        WaitAndClose();
    }

}

