package testesRepositorioFuncionarios;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/featuresRepositorioFuncionarios")
public class BDDTest {

}
