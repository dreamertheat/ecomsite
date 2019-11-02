package ecomsite.java.custom;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ecomsite.java.dbmodels.AboutModel;

public class AboutRowMapper implements RowMapper<AboutModel>
{	
	
	private AboutModel mod;
	
	

	public AboutRowMapper(AboutModel mod) {
		this.mod = mod;
	}
	


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
	
	
}
