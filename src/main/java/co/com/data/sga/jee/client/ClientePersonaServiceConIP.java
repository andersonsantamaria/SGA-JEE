/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.data.sga.jee.client;

import co.com.data.sga.jee.domain.Persona;
import co.com.data.sga.jee.service.PersonaServiceRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author santande
 */
public class ClientePersonaServiceConIP {

    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Properties properties = new Properties();
            properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            properties.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            properties.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");

            Context jndi = new InitialContext(properties);
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
