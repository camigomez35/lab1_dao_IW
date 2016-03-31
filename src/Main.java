import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAOImpl;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.MyException;

public class Main {

	public static CiudadDAOImpl dao = new CiudadDAOImpl();

	public static void main(String[] args){
		
		//Muestro todas las ciudades
		obtenerTodo();
		
		//Creo una ciudad para insertar
		Ciudad ciudad = new Ciudad();
		Long codigo = (long) 318;
		
		ciudad.setNombre("Mi ciudad");
		ciudad.setCodigo(codigo);
		ciudad.setCodigoArea("203");
		//Insertar la ciudad
		insertar(ciudad);
		//Muestro que fue agregada
		obtener(codigo);
		
		//Creo una ciudad que deseo modificar
		ciudad.setNombre("Mi ciudad fue editada");
		ciudad.setCodigo(codigo);
		ciudad.setCodigoArea("203");
		modificar(ciudad);
		System.out.println("Ya se editó");
		obtenerTodo();

		//Eliminar
		eliminar(codigo);
		obtenerTodo();
	}
	
	public static void obtenerTodo(){
		List<Ciudad> lista = null;
		try {
			lista = dao.obtener();
			for (Ciudad ciudad:lista) {
				System.out.println("Nombre: " + ciudad.getNombre());
			}
		} catch (MyException e) {
			System.out.println(e.getCause());
		}
	}
	
	public static void insertar(Ciudad ciudad){
		try {
			dao.insertar(ciudad);
		} catch (MyException e) {
			System.out.println(e.getCause());
		}
	}
	
	public static void modificar(Ciudad ciudad){
		try {
			dao.modificar(ciudad);
		} catch (MyException e) {
			System.out.println(e.getCause());
		}
	}
	
	public static void obtener(Long codigo){
		Ciudad ciudad = null;
		try {
			ciudad = dao.obtener(codigo);
			System.out.println("Nombre: " + ciudad.getNombre());
		} catch (MyException e) {
			System.out.println(e.getCause());
		}
	}
 
	public static void eliminar(Long codigo){
		Ciudad ciudad = null;
		try {
			ciudad = dao.obtener(codigo);
			dao.eliminar(ciudad);
			System.out.println("Eliminado!!");
		} catch (MyException e) {
			System.out.println(e.getCause());
		}
	}
}
