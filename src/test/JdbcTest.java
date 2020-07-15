package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class JdbcTest {

	public static void main(String[] args) {
		
			
			
			String sql = "insert into config values(null,?,?)";
			String sel ="select * from config";
			String del="delete from config";
			try(Connection c=DBUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					Statement s = c.createStatement();)
			{
				s.execute(del);
				ps.setString(1, "lalal");
				ps.setString(2, "101010");
				ps.execute();
				
				ResultSet rs = s.executeQuery(sel);
				while (rs.next()) {
	                int id = rs.getInt("id");
	                String key = rs.getString(2);// 也可以使用字段的顺序
	                String value = rs.getString(3);
	                System.out.printf("%d\t%s\t%s%n", id, key, value);
				}
						
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		
	}

}
