package testesRepositorioNotificacoes;

import com.sistex.App;
import com.sistex.cdp.Notificacao;
import com.sistex.cgd.NotificacaoRepositorio;
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
public class DefinitionsOperacaoNotificacao {

    private final Fabrica fabrica = Fabrica.make(Tipo.NOTIFICACAO);
    private final Notificacao notificacao = fabrica.criaNotificacao();
    private String operacao;

    @Autowired
    NotificacaoRepositorio repositorio;

    @Given("^I, (\\w+), I need to send a (\\w+)")
    public void i_have_user_and_password(String nome, String descricao) throws Throwable {
        notificacao.setDatastr("10-01-2018");
        notificacao.setDescricao(descricao);
        notificacao.setEmail("fornecedor@gmail.com");
        notificacao.setNomeCliente(nome);
    }

    @When("^I want to make the operation (\\w+)")
    public void i_validate_me(String operation) throws Throwable {
        this.operacao = operation;

    }

    @Then("^my operation should return (.*)$")
    public void my_user_and_password_should_be(String result) throws Throwable {
        String result2;
        Notificacao novo;
        switch (operacao) {
            case "register":
                novo = repositorio.save(notificacao);
                result2 = Boolean.toString(repositorio.exists(novo.getIdnotificacao()));
                repositorio.delete(novo.getIdnotificacao());
                assertThat(result, is(result2));
                break;
            case "delete":
                novo = repositorio.save(notificacao);
                repositorio.delete(notificacao);
                result2 = Boolean.toString(!repositorio.exists(novo.getIdnotificacao()));
                assertThat(result, is(result2));
                break;
            case "exist":
                novo = repositorio.save(notificacao);
                result2 = Boolean.toString(!repositorio.exists(novo.getIdnotificacao()));
                repositorio.delete(novo.getIdnotificacao());
                assertThat(result, is(result2));
                break;
                
            default:
                break;
        }
        
    }

}
