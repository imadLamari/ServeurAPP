package com.app.dao;




import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.app.util.HibernateUtil;
import com.app.entites.Contract;

	

	@Stateless
	public class ContractDAO {
	  private SessionFactory sessionFactory;

	  public ContractDAO() {
	    sessionFactory = HibernateUtil.getSessionFactory();
	  }

	  public ContractDAO(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	  }

	  public void create(Contract en) {
		  Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            session.save(en);
	            session.getTransaction().commit();
	        } catch (RuntimeException e) {
	            if (trns != null) {
	                trns.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	  }

	  public boolean update(Contract c) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    try {
	      session.update(c);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      return false;
	    } finally {
	      session.close();
	    }
	    return true;
	  }

	

	 

	  @SuppressWarnings("unchecked")
	  public List<Contract> getAll() {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    List<Contract> companies = session.createQuery("select * from contract").list();
	    session.getTransaction().commit();
	    session.close();
	    return companies;
	  }
}



