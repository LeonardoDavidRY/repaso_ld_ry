package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Doctor;

public interface IDoctorRepository {
	
	public void insertar (Doctor doctor);
	
	public Doctor seleccionarPorCedula(String cedula);

}
