package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.silab.dms.Utils.PasswordEncrypt;
import com.silab.dms.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
    @Override
    public List<User> retrieveAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    @Override
    public User save(User user) {
    	List<User> users = retrieveAllUsers();
    	for(User u : users){
    		if(u.getUsername().equals(user.getUsername())){
    			return null;
    		}
    	}
        persist(user);
        return user;
    }

    
    @Override
    public User retrieveUser(User user) {
        Query query = getSession().createQuery("from User where username = :username");
        query.setParameter("username", user.getUsername());
        List<User> users = query.list();
        if (users.size() != 0) {
        	for(User u : users){
        		if(passwordEncoder.matches(user.getPassword(), u.getPassword())){
        			return u;
        		}
        		return null;
        	}
        } else {
            return null;
        }
        return null;
    }

    @Override
    public List<User> retrieveAllUsersFromCompany(long vat) {
        Criteria criteria = getSession().createCriteria(User.class, "user")
                .createAlias("company", "company");

        criteria.add(Restrictions.eq("company.vat", vat));
        return criteria.list();
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        delete(user);
    }

}
