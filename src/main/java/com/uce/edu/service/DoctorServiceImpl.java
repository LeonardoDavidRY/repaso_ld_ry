package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IDoctorRepository;
import com.uce.edu.repository.modelo.Doctor;
@Service
public class DoctorServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Override
	public void guardar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRepository.insertar(doctor);

	}

}
