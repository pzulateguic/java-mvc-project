package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.Conexion;
import beans.Alumno;

public class Alumnos {

	public void crearAlumno(Alumno alumno) {
		String nombre = alumno.getNombre();
		Date fechaNacimiento = alumno.getFechaNacimiento();

		Conexion.ejecutarUpdate("INSERT INTO alumnos (nombre, fecha_nacimiento) VALUES ('"+nombre+"', '"+fechaNacimiento+"');");
		
	}
	
	public ArrayList<Alumno> recogerAlumnos(){
		// TODO: Hacer la petición a BBDD para recoger los alumnos
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ResultSet resultado = Conexion.ejecutarSentencia("SELECT * FROM alumnos;");
		try {
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
				alumnos.add(new Alumno(id, nombre, fechaNacimiento));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
}
