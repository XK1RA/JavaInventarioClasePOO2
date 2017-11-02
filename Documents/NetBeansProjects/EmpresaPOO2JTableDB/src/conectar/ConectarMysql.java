package conectar;

import java.sql.*;

public class ConectarMysql{

static String bd = "eder";
static String login = "root";
static String password = "";
static String url = "jdbc:mysql://localhost/"+bd; 

private Connection conn=null;
private Statement st;
	

public ConectarMysql() throws Exception
{
    try{ 
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url,login,password);
        st = conn.createStatement();
    }
catch(SQLException ex){
System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
System.out.println(ex);
}
catch(ClassNotFoundException ex){
System.out.println(ex);
} 
}

public void ejecutarSQL(String sentencia) 
	throws SQLException,Exception{	
		System.out.println(sentencia);
		st.execute(sentencia);		
	}

public ResultSet ejecutarSql(String sentencia,boolean retorno)throws SQLException,Exception{
		System.out.println(sentencia);
		ResultSet rs;
		rs = st.executeQuery(sentencia);		
		return rs;
	}
}

