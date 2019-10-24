package ecomsite.java.dbmodels.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import ecomsite.java.dbmodels.UsersModel;

@Component
public class UsersDAO {

	NamedParameterJdbcTemplate jdbc;

	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<UsersModel> getUsersModel() {

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

	public UsersModel getUserModelByID(int _id) {

		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("_id", _id);
		return jdbc.queryForObject("select * from users where _id=:_id", map, new RowMapper<UsersModel>() {

			@Override
			public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				UsersModel model = new UsersModel();
				model.set_id(rs.getInt("_id"));
				model.setAddress(rs.getString("address"));
				model.setFirst_name(rs.getString("first_name"));
				model.setLast_name(rs.getString("last_name"));
				model.setNotes(rs.getString("notes"));
				model.setBirthdate(rs.getString("birthdate"));
				model.setEnabled(rs.getInt("enabled"));

				return model;
			}

		});

	}

}
