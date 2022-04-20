package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl= "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    //@After
    public void tearDown(){
        closeBrowese();
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        driver.findElement(By.linkText("Register")).click();

        String expectedText = "Signing up is easy!";
        String actualText = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        System.out.println(actualText);
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Pavan");
        driver.findElement(By.id("customer.lastName")).sendKeys("Kumar");
        driver.findElement(By.id("customer.address.street")).sendKeys("28 ABC street");
        driver.findElement(By.id("customer.address.city")).sendKeys("London");
        driver.findElement(By.id("customer.address.state")).sendKeys("Gujarat");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("382345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123456789");
        driver.findElement(By.id("customer.ssn")).sendKeys("A2315DHV215");
        driver.findElement(By.id("customer.username")).sendKeys("Abc_12345");
        driver.findElement(By.id("customer.password")).sendKeys("123456789");
        driver.findElement(By.id("repeatedPassword")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String expectedText = "Your account was created successfully. You are now logged in.";
        String actualText= driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]")).getText();
        Assert.assertEquals(expectedText,actualText);




    }
}
