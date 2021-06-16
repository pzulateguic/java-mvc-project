package controlador;

import java.sql.Date;
import java.util.ArrayList;

import beans.Alumno;
import modelo.Alumnos;
import vista.FormularioAlumno;
import vista.FormularioAlumnoModificar;

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
	
	public void borrarAlumno(int id) {
		new Alumnos().borrarAlumno(id);
	}

	public void modificarAlumno(Alumno alumno) {
		// Llamar al modelo para actualizar el alumno en la BBDD
		new Alumnos().modificarAlumno(alumno);
	}

	public void AbrirFormularioAlumnoModificar(Alumno alumno) {
		new FormularioAlumnoModificar(alumno);
	}
	
}
