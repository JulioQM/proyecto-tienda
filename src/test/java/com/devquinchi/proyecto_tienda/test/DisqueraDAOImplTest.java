package com.devquinchi.proyecto_tienda.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.devquinchi.proyecto_tienda.DAO.DisqueraDAO;
import com.devquinchi.proyecto_tienda.IMPL.DisqueraIMPL;
import com.devquinchi.proyecto_tienda.entity.Disquera;

/**
 * @author Julio
 * Es una clase donde contendra aquellas funciones del CRUD para realizar el TESTEO *
 */
class DisqueraDAOImplTest {
	// Declaro mi objeto DAO y le igualo a al nuevo objeto de Implementacion
	private DisqueraDAO disqueraDAO = new DisqueraIMPL();

	/**
	 * Método testGuardar -> Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.DisqueraIMPL#guardar(com.devquinchi.proyecto_tienda.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("forse");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Método testActualizar -> Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.DisqueraIMPL#actualizar(com.devquinchi.proyecto_tienda.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarById(19L);
		// ojo no inicializar porque los valores de los parametros se hacen nulos
		disqueraConsultada.setDescripcion("chevrolet 2");
		this.disqueraDAO.actualizar(disqueraConsultada);
	}

	/**
	 * Método testEliminar -> Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.DisqueraIMPL#eliminar(com.devquinchi.proyecto_tienda.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarById(13L);
		this.disqueraDAO.eliminar(disqueraConsultada.getIdDisquera());
		System.out.println(" Disquera con ID  " + disqueraConsultada.getIdDisquera() + " fue eliminado con exito");
	}

	/**
	 * Método testConsultar -> Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.DisqueraIMPL#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disquerasConsultadas = this.disqueraDAO.consultar();
		assertTrue(disquerasConsultadas.size() > 0);
		disquerasConsultadas.forEach(disquera -> {
			System.out.println(" Disquera: " + disquera.getDescripcion() + " ID " + disquera.getIdDisquera());
		});
	}

	/**
	 * Método testConsultarById -> Test method for
	 * {@link com.devquinchi.proyecto_tienda.IMPL.DisqueraIMPL#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(20L);
		System.out.println(" Disquera : " + disquera.getDescripcion() + "  ID :" + disquera.getIdDisquera());
	}
	@Test
	void  testConsultarByDescripcionJPQL() {
		Disquera disquera=this.disqueraDAO.consultarByDescripcionJPQL("chevrolet 2");
		assertNotNull(disquera);
		System.out.println("Disquera: "+disquera.getDescripcion());
	}
	@Test
	void  testConsultarByDescripcionNative() {
		Disquera disquera=this.disqueraDAO.consultarByDescripcionNative("chevrolet 2");
		assertNotNull(disquera);
		System.out.println("Disquera: "+disquera.getDescripcion());
	}

}