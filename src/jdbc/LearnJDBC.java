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
		// 建立连接
		return DriverManager.getConnection(url);
	}
	
	public PreparedStatement getPs(String sql) throws SQLException{
		// 建立连接
		return con.prepareStatement(sql);
	}
	
	
	/** 查询 */
	public void select()
			throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.jdbc.Driver");
		String sql = "SELECT * FROM myclass";
		con = getConn();
		// 建立预处理
		ps = getPs(sql);
		// 执行后返回结果集
		ResultSet rs = ps.executeQuery();
		
		// 循环输出结果
		while(rs.next()){
			System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
		}
	}
	
	/** 插入*/
	public void insert()
			throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.jdbc.Driver");
		String sql = "insert into myclass (name, degree) values ('jdbc', '10')";
		
		con = getConn();
		// 建立预处理
		ps = getPs(sql);
		// 执行后返回结果
		int rs = ps.executeUpdate();
		// 判断结果
		if(rs > 0){
			System.out.println("插入成功！！");
		}
	}
	

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		
		LearnJDBC jdbc = new LearnJDBC();
		jdbc.insert();
		jdbc.select();
	}
}

