package org.sfsoft.cine.base;

// Generated 22-ene-2014 16:31:59 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "director", catalog = "db_peliculas")
public class Director implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private Date fechaNacimiento;
	private Set<Pelicula> peliculas = new HashSet<Pelicula>(0);

	public Director() {
	}

	public Director(String nombre) {
		this.nombre = nombre;
	}

	public Director(String nombre, Date fechaNacimiento, Set<Pelicula> peliculas) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.peliculas = peliculas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 200)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento", length = 10)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
	public Set<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}