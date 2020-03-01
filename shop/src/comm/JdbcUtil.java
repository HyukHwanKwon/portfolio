package comm;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	public static Connection getConnection(){
		Connection con = null;
		try {						//DBCP(DatabaseConnectionPool)
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/shopping");
			con = ds.getConnection();
			con.setAutoCommit(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Statement st) {
		try {
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void close(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
}
	
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("Commit Success!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("Rollback Success!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
