package testesRepositorioCompras;

import com.sistex.App;
import com.sistex.cdp.Compra;
import com.sistex.cgd.CompraRepositorio;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@SuppressWarnings("deprecation")
public class DefinitionsOperacaoCompras {

    private final Fabrica fabrica = Fabrica.make(Tipo.COMPRA);
    private final Compra compra = fabrica.criaCompra();
    private String operacao;

    @Autowired
    CompraRepositorio repositorio;

    @Given("^buy (\\d+) (\\w+) from vendor (\\w+) brand with cnpj (\\d+) for cust (\\d+)")
    public void i_have_user_and_password(String qt,String nome, String marca, String cnpj, String custo) throws Throwable {
        compra.setCustounidade(Float.parseFloat(custo));
        compra.setCnpj(cnpj);
        compra.setMarcaproduto(marca);
        compra.setNomeproduto(nome);
        compra.setQuantidade(Integer.parseInt(qt));
    }

    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;

    }

    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Compra novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(compra);
                result2 = Boolean.toString(repositorio.exists(novo.getIdcompra()));
                repositorio.delete(novo.getIdcompra());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(compra);
                repositorio.delete(compra);
                result2 = Boolean.toString(!repositorio.exists(novo.getIdcompra()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(compra);
                result2 = Boolean.toString(!repositorio.exists(novo.getIdcompra()));
                repositorio.delete(novo.getIdcompra());
                assertThat(result, is(result2));
                break;
                
            default:
                break;
        }
        
    }

}
