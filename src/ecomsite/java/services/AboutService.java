package ecomsite.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecomsite.java.dbmodels.AboutModel;
import ecomsite.java.dbmodels.DAO.AboutDAO;
import ecomsite.java.dbmodels.DAO.UsersDAO;

@Service
public class AboutService {
	
	private AboutDAO aboutdao;
	private UsersDAO usersdao;
	
	
	
	
	
	@Autowired
	public AboutService(AboutDAO aboutdao, UsersDAO usersdao) {

		this.aboutdao = aboutdao;
		this.usersdao = usersdao;
	}



	public UsersDAO getUsersdao() {
		return usersdao;
	}



	public void setUsersdao(UsersDAO usersdao) {
		this.usersdao = usersdao;
	}



	public AboutDAO getAboutdao() {
		return aboutdao;
	}

	public void setAboutdao(AboutDAO aboutdao) {
		this.aboutdao = aboutdao;
	}

	
	public List<AboutModel> getModels(){
		
		return aboutdao.getModels();
	}
	
	
}
