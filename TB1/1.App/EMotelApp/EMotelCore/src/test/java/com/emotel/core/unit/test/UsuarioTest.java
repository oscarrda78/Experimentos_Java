//<<<<<<< HEAD
//package com.emotel.core.unit.test;
//
//import org.junit.FixMethodOrder;
//import org.junit.experimental.categories.Category;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.emotel.core.entities.Usuario;
//import com.emotel.core.service.IUsuarioService;
//import com.emotel.core.unit.suite.PruebasUnitariasTest;
//
//@Category(PruebasUnitariasTest.class)
//@RunWith(MockitoJUnitRunner.Silent.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UsuarioTest {
//
//	private Usuario usuario;
//	
//	private IUsuarioService usuarioService;
//}
//=======
package com.emotel.core.unit.test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.emotel.core.entities.Usuario;
import com.emotel.core.service.IUsuarioService;
import com.emotel.core.unit.suite.PruebasUnitariasTest;

@Category(PruebasUnitariasTest.class)
@RunWith(MockitoJUnitRunner.Silent.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	
	@Mock
	private Usuario usuario;
	
	@Mock
	private IUsuarioService usuarioService;
	
	@BeforeClass
    public static void inicioClase() {
        System.out.println("Inicio de la clase");
    }

@AfterClass
    public static void finClase() {
        System.out.println("Fin de la clase");
    }

@Before
    public void inicioMetodo() {
        System.out.println("Inicio Metodo");
    }

 @After
    public void finMetodo() {
        System.out.println("Fin Metodo");
    }
    
 @Test
 public void a_insertar() {
 	try {
 		System.out.println("Método Insertar");
 		when(usuario.getId()).thenReturn(1);
 		when(usuario.getNombre()).thenReturn("Deluxe");
 		when(usuario.getApellido()).thenReturn("Adolfino");
 		when(usuario.getCorreo()).thenReturn("Adolfino@gmail.com");
 		when(usuario.getFecha()).thenReturn(null);
 		when(usuario.getPassword()).thenReturn("quinua");
 		when(usuarioService.agregar(new Usuario())).thenReturn(true);
 		usuarioService.agregar(usuario);
 		Assert.assertTrue(usuario.getId() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
 	}
 
 @Test
 public void b_listar() {
 	try {
 		System.out.println("Método Listar");
 		List<Usuario> listaUsuario = spy(new ArrayList<Usuario>());
 		when(listaUsuario.add(new Usuario())).thenReturn(true);
 		when(listaUsuario.add(new Usuario())).thenReturn(true);
 		when(listaUsuario.add(new Usuario())).thenReturn(true);
 		when(listaUsuario.add(new Usuario())).thenReturn(true);
 		when(listaUsuario.add(new Usuario())).thenReturn(true);
 		when(usuarioService.listar()).thenReturn(listaUsuario);
 		List<Usuario> lista = usuarioService.listar();
 		Assert.assertTrue(lista.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
 	}
 
}
//>>>>>>> 2a956fbc6e301c9dfbc150313a9f7cdcf8c238db
