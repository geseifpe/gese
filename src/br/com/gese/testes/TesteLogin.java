package br.com.gese.testes;

import org.junit.Assert;

import br.com.gese.dao.AlunoDao;
import br.com.gese.dao.UsuarioDao;
import br.com.gese.model.Aluno;
import br.com.gese.model.Usuario;
import br.com.gese.util.Criptografia;
import junit.framework.TestCase;

public class TesteLogin extends TestCase {

	
	@SuppressWarnings("static-access")
	public void testarLogin(){
		AlunoDao daoAluno= new AlunoDao();
		UsuarioDao daoUsuario = new UsuarioDao();
		Aluno aluno = daoAluno.getAlunoId("03107383422");
        Usuario usuario = daoUsuario.login(aluno.getCpf(), Criptografia.md5("123456"));
		Assert.assertNotEquals(usuario,null);
	}
	
	public void testar1(){
		Assert.assertEquals(2,2);
	}
	
}
