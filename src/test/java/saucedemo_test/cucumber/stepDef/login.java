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
public class login {

    WebDriver driver;
    String baseURL="https://www.saucedemo.com/";

    @Given("accesses saucedemo login page")
    public void accesses_saucedemo_login_page()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);
        String loginPageAssert = driver.findElement(By.xpath("//h4[contains(text(),'Accepted usernames are:')]")).getText();
        Assert.assertEquals(loginPageAssert,"Accepted usernames are:");
    }

    @When("input username")
    public void input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    }

    @And("input password")
    public void input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("User redirect to dashboard page")
    public void user_redirect_to_dashboard_page() {
        String loginPageAssert = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(loginPageAssert,"Products");
    }

    @When("input wrong username")
    public void inputWrongUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user_wrong");
    }

    @And("input wrong password")
    public void inputWrongPassword() {
        driver.findElement(By.id("password")).sendKeys("wrong_password");
    }

    @Then("User get alert failed login")
    public void userGetAlertFailedLogin() {
        String errLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errLogin,"Epic sadface: Username and password do not match any user in this service");
    }
}
