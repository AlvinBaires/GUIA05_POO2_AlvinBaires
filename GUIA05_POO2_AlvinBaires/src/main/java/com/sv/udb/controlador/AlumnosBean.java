/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelos.Alumnos;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Alvin
 */
@Named(value = "alumnosBean")
@RequestScoped
public class AlumnosBean {
    private Alumnos objeAlum;
    private boolean guar;
    /**
     * Creates a new instance of AlumnosBean
     */
    public AlumnosBean() {
        
    }
    
    @PostConstruct
    public void init()
    {
        this.objeAlum=new Alumnos();
        this.guar=true;
    }

    public Alumnos getObjeAlum() {
        return objeAlum;
    }

    public void setObjeAlum(Alumnos objeAlum) {
        this.objeAlum = objeAlum;
    }
    
    public void Guardar()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(this.objeAlum);
            tx.commit();
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
    }
}
