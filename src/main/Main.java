package main;

import bbdd.Conexion;
import vista.Login;
import vista.TablaAlumnos;

public class Main {

	public static void main(String[] args) {
		Conexion.conectar();
		//new Login();
		new TablaAlumnos();
	}

}
