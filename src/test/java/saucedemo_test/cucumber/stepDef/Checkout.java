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

public class Checkout {

    WebDriver driver;
    String baseURL="https://www.saucedemo.com/";
    @Given("User Login With Username and Password")
    public void userLoginWithUsernameAndPassword() {
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

    @And("User add item to cart")
    public void userAddItemToCart() {
        driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

    }

    @And("User Click the Icon Cart")
    public void userClickIconCart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("User Click Checkout Button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("User redirect to Checkout : Your Information Page")
    public void redirectToCheckoutYourInformation() {
    }
}
