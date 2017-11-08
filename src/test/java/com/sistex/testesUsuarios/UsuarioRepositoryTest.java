//package com.sistex.testesUsuarios;
//
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.sistex.cdp.Usuario;
//import com.sistex.cgd.UsuarioRepositorio;
//
//import java.math.BigDecimal;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class UsuarioRepositoryTest {
//
//    
//    private static final String USUARIO_USER= "teste";
//    private static final String USUARIO_PASSWORD = "teste";
//
//    @Autowired
//    private UsuarioRepositorio usuarioRepository;
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @Test
//    public void testPersistence() {
//        //given
//        Usuario usuario = new Usuario();
//        usuario.setUname(USUARIO_USER);
//        usuario.setPass(USUARIO_PASSWORD);
//
//        //when
//        usuarioRepository.save(usuario);
//
//        //then
//        Assert.assertNotNull(usuario.getId());
//        Usuario newUsuario = usuarioRepository.findOne(usuario.getId());
//        
//        Assert.assertEquals(USUARIO_PASSWORD, newUsuario.getPass());
//        Assert.assertEquals(USUARIO_USER, newUsuario.getUname());
//    }
//}