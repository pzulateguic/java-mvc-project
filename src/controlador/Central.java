package controlador;

import java.sql.Date;
import java.util.ArrayList;

import beans.Alumno;
import modelo.Alumnos;
import vista.FormularioAlumno;

public class Central {

	public void abrirFormularioAlumno() {
		new FormularioAlumno();
		
	}

	public void crearAlumno(String nombre, Date fechaNacimiento) {
		// Llamar al modelo pasandole el alumno
		Alumno alumno = new Alumno(-1, nombre, fechaNacimiento);
		new Alumnos().crearAlumno(alumno);
		
	}
	
	public ArrayList<Alumno> recogerTodosAlumnos(){
		// TODO: Llamar al modelo para recoger los alumnos
		ArrayList<Alumno> alumnos = new Alumnos().recogerAlumnos();
		return alumnos;
	}

}
