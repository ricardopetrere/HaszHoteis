/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;
import util.HibernateUtil;
import com.hasz.model.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ricardo
 */
public class DAO {
    /*
    Bloco padrão para ser utilizado em todas as classes-filho
    
    Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        try{
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            t.commit();
            sessao.close();
        }
    */
}
