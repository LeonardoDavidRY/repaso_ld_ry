package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {
	
	public void insertar(CitaMedica citaMedica);
	
	public void actulizar(CitaMedica citaMedica);
	
	public CitaMedica seleccionarPorNumero(Integer numeroTurno);
	
	public List<CitaMedica> generarReporteCitas(LocalDateTime fechaCita, BigDecimal costoCita);

}
