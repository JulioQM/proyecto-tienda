/**
 * 
 */
package com.devquinchi.proyecto_tienda.DAO;

import java.util.List;

import com.devquinchi.proyecto_tienda.entity.Subgenero;

/**
 * @author Julio
 * Interfaz DAO que realiza el CRUD con JPA para Subgenero
 */
public interface SubgeneroDAO {
	/**
	 * Método que permite guardar un Subgenero.
	 * @param subgenero {@link Subgenero} objeto a guardar. 
	 */
	void Guardar(Subgenero subgenero);
	/**
	 * Método que permite actualizar un Subgenero.
	 * @param subgenero {@link Subgenero} objeto a actualizar. 
	 */
	void Actualizar(Subgenero subgenero);
	/**
	 * Método que permite eliminar un Subgenero.
	 * @param idSubGenero {@link Long} objeto a eliminar. 
	 */
	void Eliminar(Long idSubGenero);	
	/**
	 * Método que permite consultar los Subgenero.
	 * @return {@link List} una lista de Subgenero
	 */
	List<Subgenero> Consultar();
	/**
	 * Método que permite buscar un Subgenero por el identificador o ID.
	 * @param idSubGenero {@link Long} objeto a buscar. 
	 * @return un objeto de tipo Subgenero
	 */
	Subgenero ConsultarById(Long idSubGenero);

}
