package br.com.sinosi.util;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ambientinformatica.util.UtilLog;
import br.com.sinosi.entidade.EnumPapelUsuario;
import br.com.sinosi.entidade.Usuario;
import br.com.sinosi.persistencia.MunicipioDao;
import br.com.sinosi.persistencia.UsuarioDao;

@Service("inicializadorSistema")
public class InicializadorSistema {

	@Autowired
	private UsuarioDao usuarioDao;
	
	  @Autowired
	    private MunicipioDao municipioDao;
	
	@PostConstruct
	public void iniciar(){
		inicializarUsuarioAdmin();
	}
	
    private void inicializarUsuarioAdmin() {
        try {
        	 Usuario usuario = usuarioDao.consultarPorCpfSemValidacao("111.111.111.11");			
        	 if (usuario == null) {
				Usuario usu = new Usuario();
				usu.setNome("Administrador");
				usu.setLogin("admin");
				usu.setCpf("111.111.111.11");
                usu.setEmail("lekorim@gmail.com");
                usu.setDataNascimento(new Date());
                usu.setCep("74.000-000");
                usu.setTelefone("(62)9999-9999");
                usu.setEndereco("Rua");
                usu.setRg("123");
                usu.setSenhaNaoCriptografada("123456");
                usu.setMunicipio(municipioDao.municipioPorCodigoIBGE(5208707));
                usu.addPapel(EnumPapelUsuario.ADMIN);
                usu.addPapel(EnumPapelUsuario.USUARIO);

                usuarioDao.incluir(usu);

                UtilLog.getLog().info("*** USUÁRIO admin CRIADO com a senha 123456 ***");
            }
        } catch (Exception e) {
            UtilLog.getLog().error(e.getMessage(), e);
        }
    }
	
	
}
