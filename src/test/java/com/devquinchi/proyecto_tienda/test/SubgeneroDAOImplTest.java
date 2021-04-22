/**
 * 
 */
package com.devquinchi.proyecto_tienda.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devquinchi.proyecto_tienda.DAO.SubgeneroDAO;
import com.devquinchi.proyecto_tienda.IMPL.SubgeneroIMPL;
import com.devquinchi.proyecto_tienda.entity.Genero;
import com.devquinchi.proyecto_tienda.entity.Subgenero;

/**
 * @author Julio
 *
 */
class SubgeneroDAOImplTest {
	// Declaro mi objeto DAO y le igualo a al nuevo objeto de Implementacion
	private SubgeneroDAO subgeneroDAO = new SubgeneroIMPL();

	/**
	 * Método de testeo de Guardar. Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.SubgeneroIMPL#Guardad(com.devquinchi.proyecto_tienda.entity.Subgenero)}.
	 */
	@Test
	void testGuardar() {
		// En este apartado se encuentra todo el contenido que se guardara en Subgenero.
		Subgenero subGenero = new Subgenero();
		subGenero.setDescripcion("Balada 90 nuevo");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);

		// En este apartado se encuentra todo el contenido que se guardara en Genero.
		Genero genero = new Genero();
		genero.setDescripcion("BAlada");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);

		subGenero.setGenero(genero);
		
		this.subgeneroDAO.Guardar(subGenero);

	}

	/**
	 * Método de testeo de Actualizar. Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.SubgeneroIMPL#Actualizar(com.devquinchi.proyecto_tienda.entity.Subgenero)}.
	 */
	@Test
	void testActualizar() {
		Subgenero subGeneroConsultado = this.subgeneroDAO.ConsultarById(8L);

		subGeneroConsultado.setDescripcion("Balada 80");
		subGeneroConsultado.getGenero().setDescripcion("Baladas amor");

		this.subgeneroDAO.Actualizar(subGeneroConsultado);

	}

	/**
	 * Método de testeo de Eliminar. Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.SubgeneroIMPL#Eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subgeneroDAO.Eliminar(8L);
	}

	/**
	 * Método de testeo de Consultar. Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.SubgeneroIMPL#Consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Subgenero> subgeneroConsultada = this.subgeneroDAO.Consultar();		
		assertTrue(subgeneroConsultada.size() > 0);
		subgeneroConsultada.forEach(subgenero -> {
			System.out.println("Subgenero :" + subgenero.getDescripcion());
			System.out.println("Genero :" + subgenero.getGenero().getDescripcion());
		});
	}

	/**
	 * Método de testeo de consultar por ID Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.SubgeneroIMPL#ConsultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Subgenero subgeneroConsultado = this.subgeneroDAO.ConsultarById(7L);
		assertNotNull(subgeneroConsultado);
		System.out.println("Subgenero: " + subgeneroConsultado.getDescripcion());

	}

}
