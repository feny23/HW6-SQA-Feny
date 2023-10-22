package saucedemo_test.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo_test/cucumber/features/RemoveItemCart.feature",
        glue = "saucedemo_test.cucumber.stepDef",
        plugin = {"html:target/removeitemcart_report.html"}
)
public class runRemoveItemCart {
}
