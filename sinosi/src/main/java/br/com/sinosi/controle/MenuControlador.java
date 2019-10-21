package br.com.sinosi.controle;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.controle.GerenciadorSessao;

@Controller("MenuControlador")
@Scope("session")
public class MenuControlador implements Serializable {

    private static final long serialVersionUID = 1L;

    public void gerenciarSessao(ActionEvent evento){
        GerenciadorSessao.limparSessoes();
    }

}
