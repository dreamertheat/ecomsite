package ecomsite.java.dbmodels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecomsite.java.dbmodels.AboutModel;

@Component
public class AboutDAO {
	
	NamedParameterJdbcTemplate jdbc;
	@Autowired
	AboutModel mod;
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	//retrievelist
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
	//delete by ID. Use MapSqlParameterSource to assign individual values
	public int deleteAbout(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("_id", id);
		return jdbc.update("delete from about where _id=:id",map);
	}
	//update via Object or bean if you have one as parameter thus use 
	public boolean updateAbout(AboutModel about) {
		BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(about);
		return jdbc.update("update about set _id=:id, name=:name, description=:description, sequence=:sequence. date=:date",map)==1;
	}
	//batch update having pojo list
	@Transactional
	public int[] createAboutFromList(List<AboutModel> aboutList) {
		SqlParameterSource[] source = SqlParameterSourceUtils.createBatch(aboutList.toArray());
		return jdbc.batchUpdate("insert into about (name, description, sequence, date) values (:name, :description, :sequence, :date)", source);
	}
	
}
