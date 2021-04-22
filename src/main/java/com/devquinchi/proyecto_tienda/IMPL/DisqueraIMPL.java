/**
 * 
 */
package com.devquinchi.proyecto_tienda.IMPL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.devquinchi.proyecto_tienda.DAO.DisqueraDAO;
import com.devquinchi.proyecto_tienda.entity.Disquera;

/**
 * @author Julio Lo de DisqueraDAO implemento en la la clase
 *         DisqueraIMPL(significa la clase donde se va implementar todos los
 *         metodos de DAO). Los método que realizen cambios como lo del CRUD
 *         son: Registrar,Actualizar,Eliminar son de tipo transaccion, Y los de
 *         consultar como no realizan cambios no seria de tipo transaccion.
 */

public class DisqueraIMPL implements DisqueraDAO {
	// Declaro mi persistencia
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDevquinchi");
	// Creo una variable Global para mi Persistencia
	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

	/**
	 * Método Guardar
	 */
	@Override
	public void guardar(Disquera disquera) {
		// En este apartado podemos observar que es de tipo transaccion ya que ara
		// cambios en la BD.
		// La variable "et" tiene que ver con el proceso de cambios en la BD.
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	/**
	 * Método Actualizar
	 */
	@Override
	public void actualizar(Disquera disquera) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	/**
	 * Método Eliminar
	 */
	@Override
	public void eliminar(Long id) {
		// Declaro mi objeto y busco y luego guardo el objeto buscado de disquera por ID
		Disquera disqueraConsultado = em.find(Disquera.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(disqueraConsultado);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	/**
	 * Método Consultar
	 */
	@Override
	public List<Disquera> consultar() {
		// Creo una consulta de SQL
		String consulta = "SELECT s FROM Disquera s";
		Query q = em.createQuery(consulta, Disquera.class);
		return q.getResultList();
	}

	/**
	 * Método ConsultarById
	 */
	@Override
	public Disquera consultarById(Long id) {
		Disquera disqueraConsultado = em.find(Disquera.class, id);
		if (disqueraConsultado == null) {
			throw new EntityNotFoundException("lA DISQUERA CON ID " + id + " NO SE ENCONTRO");
		}
		return disqueraConsultado;
	}

	@Override
	public Disquera consultarByDescripcionJPQL(String descripcion) {		
		TypedQuery<Disquera> queryDisquera=(TypedQuery<Disquera>) em.createQuery("FROM Disquera WHERE descripcion = :desc");
		queryDisquera.setParameter("desc", descripcion);
		return queryDisquera.getSingleResult();
	}

	@Override
	public Disquera consultarByDescripcionNative(String descripcion) {
		// Con SQL nativo puedo usar la propia sintaxis de SQL puro.
		//TypedQuery<Disquera> queryDisquera=(TypedQuery<Disquera>) em.createNativeQuery("SELECT*FROM disquera WHERE descripcion = :desc",Disquera.class);
		TypedQuery<Disquera> queryDisquera=(TypedQuery<Disquera>) em.createNativeQuery("SELECT*FROM disquera WHERE descripcion = ?",Disquera.class);
		//queryDisquera.setParameter("desc", descripcion);
		queryDisquera.setParameter(1, descripcion);
		return queryDisquera.getSingleResult();
		
	}



}
