package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import models.Evento;
import play.db.jpa.JPA;

public class BackendDao {
	public Evento selectOneFriend(Long id) {
        EntityManager em = JPA.em("defaultPersistenceUnit");
        Query q = em.createQuery("select f from Evento f where f.id=?1", Evento.class);
        q.setParameter(1, id);

        // its really "awesome" for JPA hibernate that if i dont have result
        // it punch to my face one big exception"
        Evento result = null;
        try {
            result = (Evento) q.getSingleResult();
        } catch (NoResultException ex) {
            // nothing needed here
        }
        em.close();
        return result;
    }

    public List<Evento> selectSomeEvents(double latitude,double longitude) {
        EntityManager em = JPA.em("defaultPersistenceUnit");
        List<Evento> result =null; 
        	Query q =	em.createQuery("SELECT e,(6371 *"+
        "acos("+
            "cos(radians(?1)) *"+
            "cos(radians(latitude)) *"+
            "cos(radians(?2) - radians(longitude)) +"+
            "sin(radians(?1)) *"+
            "sin(radians(latitude))"+
        ")) AS distance FROM Evento e HAVING distance <= 5 ",Evento.class);
        q.setParameter(1, latitude);
        q.setParameter(2, longitude);
        
        result = q.getResultList();
        
        em.close();
        return result;
    }


    public boolean addOneEvento(Evento evento) {
        EntityManager em = JPA.em("defaultPersistenceUnit");
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
        em.close();
        return true; //TODO not so good
    }

    public boolean deleteOneEvento(long id) {
        EntityManager em = JPA.em("defaultPersistenceUnit");
        em.getTransaction().begin();
        Query q = em.createQuery("delete from Evento f where f.id=?1");
        q.setParameter(1, id);
        int changed = q.executeUpdate();
        em.getTransaction().commit();
        em.close();
        return changed > 0;
    }
}
