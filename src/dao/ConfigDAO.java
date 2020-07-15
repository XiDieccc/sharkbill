package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Config;
import util.DBUtil;

public class ConfigDAO {
	
	
	public void add(Config config) {
		String sqladd="insert into config values(null,?,?)";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement ps=c.prepareStatement(sqladd);)
		{
			ps.setString(1, config.key);
			ps.setString(2, config.value);
			ps.execute();
			//检索由执行此Statement对象而创建的任何自动生成的密钥。 如果此Statement对象未生成任何键，则返回空的ResultSet对象。
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()) 
				config.id=rs.getInt("id");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	public void update(Config config) {
		String sqlupdate="update config set key_=?,value_=? where id=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement ps=c.prepareStatement(sqlupdate);)
		{
			ps.setString(1, config.key);
			ps.setString(2, config.value);
			ps.setInt(3, config.id );
			ps.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	public void delete(int id) {
		try(Connection c=DBUtil.getConnection();
				Statement s=c.createStatement();)
		{
			s.execute("delete from config where id="+id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public Config get(int id) {
		Config config=null;
		try(Connection c=DBUtil.getConnection();
				Statement s=c.createStatement();)
		{
			ResultSet rs=s.executeQuery("select * from config where id="+id);
			if(rs.next()) {
				config=new Config();
				config.id=id;
				config.key=rs.getString("key_");
				config.value=rs.getString("value_");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return config;
	}
	
	public Config getByKey(String key) {
        Config config = null;
        String sql = "select * from config where key_ = ?" ;
        try (Connection c = DBUtil.getConnection(); 
                PreparedStatement ps = c.prepareStatement(sql);
            ) {
             
            ps.setString(1, key);
            ResultSet rs =ps.executeQuery();
 
            if (rs.next()) {
                config = new Config();
                config.id = rs.getInt("id");
                config.key = key;
                config.value = rs.getString("value_");
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return config;
    }
	
	public List<Config> list(int start, int count) {
        List<Config> configs = new ArrayList<Config>();
 
        String sql = "select * from config order by id desc limit ?,? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, start);
            ps.setInt(2, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                Config config = new Config();
                config.id = rs.getInt("id");
                config.key = rs.getString("key_");
                config.value = rs.getString("value_");
                configs.add(config);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return configs;
    }
	public List<Config> list() {
        return list(0, Short.MAX_VALUE);
    }
}
