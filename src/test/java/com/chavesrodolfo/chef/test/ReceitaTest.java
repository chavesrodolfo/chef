package com.chavesrodolfo.chef.test;


import com.chavesrodolfo.chef.model.Receita;
import com.chavesrodolfo.chef.service.ReceitaService;
import com.chavesrodolfo.chef.util.Resources;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class ReceitaTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(Receita.class, ReceitaService.class, Resources.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-ds.xml");
    }

    @Inject
    ReceitaService receitaService;

    @Inject
    Logger log;

    @Test
    public void testReceita() throws Exception {
        Receita receita = new Receita();
        receita.setNome("Brigadeiro de panela");
        receitaService.adicionarReceita(receita);
        assertNotNull(null);
        log.info(receita.getNome() + " foi persistida com o id " + receita.getId());
    }

}
