//package testesControllerUsuarios;
//import com.sistex.cdp.Usuario;
//import com.sistex.cgt.UsuarioServico;
//import com.sistex.util.Fabrica;
//import static com.sistex.util.Tipo.USUARIO;
//import com.sistex.util.UsuarioForm;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class DefinitionsOperacaoCadastroLogin {
//    private final Fabrica fabrica = Fabrica.make(USUARIO);
//    private UsuarioServico servico;
//    UsuarioForm usuarioForm = fabrica.criaUsuarioForm();
//    
//    private String operacao;
//    @Given("^I have a user (\\w+) and a password (\\w+)")
//    public void i_have_user_and_password(String user, String password) throws Throwable {
//        usuarioForm.setPass(password);
//        usuarioForm.setUname(user);
//
//    }
//
//    @When("^I want to make the operation (\\w+)")
//    public void i_validate_me(String operation) throws Throwable {
//        this.operacao = operation;
//
//    }
//
//    @Then("^my operation should return (.*)$")
//    public void my_user_and_password_should_be(String result) throws Throwable {
//        String result2;
//        
//        switch (operacao) {
//            case "register":
//                
//                 Usuario usuarioSaved = servico.saveOrUpdateUsuarioForm(usuarioForm);
//                 Usuario usuarioOld = servico.getById(usuarioSaved.getIdusuario());
//                 result2 = Boolean.toString(usuarioSaved.equals(usuarioOld));
//                 assertThat(result2, is(result));
//                break;
//          
//            case "change":
////                usuarioSaved = usuarioRepository.save(usuarioObj);
////                Usuario usuarioOLD = usuarioRepository.findOne(usuarioSaved.getId());
////                usuarioOLD.setUname("joao");
////                Usuario usuarioOLDChange =  usuarioRepository.save(usuarioOLD);
////                result2 = Boolean.toString(!usuarioOLD.getUname().equals(usuarioOLDChange.getUname()));
////                assertThat(result2, is(result));
//                break;
//            case "consult":
////                usuarioSaved = usuarioRepository.save(usuarioObj);
////                usuarioOLD = usuarioRepository.findOne(usuarioSaved.getId());
////                result2 = Boolean.toString(usuarioSaved.equals(usuarioOLD));
////                assertThat(result2, is(result));
//                break;
//            case "delete":
////                usuarioSaved = usuarioRepository.save(usuarioObj);
////                usuarioRepository.delete(usuarioSaved.getId());
////                result2 = Boolean.toString(!usuarioRepository.exists(usuarioSaved.getId()));
////                assertThat(result2, is(result));
//                break;
//            default:
//                break;
//        }
//
//    }
//    @Autowired
//    public void setServico(UsuarioServico servico) {
//        this.servico = servico;
//    }
//}
