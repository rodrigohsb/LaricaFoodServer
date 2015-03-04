package com.laricafood.resources;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@ApplicationPath("/laricafood")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(EstabelecimentoResource.class);
    }
}