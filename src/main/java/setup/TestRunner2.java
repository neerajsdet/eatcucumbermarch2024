package setup;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features/product.feature",
        glue = "stepdefinitions"
)
public class TestRunner2 extends AbstractTestNGCucumberTests {

}
