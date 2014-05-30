/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.dao;

import com.hasz.model.*;
import com.hasz.model.Cliente;
import com.hasz.model.Reserva;
import com.hasz.model.ReservaServico;
import com.hasz.model.Servico;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Ricardo
 */
public class ReservaDAO extends DAO {

    public static List<Reserva> listarReservasEmAberto() {
        Session sessao = HibernateUtil.getSession();
        List<Reserva> retorno = new ArrayList<Reserva>();
        try {
            Query select = sessao.createQuery("from Reserva where idStatusReserva in (1,2)");
            retorno = select.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
            return retorno;
        }
    }

    public static List<Reserva> listarReservasByIdCliente(int idCliente) {
        Session sessao = HibernateUtil.getSession();
        List<Reserva> retorno = null;
        try {
            Query select = sessao.createQuery("from Reserva where idCliente = :idCliente");
            select.setInteger("idCliente", idCliente);
            retorno = select.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
            return retorno;
        }
    }

    public static void cadastrarReserva(Reserva r, List<Servico> s) {
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        try {
            r.setData(new Date());
            r.setCliente((Cliente) sessao.get(Cliente.class, r.getCliente().getIdCliente()));
            r.setHotel((Hotel) sessao.get(Hotel.class, r.getHotel().getIdHotel()));
            r.setQuarto((Quarto) sessao.get(Quarto.class, r.getQuarto().getIdQuarto()));
            
            for (int n = 0; n < s.size(); n++) {

                ReservaServico rs = new ReservaServico();
                Servico sTemp = s.get(n);
                rs.setData(new Date());
                //r.getReservaservico().add(rs);
                //s.get(n).getReservaservico().add(rs);

//                ReservaServico rs = new ReservaServico();
//                ReservaServicoId rsID = new ReservaServicoId();
//                Servico sAux = s.get(n);
//                rsID.setReserva(r);
//                rsID.setServico(sAux);
//                rs.setReservaServicoId(rsID);
//                rs.setData(new Date());
//                sessao.saveOrUpdate(rs);
                sessao.saveOrUpdate(rs);
            }
            sessao.saveOrUpdate(r);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            t.commit();
            sessao.close();
        }
    }

    public static List<Reserva> listarReservasByIdQuarto(int idQuarto) {
        Session sessao = HibernateUtil.getSession();
        List<Reserva> retorno = null;
        try {
            Query select = sessao.createQuery("from Reserva where idQuarto = :idQuarto");
            select.setInteger("idQuarto", idQuarto);
            retorno = select.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
            return retorno;
        }
    }

    public static List<Reserva> listarReservasByIdHotel(int idHotel) {
        Session sessao = HibernateUtil.getSession();
        List<Reserva> retorno = null;
        try {
            Query select = sessao.createQuery("from Reserva where idHotel = :idHotel");
            select.setInteger("idHotel", idHotel);
            retorno = select.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
            return retorno;
        }
    }

    public static List<Reserva> listarReservasByIdStatusReserva(int idStatusReserva) {
        Session sessao = HibernateUtil.getSession();
        List<Reserva> retorno = null;
        try {
            Query select = sessao.createQuery("from Reserva where idStatusReserva = :idStatusReserva");
            select.setInteger("idStatusReserva", idStatusReserva);
            retorno = select.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
            return retorno;
        }
    }

    public static Reserva buscaServicoById(int idReserva) {
        Session sessao = HibernateUtil.getSession();
        Reserva retorno = new Reserva();
        try{
            Query select = sessao.createQuery("from Reserva where idReserva = :idReserva");
            select.setInteger("idReserva", idReserva);
            List<Reserva> servicos = select.list();
            if(servicos.size()==1)
                retorno = servicos.get(0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            sessao.close();
            return retorno;
        }
    }
}
