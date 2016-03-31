package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.MyException;

/**
 * 
 * @author CamiGomez318
 * @version 1
 */
public class CiudadDAOImpl implements CiudadDAO {

	Connection con =null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	Proyecto ds = new Proyecto();
	
	@Override
	public void insertar(Ciudad ciudad) throws MyException {
		try{
			Ciudad existe = obtener(ciudad.getCodigo());
			if(existe != null){
				System.out.println("La ciudad que desea insertar ya existe");
				return;
			}else{
				con = ds.getConnection();
				String insert = "Insert into ciudades (codigo, Nombre, CodigoArea) values (?, ?, ?)";
				ps = con.prepareStatement(insert);
				ps.setLong(1, ciudad.getCodigo());
				ps.setString(2, ciudad.getNombre());
				ps.setString(3, ciudad.getCodigoArea());				
				boolean rs = ps.execute();
				if(!rs){
					System.out.println("Se agrego la nueva ciudad");
				}else{
					System.out.println("No se ha agregado la nueva ciudad");
				}
			}
		}catch(MyException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null){
					ps.close();
				}else if (con!=null){
					con.close();
				}
			} catch (SQLException e2) {
				throw new MyException(e2);
			}
		}
	}

	@Override
	public List<Ciudad> obtener() throws MyException {
		
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		

		try{
				//@Realizo y obtengo la conexión
				con = ds.getConnection();
				ps = con.prepareStatement("Select * from Ciudades");
				rs = ps.executeQuery();
				while(rs.next()){
					Ciudad ciudad = new Ciudad();
					ciudad.setCodigo(rs.getLong("codigo"));
					ciudad.setNombre(rs.getString("nombre"));
					ciudad.setCodigoArea(rs.getString("codigoArea"));
					ciudades.add(ciudad);
				} 
			} catch(SQLException e){
				throw new MyException();
			} finally{
				try{
					if (rs!=null) {
						rs.close();
					}
					if (con!=null) {
						con.close();
					}
					if (ps!=null) {
						ps.close();
					}
				}catch (SQLException e2) {
						throw new MyException(e2);
					}
				
			}
		return ciudades;
	}

	@Override
	public void modificar(Ciudad ciudad) throws MyException {
		try{
			Ciudad existe = obtener(ciudad.getCodigo());
			if(existe == null){
				System.out.println("La ciudad que desea modificar no existe");
				return;
			}
			con = ds.getConnection();
			String mod = "Update Ciudades set nombre=?, codigoArea=? WHERE codigo=?";
			ps = con.prepareStatement(mod);
			ps.setLong(3, ciudad.getCodigo());
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, ciudad.getCodigoArea());
			ps.executeUpdate();
		}catch(MyException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null){
					ps.close();
				}else if (con!=null){
					con.close();
				}
			} catch (SQLException e2) {
				throw new MyException(e2);
			}
		}
		
	}

	@Override
	public void eliminar(Ciudad ciudad) throws MyException {
		try{
			con = ds.getConnection();
			ps = con.prepareStatement("Delete from Ciudades WHERE codigo=?");
			ps.setLong(1, ciudad.getCodigo());
			ps.execute();
		} catch(SQLException e){
				throw new MyException();
			} finally{
				try{
					if (con!=null) {
						con.close();
					}
					if (ps!=null) {
						ps.close();
					}
				}catch (SQLException e2) {
						throw new MyException(e2);
					}	
			}
		
		
	}

	@Override
	public Ciudad obtener(Long codigo) throws MyException {

		Ciudad ciudad = new Ciudad();
		try{
			con = ds.getConnection();
			ps = con.prepareStatement("Select * from Ciudades WHERE codigo=?");
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			if(rs.next()){
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}else{
				return null;
			}
			
		} catch(SQLException e){
				throw new MyException();
			} finally{
				try{
					if (rs!=null) {
						rs.close();
					}
					if (con!=null) {
						con.close();
					}
					if (ps!=null) {
						ps.close();
					}
				}catch (SQLException e2) {
					throw new MyException(e2);
				}
			}
		return ciudad;
	}

	
}
