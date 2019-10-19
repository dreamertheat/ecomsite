package ecomsite.java.dbmodels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ecomsite.java.dbmodels.AboutModel;

@Component
public class AboutDAO {
	
	JdbcTemplate jdbc;
	@Autowired
	AboutModel mod;
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	public List<AboutModel> getModels(){
		
		return jdbc.query("select * from about", new RowMapper<AboutModel>() {
			
			@Override
			public AboutModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				mod.set_id(rs.getInt(1));
				mod.setName(rs.getString(2));
				mod.setDescription(rs.getString(3));
				mod.setSequence(rs.getInt(4));
				mod.setDate(rs.getString(5));
				return mod;
			}
		});
		
	}
	
}
