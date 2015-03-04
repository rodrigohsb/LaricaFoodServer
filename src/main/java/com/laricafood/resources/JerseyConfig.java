package com.laricafood.resources;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(EstabelecimentoResource.class);
    }
}
