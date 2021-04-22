/**
 * 
 */
package com.devquinchi.proyecto_tienda.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * *
 * 
 * @author Julio clase que representa las entidades que se mapea a la tabla de
 *         Subgenero JPA
 */
@Entity
@Table(name = "Subgenero")
public class Subgenero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSubGenero") // No es necesario esta sentencia
	private Long idSubGenero;

	@Column(name = "descripcion")
	private String descripcion;

	/**
	 * En es apartado creo la relacion de muchos a uno , para traer el objeto
	 * relacionado  "Genero" y de ahi tomara el ID.
	 */
	// Realiza lo mismo por defecto con EAGER
	//@ManyToOne
	//@ManyToOne(fetch = FetchType.EAGER) // HACE LA CONSULTA ESE MISMO RATO DE TODOS EL CODIGO, O EJECUCION DE GOLPE ,LA CONSULTA MAS TARDADA EN GRANDES INFORMACIONES.SIRVE PARA POCAS TABLAS RELACIONADAS Y OPOCA INFORMACION.
	@ManyToOne(fetch = FetchType.LAZY) //HACE LA CONSULTA AL MOMENTO QUE SE UTILIZA O SE LE INVOCA, ES MAS EFICIENITES Y TIENE UNA GRAN VENTAJA.SIRVE PARA GRANDES TABLAS RELACIONADAS Y MUCHA INFORMACION
	@JoinColumn(name = "idGenero")
	@Cascade(CascadeType.REMOVE) //Sirve aquellas operaciones que hacen cambios o transacciones como(guardar,eliminar,actualizar), esto afectara a ambas tablas relacionadas.
	private Genero Genero;

	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;

	@Column(name = "estatus")
	private boolean estatus;

	/**
	 * @return the idSubGenero
	 */
	public Long getIdSubGenero() {
		return idSubGenero;
	}

	/**
	 * @param idSubGenero the idSubGenero to set
	 */
	public void setIdSubGenero(Long idSubGenero) {
		this.idSubGenero = idSubGenero;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the objeto de idGenero
	 */
	public Genero getGenero() {
		return Genero;
	}

	/**
	 * @param idGenero the Genero to set
	 */
	public void setGenero(Genero idGenero) {
		this.Genero = idGenero;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
