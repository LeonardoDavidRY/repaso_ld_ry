package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="cita_medica")
public class CitaMedica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cita_medica")
	@SequenceGenerator(name = "seq_cita_medica", sequenceName = "seq_cita_medica", allocationSize = 1)
	@Column(name="cime_id")
	private Integer id;
	@Column(name="cime_numero_turno")
	private Integer numeroTurno;
	@Column(name="cime_fecha_cita")
	private LocalDateTime fechaCita;
	@Column(name="cime_costo_cita")
    private BigDecimal costoCita;
	@Column(name="cime_ligar cita")
    private String lugarCita;
	@Column(name="cime_diagnostico")
    private String diagnosito;
	@Column(name="cime_receta")
    private String receta;
	@Column(name="cime_fecha_control")
    private LocalDateTime fechaControLocal;
	@ManyToOne
	@JoinColumn(name="cime_id_doctor")
	private Doctor doctor;
	@ManyToOne
	@JoinColumn(name="cime_id_paciente")
	private Paciente paciente;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumeroTurno() {
		return numeroTurno;
	}
	public void setNumeroTurno(Integer numeroTurno) {
		this.numeroTurno = numeroTurno;
	}
	public LocalDateTime getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}
	public BigDecimal getCostoCita() {
		return costoCita;
	}
	public void setCostoCita(BigDecimal costoCita) {
		this.costoCita = costoCita;
	}
	public String getLugarCita() {
		return lugarCita;
	}
	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}
	public String getDiagnosito() {
		return diagnosito;
	}
	public void setDiagnosito(String diagnosito) {
		this.diagnosito = diagnosito;
	}
	public String getReceta() {
		return receta;
	}
	public void setReceta(String receta) {
		this.receta = receta;
	}
	public LocalDateTime getFechaControLocal() {
		return fechaControLocal;
	}
	public void setFechaControLocal(LocalDateTime fechaControLocal) {
		this.fechaControLocal = fechaControLocal;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numeroTurno=" + numeroTurno + ", fechaCita=" + fechaCita + ", costoCita="
				+ costoCita + ", lugarCita=" + lugarCita + ", diagnosito=" + diagnosito + ", receta=" + receta
				+ ", fechaControLocal=" + fechaControLocal + "]";
	}
	
    
}
