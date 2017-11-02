package conectar;
 
public class Conector{
	//atributo de la clase	
     private static ConectarMysql conectorBD = null;
	
	/**
	 *M�todo est�tico que devuelve el 
	 *objeto AccesoBD para que sea utilizado
	 *por las clases
	 *@return objeto del tipo AccesoBD del paquete 
	 *CapaAccesoDatos
	 */
	 
	public static ConectarMysql getConector() throws 
	java.sql.SQLException,Exception{
		if (conectorBD == null){			
			conectorBD = new ConectarMysql();
		}
		return conectorBD;
	}
	
}