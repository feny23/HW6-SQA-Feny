package saucedemo_test.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class AddtoCart {
    WebDriver driver;
    String baseURL="https://www.saucedemo.com/";
    @Given(":User login")
    public void userLogin() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String loginPageAssert = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(loginPageAssert,"Products");
    }

    @When(":User Click title of item")
    public void userClickTitleOfItem() {
        driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
    }

    @And(":User click Add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then(": Cart Filled")
    public void cartFilled() {
        String CartAssert = driver.findElement(By.xpath("//span[contains(text(),'1')]")).getText();
        Assert.assertEquals(CartAssert,"1");
    }
}
