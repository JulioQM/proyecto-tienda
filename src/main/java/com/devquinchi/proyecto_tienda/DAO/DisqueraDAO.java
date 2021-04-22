package com.devquinchi.proyecto_tienda.DAO;

import java.util.List;

import com.devquinchi.proyecto_tienda.entity.Disquera;

/**
 * @author Julio
 *Interfaz que genera el DAO(data abtract o access Object) para las transaciones del CRUD a la tabla de diquera
 * CONTROL+SHIF + J : PARA COMENTARIO
 * */ 
public interface DisqueraDAO {
	/*
	 * Metodos de la interfaz llamado DAO
	 */
	// Interfaz de método guardar
	public void guardar(Disquera disquera);
	// Interfaz de método actualizar
	public void actualizar(Disquera disquera);
	// Interfaz de método eliminar
	public void eliminar(Long id);
	// Interfaz de método consultar
	public  List<Disquera> consultar();
	// Interfaz de método consultarById
	public Disquera consultarById(Long id);
	// Interfaz de método consultarNombre
	/**
	 * Método que permite consultar con JPQL la disquera a partir de una descripcion.
	 * @param descripcion {@link} descripcion de la disquera.
	 * @return {@link Disquera} la disquera consultada.
	 */
	public Disquera consultarByDescripcionJPQL(String descripcion);
	//JPQL NATIVA
	/**
	 * Método que permite consultar con SQL Nativo la disquera a partir de una descripcion.
	 * @param descripcion {@link} descripcion de la disquera.
	 * @return {@link Disquera} la disquera consultada.
	 * Es recomendable de SQL nativo para consultas de varias tablas,sera muy eficiente.
	 */
	public Disquera consultarByDescripcionNative(String descripcion);
	
	

}
