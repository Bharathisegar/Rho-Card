package com.example.rho.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rho.model.Applypage;
import com.example.rho.repository.applyrepo;

@Service
public class applyuserservice implements applyserrepo {

	@Autowired
	applyrepo objrepo;

	public void save(Applypage a) {
		// TODO Auto-generated method stub
		objrepo.save(a);
	}

	public List<Applypage> getallUser() {
		// TODO Auto-generated method stub
		return objrepo.findAll();
	}

	@SuppressWarnings("deprecation")
	public Applypage getdata(String id) {
		// TODO Auto-generated method stub
		return objrepo.getById(Integer.parseInt(id));
	}
	
	
	
	

}
