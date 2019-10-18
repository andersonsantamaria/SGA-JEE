/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.data.sga.jee.service;

import co.com.data.sga.jee.domain.Persona;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Anderson
 */
public class PersonaServiceTest {

    private PersonaService personaService;

    @Before
    public void setUp() throws Exception {
        EJBContainer eJBContainer = EJBContainer.createEJBContainer();
        personaService = (PersonaService) eJBContainer.getContext().lookup("java:global/classes/PersonaServiceImpl!co.com.data.sga.jee.service.PersonaService");
    }

    @Test
    public void testEJBPersonaService() {
        System.out.println("Iniciando test EJB PersonaService");
        assertTrue(personaService != null);
        
        assertEquals(2, personaService.listarPersonas().size());
        
        System.out.println("El no. de personas es igual a: "+ personaService.listarPersonas().size());
        
        this.desplegarPersonas(personaService.listarPersonas());
        System.out.println("Fin test EJB PersonaService");
    }
    
    private void desplegarPersonas(List<Persona> personas){
        for (Persona persona: personas){
            System.out.println(persona);
        }
    }
}
