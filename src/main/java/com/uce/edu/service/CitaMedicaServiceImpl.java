package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICitaMedicaRepository;
import com.uce.edu.repository.IDoctorRepository;
import com.uce.edu.repository.IPacienteRepository;
import com.uce.edu.repository.modelo.CitaMedica;
import com.uce.edu.repository.modelo.*;
@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {
	
	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;
	@Autowired
	private IDoctorRepository iDoctorRepository;
	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Override
	public void insertarCita(Integer numeroTurno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		CitaMedica c1 = new CitaMedica();
		c1.setNumeroTurno(numeroTurno);
		c1.setFechaCita(fechaCita);
		c1.setCostoCita(costoCita);
		c1.setLugarCita(lugarCita);
		Doctor d1 = this.iDoctorRepository.seleccionarPorCedula(cedulaDoctor);
		c1.setDoctor(d1);
		Paciente p1 = this.iPacienteRepository.seleccionarPorCedula(cedulaPaciente);
		c1.setPaciente(p1);
		this.iCitaMedicaRepository.insertar(c1);
	}

	@Override
	public void actualizarCita(Integer numeroTurno, String diagnostico, String receta, LocalDateTime fecha_control) {
		// TODO Auto-generated method stub
		CitaMedica c1 = this.iCitaMedicaRepository.seleccionarPorNumero(numeroTurno);
		c1.setDiagnosito(diagnostico);
		c1.setReceta(receta);
		c1.setFechaControLocal(fecha_control);
		this.iCitaMedicaRepository.actulizar(c1);
		
		
	}

	@Override
	public List<CitaMedica> imprimirReporte(LocalDateTime fechaCita, BigDecimal costoCita) {
		// TODO Auto-generated method stub
		
		return this.iCitaMedicaRepository.generarReporteCitas(fechaCita, costoCita);
	}

}
