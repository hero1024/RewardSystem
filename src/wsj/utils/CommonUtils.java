package wsj.utils;
import java.sql.*;
public class CommonUtils {
	/**  * ����ĵ���ģʽ  */
	private static CommonUtils instance;
	public static CommonUtils getInstance() {
	if (instance == null)
	instance = new CommonUtils();
	return instance;
	}
	/**  * ��ȡ���ݿ�����  */
	public Connection getDatabaseConnection() {
	String url = "jdbc:sqlite::resource:ddlt.db3";
	//resource����srcĿ¼
	Connection connection = null;
	try {
	Class.forName("org.sqlite.JDBC");
	connection = DriverManager.getConnection(url);
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	} catch (SQLException e) {
	e.printStackTrace(); 
	}
	return connection;
	}
	
	public void closeAll(ResultSet rs,Statement st,Connection conn) {
		if(rs!=null){
			try{
				rs.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
