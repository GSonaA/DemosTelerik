
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features={"classpath:features"},
        tags=("@mountainbikes")
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

