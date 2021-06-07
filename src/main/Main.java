package main;

import bbdd.Conexion;
import vistas.Login;

public class Main {

	public static void main(String[] args) {
		Conexion.conectar();
		new Login();
	}

}
