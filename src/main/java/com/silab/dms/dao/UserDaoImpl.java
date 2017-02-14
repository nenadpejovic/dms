package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public List<User> retrieveAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	@Override
	public void save(User user) {
		persist(user);
	}

	@Override
	public User retrieveUser(User user) {
		Query query = getSession().createQuery("from User where username = :username and password = :password");
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		List<User> users = query.list();
		if (users.size() != 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
