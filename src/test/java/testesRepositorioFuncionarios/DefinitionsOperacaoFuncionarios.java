package testesRepositorioFuncionarios;

import com.sistex.App;
import com.sistex.cdp.Funcionario;
import com.sistex.cgd.FuncionarioRepositorio;
import com.sistex.util.Fabrica;
import com.sistex.util.Tipo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@SuppressWarnings("deprecation")
public class DefinitionsOperacaoFuncionarios {

    private final Fabrica fabrica = Fabrica.make(Tipo.FUNCIONARIO);
    private final Funcionario funcionario = fabrica.criaFuncionario();
    private String operacao;

    @Autowired
    FuncionarioRepositorio repositorio;

    @Given("^I have a funcionario with name (\\w+) and rg (\\d+)")
    public void i_have_user_and_password(String nome, String rg) throws Throwable {
        funcionario.setRg(rg);
        funcionario.setNome(nome);
        funcionario.setDatanascimento("10-10-1971");
        funcionario.setEmail(nome + "@gmail.com");
        funcionario.setEndereco("Rua Almeida 288");
        funcionario.setTelefone("3344-4433");
        funcionario.setCargo("atendente");
    }

    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;

    }

    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Funcionario novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(funcionario);
                result2 = Boolean.toString(repositorio.exists(novo.getIdfuncionario()));
                repositorio.delete(novo.getIdfuncionario());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(funcionario);
                repositorio.delete(funcionario);
                result2 = Boolean.toString(!repositorio.exists(novo.getIdfuncionario()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(funcionario);
                result2 = Boolean.toString(!repositorio.exists(novo.getIdfuncionario()));
                repositorio.delete(novo.getIdfuncionario());
                assertThat(result, is(result2));
                break;
                
            default:
                break;
        }
        
    }

}
