package ecomsite.java.dbmodels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ecomsite.java.custom.AboutRowMapper;
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

	// retrievelist with static data from properties
	public List<AboutModel> getModelsOld() {

		return jdbc.query("select * from about order by sequence asc", new RowMapper<AboutModel>() {

			@Override
			public AboutModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				AboutModel ad = new AboutModel();

				ad.set_id(rs.getInt(1));
				ad.setName(rs.getString(2));
				ad.setDescription(rs.getString(3));
				ad.setSequence(rs.getInt(4));
				ad.setDate(rs.getString(5));
				ad.setCorporation(mod.getCorporation());
				ad.setAbout(mod.getAbout());
				return ad;
			}
		});

	}
	
	// retrievelist using custom rowMapper
		public List<AboutModel> getModels() {

			return jdbc.query("select * from about order by sequence asc", new AboutRowMapper(mod));

		}

	// retrievelist using BeanPropertyRowMapper
	public List<AboutModel> getModelsBP() {

		return jdbc.query("select * from about", BeanPropertyRowMapper.newInstance(AboutModel.class));

	}

	// delete by ID. Use MapSqlParameterSource to assign individual values
	public int deleteAbout(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("_id", id);
		System.out.println("deleting from dao with id" + id);
		return jdbc.update("delete from about where _id=:_id", map);
	}

	// update via Object or bean if you have one as parameter thus use
	public int updateAbout(AboutModel about) {
		BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(about);
		System.out.println("sequence debug ua2 "+about.getSequence());

		return jdbc.update(
				"update about set name=:name, description=:description, sequence=:sequence, date=:date where _id=:_id",
				map);
	}

	// batch update having pojo list
	@Transactional
	public int[] createAboutFromList(List<AboutModel> aboutList) {
		SqlParameterSource[] source = SqlParameterSourceUtils.createBatch(aboutList.toArray());
		return jdbc.batchUpdate(
				"insert into about (name, description, sequence, date) values (:name, :description, :sequence, :date)",
				source);
	}

	public int createAbout(AboutModel model) {
		model.setDate(new SimpleDateFormat("MMM/dd/yyyy hh:mm:ss").format(new Date()));
		BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(model);
		return jdbc.update(
				"insert into about (name, description, sequence, date) values (:name, :description, :sequence, :date)",
				map);
	}
}
