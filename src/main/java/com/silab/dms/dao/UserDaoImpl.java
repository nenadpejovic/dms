package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

	@Override
	public List<User> retrieveAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>)criteria.list();
	}

	@Override
	public void save(User user) {
		persist(user);
	}

}
