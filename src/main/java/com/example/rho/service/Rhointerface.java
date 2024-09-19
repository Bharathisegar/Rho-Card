package com.example.rho.service;

import java.util.List;

import com.example.rho.model.RhoUsers;

public interface Rhointerface {
	
	public RhoUsers usersave(String name,String email,String password);
	
	public List<RhoUsers> getallUsers();

}
