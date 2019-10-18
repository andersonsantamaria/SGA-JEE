/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.data.sga.jee.client;

import co.com.data.sga.jee.domain.Persona;
import co.com.data.sga.jee.service.PersonaServiceRemote;
import java.util.List;
import java.util.function.Consumer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author santande
 */
public class ClientePersonaService {

    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaServiceRemote = (PersonaServiceRemote) jndi.lookup("java:global/SGA-JEE/PersonaServiceImpl!co.com.data.sga.jee.service.PersonaServiceRemote");

            List<Persona> personas = personaServiceRemote.listarPersonas();

            for(Persona persona: personas){
                System.out.println(persona.toString());
            }
            
            System.out.println("\nFin llamada al EJB desde el cliente");
        } catch (NamingException namingException) {
            namingException.printStackTrace();
        }
    }
}
