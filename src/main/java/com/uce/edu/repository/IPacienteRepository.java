package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Paciente;

public interface IPacienteRepository {
	
	public void insertar(Paciente paciente);
	
	public Paciente seleccionarPorCedula(String cedula);

}
