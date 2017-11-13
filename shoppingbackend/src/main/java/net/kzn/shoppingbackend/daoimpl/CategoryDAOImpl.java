package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> list(){
		String selectActiveCategory="From Category where active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active",true);
		return query.getResultList();
	}

	private static List<Category> categories=new ArrayList<Category>();
	
	static {
		//First category 
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Television description.");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		//Second category
        category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Mobile description.");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
        category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Laptop description.");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	
	/*
	 * Getting single category based on id
	 * */
	@Override
	public Category get(int id) {
  
        return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}
	@Override

	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category); 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * Updating a single category
	 * */
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category); 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
