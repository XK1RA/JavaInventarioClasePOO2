


package conectar;

import java.sql.*;
public class EjecutarSQL {
    
    private Connection dbconecta;
    
    String a[]; 
    private Statement leam;
    private ResultSet resultado;
    private String dominio;
  
    public void Ingreso(String sql) throws SQLException, Exception{
        Conector.getConector().ejecutarSQL(sql);
    }
  
  public ResultSet consultas(String sql){
      ResultSet resultado = null;
      try{
          resultado = Conector.getConector().ejecutarSql(sql,true);
      }
      catch (SQLException ex) {
          ex.printStackTrace();
      } catch (Exception ex) {
          ex.printStackTrace();
      }        
      return resultado;
   }
   
    
}

