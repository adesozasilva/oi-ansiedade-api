package oiansiedade;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		plugin = {"pretty"}
		)
public class RunCucumberTest {
    
}
