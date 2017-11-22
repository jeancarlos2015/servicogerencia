package testesRepositorioFornecedores;

import com.sistex.App;
import com.sistex.cdp.Fornecedor;
import com.sistex.cgd.FornecedorRepositorio;
import com.sistex.util.Fabrica;
import com.sistex.util.Tipo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@SuppressWarnings("deprecation")
public class DefinitionsOperacaoFornecedor {

    private final Fabrica fabrica = Fabrica.make(Tipo.FORNECEDOR);
    private final Fornecedor fornecedor = fabrica.criaFornecedor();
    private String operacao;

    @Autowired
    FornecedorRepositorio repositorio;

    @Given("^I have a fornecedor with name (\\w+) and cnpj (\\d+)")
    public void i_have_user_and_password(String nome, String cnpj) throws Throwable {
        fornecedor.setCnpj(cnpj);
        fornecedor.setNome(nome);
        fornecedor.setDatanascimento("10-10-1971");
        fornecedor.setEmail(nome + "@gmail.com");
        fornecedor.setEndereco("Rua Almeida 288");
        fornecedor.setTelefone("3344-4433");
    }

    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;

    }

    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Fornecedor novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(fornecedor);
                result2 = Boolean.toString(repositorio.exists(novo.getIdfornecedor()));
                repositorio.delete(novo.getIdfornecedor());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(fornecedor);
                repositorio.delete(fornecedor);
                result2 = Boolean.toString(!repositorio.exists(novo.getIdfornecedor()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(fornecedor);
                result2 = Boolean.toString(!repositorio.exists(novo.getIdfornecedor()));
                repositorio.delete(novo.getIdfornecedor());
                assertThat(result, is(result2));
                break;
                
            default:
                break;
        }
        
    }

}
