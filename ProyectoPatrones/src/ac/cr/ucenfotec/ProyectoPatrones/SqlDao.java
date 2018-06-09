package ac.cr.ucenfotec.ProyectoPatrones;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDao {
	// JDBC driver name and database URL
   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   protected String DB_URL = "jdbc:mysql://127.0.0.1/proyecto_patrones";

   //  Database credentials
   protected String USER = "patrones";
   protected String PASS = "patrones"; 
   
   public Connection conn = null;
   
   public SqlDao() {
	   
   }
   
   public SqlDao(String nameDB, String user, String pass ) {
	   this.DB_URL = "jdbc:mysql://localhost/"+nameDB;
	   this.USER = user;
	   this.PASS = pass; 
   }

   public String getDB_URL() {
	   return DB_URL;
   }
	
	public String getUSER() {
		return USER;
	}
	
	public String getPASS() {
		return PASS;
	}
	
	public void Connect() throws Exception {
		
		try {
			//Register JDBC driver
			Class.forName(this.JDBC_DRIVER);
		
			//Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      
			
		}catch(SQLException se){
			//Handle errors for JDBC
			throw se;
	    }catch(Exception e){
	    	//Handle errors for Class.forName
	    	throw e;
	    }//end try

	}
	
	public <T> void NewRecord(T obj) throws Exception {
		Statement stmt = null;

		try {
			this.Connect();
			String nameTable =  obj.getClass().getName().toLowerCase();
			List<String> columns = new ArrayList<String>();
			List<String> values = new ArrayList<String>();
			for (Field f : obj.getClass().getDeclaredFields()) {
			    columns.add(f.getName().toLowerCase());
			    values.add((String)f.get(obj));
			}
			
			String sql = "INSERT INTO " +nameTable +" ("+columns+") VALUES ("+values+")";
			
			stmt.executeQuery(sql);
		}catch(SQLException se){
			//Handle errors for JDBC
			throw se;
	    }catch(Exception e){
	    	//Handle errors for Class.forName
	    	throw e;
	    }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	    	  throw se;
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	    	  throw se;
	      }//end finally try
	    }
	}
	
	public <T> ResultSet RetrieveAll(T obj) throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			this.Connect();
			String nameTable =  obj.getClass().getName().toLowerCase();
			
			String sql = "SELECT * FROM "+ nameTable;
			
			 rs = stmt.executeQuery(sql);
		}catch(SQLException se){
			//Handle errors for JDBC
			throw se;
	    }catch(Exception e){
	    	//Handle errors for Class.forName
	    	throw e;
	    }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	    	  throw se;
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	    	  throw se;
	      }//end finally try
	    }
		return rs;
	}

	public <T> ResultSet RetrieveById(T obj) throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			this.Connect();
			String nameTable =  obj.getClass().getName().toLowerCase();
			List<String> columns = new ArrayList<String>();
			List<String> values = new ArrayList<String>();
			for (Field f : obj.getClass().getDeclaredFields()) {
			    columns.add(f.getName().toLowerCase());
			    values.add((String)f.get(obj));
			}
			
			String sql = "SELECT * FROM " + nameTable + " WHERE id =" + values.get(0);
			
			rs = stmt.executeQuery(sql);
			
		}catch(SQLException se){
			//Handle errors for JDBC
			throw se;
	    }catch(Exception e){
	    	//Handle errors for Class.forName
	    	throw e;
	    }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	    	  throw se;
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	    	  throw se;
	      }//end finally try
	    }
		return rs;
	}
}
