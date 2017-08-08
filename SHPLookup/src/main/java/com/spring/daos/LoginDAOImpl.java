package com.spring.daos;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.models.Users;

@Repository("loginDAO")
public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional(readOnly = true)
	public boolean checkLogin(String userName, String userPassword) {
		System.out.println("In Check login");
		boolean userFound = false;
		List<Users> empList = (List<Users>) hibernateTemplate.find("from Users where userName = ? and userPassword  = ?",userName, userPassword);
		for (Users u : empList)
			userFound = true;
		return userFound;
	}

	@PostConstruct
	public void init() {
		setHibernateTemplate(hibernateTemplate);
	}
}