package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.tmp.verify.Verify;


import java.util.concurrent.TimeUnit;

/**
 * Created by akshay.pokley on 9/20/2018.
 */


public class StepDefinitions {
    Alert alert;
    WebDriver driver;
    @Given("^I am on the page on URL$")
    public void i_am_on_the_page_on_URL() throws Throwable {
        try{
            System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://202.191.151.13//BpamsClient/Default.aspx");}

            catch (Throwable e){
            System.out.println(e.getMessage());
        }

    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_fill_in_with(String arg1, String arg2) throws Throwable {
   try{
       WebElement D=   driver.findElement(By.id(arg1));
       D.clear();
       D.sendKeys(arg2);

       WebElement D2= driver.findElement(By.id(arg1));
       D2.clear();
       D2.sendKeys(arg2);

   }catch (Throwable h){
       System.out.println(h.getMessage());
   }

    }

    @When("^I click on the button$")
    public void i_click_on_the_button() throws Throwable {
       try{
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           driver.findElement(By.id("btnImgLog")).click();
       }catch (Throwable r)
       {
           System.out.println(r.getMessage());
       }
    }

   @Then("^I should see \"([^\"]*)\" message$")
    public void i_should_see_message(String arg1) throws Throwable {

       alert = driver.switchTo().alert();
       String  Actual = driver.switchTo().alert().getText();
                Thread.sleep(6000);
       try {
                Assert.assertEquals(arg1,Actual);
   } catch (Throwable e) {

    }


                alert.accept();
                driver.close();
            }

        }




