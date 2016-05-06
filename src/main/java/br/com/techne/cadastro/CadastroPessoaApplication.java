package br.com.techne.cadastro;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class CadastroPessoaApplication extends ResourceConfig {
    public CadastroPessoaApplication() {
        packages("br.com.techne.cadastro.controller");
    }
}