package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LearnJDBC {
	String url = "jdbc:mysql://localhost:3306/learn?user=root&password=123456";
	Connection con;
	PreparedStatement ps;
	
	public Connection getConn() throws SQLException{
		// ��������
		return DriverManager.getConnection(url);
	}
	
	public PreparedStatement getPs(String sql) throws SQLException{
		// ��������
		return con.prepareStatement(sql);
	}
	
	
	/** ��ѯ */
	public void select()
			throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.jdbc.Driver");
		String sql = "SELECT * FROM myclass";
		con = getConn();
		// ����Ԥ����
		ps = getPs(sql);
		// ִ�к󷵻ؽ����
		ResultSet rs = ps.executeQuery();
		
		// ѭ��������
		while(rs.next()){
			System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
		}
	}
	
	/** ����*/
	public void insert()
			throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.jdbc.Driver");
		String sql = "insert into myclass (name, degree) values ('jdbc', '10')";
		
		con = getConn();
		// ����Ԥ����
		ps = getPs(sql);
		// ִ�к󷵻ؽ��
		int rs = ps.executeUpdate();
		// �жϽ��
		if(rs > 0){
			System.out.println("����ɹ�����");
		}
	}
	

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		
		LearnJDBC jdbc = new LearnJDBC();
		jdbc.insert();
		jdbc.select();
	}
}

