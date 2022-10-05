package runner.bbc1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features =
                {"src/main/resources/bbc1/bbc1_part1_tests.feature"
                        , "src/main/resources/bbc1/bbc1_part2_tests.feature"
                        , "src/main/resources/bbc2/bbc2_part2_tests.feature"
                },
        glue = "stepdefinitions"
)
public class RunnerTests extends AbstractTestNGCucumberTests {

}
