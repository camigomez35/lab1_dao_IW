package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.MyException;

/**
 * CRUD
 * @author CamiGomez318
 * @version 1
 */

public interface CiudadDAO {

	public void insertar(Ciudad ciudad) throws MyException;
	public List<Ciudad> obtener() throws MyException;
	public void modificar(Ciudad ciudad) throws MyException;
	public void eliminar(Ciudad ciudad) throws MyException;
	public Ciudad obtener(Long codigo) throws MyException;
	
}
