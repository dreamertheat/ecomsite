package ecomsite.java.dbmodels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ecomsite.java.dbmodels.UsersModel;

@Component
public class UsersDAO {
	
	JdbcTemplate jdbc;

	
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	public List<UsersModel> getUsersModel(){
		
		jdbc.query("select * from users", new RowMapper<UsersModel>() {

			@Override
			public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				UsersModel mod = new UsersModel();
				mod.set_id(rs.getInt(1));
				mod.setFirst_name(rs.getString(2));
				mod.setLast_name(rs.getString(3));
				mod.setAddress(rs.getString(4));
				mod.setBirthdate(rs.getString(5));
				return mod;
			}
			
			
		});
		
		return null;
		
	}
	
	
}
