package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.CitaMedica;
import com.uce.edu.repository.modelo.Doctor;
import com.uce.edu.repository.modelo.Paciente;
import com.uce.edu.service.ICitaMedicaService;
import com.uce.edu.service.IDoctorService;
import com.uce.edu.service.IPacienteService;

@SpringBootApplication
public class RepasoLdRyApplication implements CommandLineRunner{
	
	@Autowired
	private IPacienteService iPacienteService;
	@Autowired
	private IDoctorService iDoctorService;
	@Autowired
	private ICitaMedicaService iCitaMedicaService;

	public static void main(String[] args) {
		SpringApplication.run(RepasoLdRyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Doctor doc1 = new Doctor();
		doc1.setCedula("171968729");
		doc1.setNombre("Alejandro");
		doc1.setApellido("Jimenez");
		doc1.setFechaNacimiento(LocalDateTime.now());
		doc1.setNumeroConsultorio("4");
		doc1.setSalario(new BigDecimal(2000));
		doc1.setTitulo("General");
		
		Doctor doc2 = new Doctor();
		doc2.setCedula("1750888404");
		doc2.setNombre("Romina");
		doc2.setApellido("Guevara");
		doc2.setFechaNacimiento(LocalDateTime.now());
		doc2.setNumeroConsultorio("8");
		doc2.setSalario(new BigDecimal(2500));
		doc2.setTitulo("Traumatología");
		
		this.iDoctorService.guardar(doc1);
		this.iDoctorService.guardar(doc2);
		
		
		Paciente paci1 = new Paciente();
		paci1.setCedula("1723353825");
		paci1.setNombre("Leonardo");
		paci1.setApellido("Ramirez");
		paci1.setCodigoIess("I12");
		paci1.setEstatura(1.6);
		paci1.setFechaNacimiento(LocalDateTime.now());
		paci1.setGenero("Gay");
		paci1.setPeso(45.8);
		
		Paciente paci2 = new Paciente();
		paci2.setCedula("1719608728");
		paci2.setNombre("José");
		paci2.setApellido("Jiménez");
		paci2.setCodigoIess("I69");
		paci2.setEstatura(1.7);
		paci2.setFechaNacimiento(LocalDateTime.now());
		paci2.setGenero("Masculino");
		paci2.setPeso(49.5);
		
		this.iPacienteService.guardar(paci1);
		this.iPacienteService.guardar(paci2);
		
		this.iCitaMedicaService.insertarCita(1,LocalDateTime.now(),new BigDecimal(15),"Hospital Carlitos, piso 2", doc2.getCedula(), "1723353825");
		
		this.iCitaMedicaService.actualizarCita(1, "Gaysitis", "Palazos", LocalDateTime.of(2024, 01, 12, 17, 50));
		
		this.iCitaMedicaService.insertarCita(2,LocalDateTime.now(),new BigDecimal(20),"Hospital Carlitos, piso 1", doc2.getCedula(), "1719608728");
		
		this.iCitaMedicaService.insertarCita(3,LocalDateTime.now(),new BigDecimal(25),"Hospital Carlitos, piso 3", doc1.getCedula(), "1719608728");
		
		System.out.println("Reporte de Citas Medicas");
		
		List<CitaMedica> reporteCitasCitaMedicas = this.iCitaMedicaService.imprimirReporte(LocalDateTime.of(2023, 1, 7, 1, 1), new BigDecimal(5));
		
		for(CitaMedica citas: reporteCitasCitaMedicas) {
			System.out.println(citas);
		}
		
	}

}
