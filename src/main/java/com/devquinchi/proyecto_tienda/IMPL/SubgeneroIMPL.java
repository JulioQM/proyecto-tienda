/**
 * 
 */
package com.devquinchi.proyecto_tienda.IMPL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.devquinchi.proyecto_tienda.DAO.SubgeneroDAO;
import com.devquinchi.proyecto_tienda.entity.Subgenero;

/**
 * @author Julio
 * Clase que implementa el CRUD para las transacciones de la tabla SubGenero
 *
 */
public class SubgeneroIMPL implements SubgeneroDAO {
	// Declaro mi persistencia
	private EntityManagerFactory ENTITY_MANAGER_FACTORY=Persistence.createEntityManagerFactory("persistenceDevquinchi");
	// Creo un variable para mi objeto de persistencia.Para llamar en los metodos.
	private EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
	
	/**
	 * Método de Guardar.
	 */
	@Override
	public void Guardar(Subgenero subgenero) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		try {
			em.persist(subgenero);
			et.commit();
		}catch(Exception e) {
			if(et!=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	/**
	 * Método de Actualizar.
	 */
	@Override
	public void Actualizar(Subgenero subgenero) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		try {
			em.merge(subgenero);
			et.commit();
		}catch(Exception e) {
			if(et!=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	/**
	 * Método de Eliminar.
	 */
	@Override
	public void Eliminar(Long idSubGenero) {
		//Primero se consulta luego hace los demás pasos ,cualquiera de las dos formas de consultar o buscar vale.
		//Subgenero generoBuscado=em.find(Subgenero.class, idSubGenero);
		Subgenero generoBuscado=ConsultarById(idSubGenero);
		EntityTransaction et=em.getTransaction();
		et.begin();
		try {			
			em.remove(generoBuscado);
			et.commit();
		}catch(Exception e) {
			if(et!=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	/**
	 * Método de Consultar.
	 */
	@Override
	public List<Subgenero> Consultar() {
		Query q=em.createQuery("FROM Subgenero ORDER BY descripcion ");
		return q.getResultList();
		
	}

	/**
	 * Método de Consultar por el ID
	 */
	@Override
	public Subgenero ConsultarById(Long idSubGenero) {
		// En la prueba unitaria realiza una tercera consulta.
		//EntityManager emm=ENTITY_MANAGER_FACTORY.createEntityManager();   
		//Subgenero subgeneroBuscado=em.find(Subgenero.class, idSubGenero);
		//return subgeneroBuscado;		
		return em.find(Subgenero.class, idSubGenero);
	}

}
