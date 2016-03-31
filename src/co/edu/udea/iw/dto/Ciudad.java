package co.edu.udea.iw.dto;

/**
 * 
 * @author CamiGomez318
 * @version 1
 */
public class Ciudad {

	//Variables
	private Long codigo;
	private String nombre;
	private String codigoArea;
	
	
	/**
	 * Get codigo
	 * @return
	 */
	public Long getCodigo() {
		return codigo;
	}
	/**
	 * Set codigo
	 * @param codigo
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	/**
	 * Get nombre
	 * @return 
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Set nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Get codigo de area
	 * @return
	 */
	public String getCodigoArea() {
		return codigoArea;
	}
	/**
	 * Set codigo de area
	 * @param codigoArea
	 */
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
}
