/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import com.hasz.model.*;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Wizard
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Configuration configuration;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            configuration = new Configuration().configure();
            
            configuration.addAnnotatedClass(AlteracaoPrecoServico.class);
            configuration.addAnnotatedClass(Cidade.class);
            configuration.addAnnotatedClass(Cliente.class);
            configuration.addAnnotatedClass(ClienteFisico.class);
            configuration.addAnnotatedClass(ClienteJuridico.class);
            configuration.addAnnotatedClass(Empresa.class);
            configuration.addAnnotatedClass(Endereco.class);
            configuration.addAnnotatedClass(Estado.class);
            configuration.addAnnotatedClass(Historico.class);
            configuration.addAnnotatedClass(Hotel.class);
            configuration.addAnnotatedClass(Quarto.class);
            configuration.addAnnotatedClass(Reserva.class);
            configuration.addAnnotatedClass(Servico.class);
            configuration.addAnnotatedClass(StatusReserva.class);
            configuration.addAnnotatedClass(TipoQuarto.class);
            configuration.addAnnotatedClass(ReservaServico.class);
            
            // config file.
            sessionFactory = configuration.buildSessionFactory();
            
        } catch (Exception ex) {
            // Log the exception. 
            ex.printStackTrace();
            sessionFactory=null;
        }
    }
    
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
