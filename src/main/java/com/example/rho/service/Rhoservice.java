package com.example.rho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rho.model.RhoUsers;
import com.example.rho.repository.rhorepo;

@Service
public class Rhoservice implements Rhointerface{

	@Autowired
	rhorepo objrepo;
	
	@Override
	public RhoUsers usersave(String name, String email, String password) {
		// TODO Auto-generated method stub
		
		RhoUsers objrho=new RhoUsers();
		objrho.setName(name);
		objrho.setEmail(email);
		objrho.setPassword(password);
		return objrepo.save(objrho);
	}
	
	 public boolean validateUser(String email, String password) {
	        return objrepo.findByEmail(email)
	            .filter(user -> user.getPassword().equals(password))
	            .isPresent();
	    }

	@Override
	public List<RhoUsers> getallUsers() {
		// TODO Auto-generated method stub
		return objrepo.findAll();
	}



	@SuppressWarnings("deprecation")
	public RhoUsers getdata(String id) {
		// TODO Auto-generated method stub
		return objrepo.getById(Integer.parseInt(id));
	}

	

}
