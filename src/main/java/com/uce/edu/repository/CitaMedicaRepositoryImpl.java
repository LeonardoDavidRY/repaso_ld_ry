package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);

	}

	@Override
	public void actulizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);

	}

	@Override
	public CitaMedica seleccionarPorNumero(Integer numeroTurno) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT n FROM CitaMedica n WHERE n.numeroTurno = :variable");
		myQuery.setParameter("variable", numeroTurno);
		return (CitaMedica) myQuery.getSingleResult();
	}

	@Override
	public List<CitaMedica> generarReporteCitas(LocalDateTime fechaCita, BigDecimal costoCita) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery(
				"SELECT c FROM CitaMedica c WHERE c.fechaCita > :fecha AND c.costoCita > :costo", CitaMedica.class);
		myQuery.setParameter("fecha", fechaCita);
		myQuery.setParameter("costo", costoCita);
		
		return myQuery.getResultList();
	}

}
