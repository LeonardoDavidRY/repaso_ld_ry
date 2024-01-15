package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.CitaMedica;

public interface ICitaMedicaService {
	
	public void insertarCita(Integer numeroTurno, LocalDateTime fechaCita,
			BigDecimal costoCita,String lugarCita, String cedulaDoctor, String cedulaPaciente);

	public void actualizarCita(Integer numeroTurno,String diagnostico, String receta, LocalDateTime fecha_control);
	
	public List<CitaMedica> imprimirReporte(LocalDateTime fechaCita, BigDecimal costoCita);
	

}
