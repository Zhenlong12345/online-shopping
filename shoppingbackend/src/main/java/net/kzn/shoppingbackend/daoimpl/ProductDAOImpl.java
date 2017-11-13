package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
/*
 * LIST
 * */
	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class)
				.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Product product) {
	    try {
	    	product.setActive(false);
	    	return this.update(product);
	    }
	    catch (Exception e) {
		    e.printStackTrace();
		}
	    return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts="From Product WHERE active=:active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class)
				.setParameter("active",true).getResultList();	
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory="From Product WHERE active=:active "
				+ "AND categoryId=:categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active",true)
				.setParameter("categoryId", categoryId)
				.getResultList();	
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession().createQuery("FROM PRODUCT "
				+ "WHERE active=:active ORDER BY id",Product.class)
				.setParameter("active",true)
                .setFirstResult(0)
                .setMaxResults(count)
				.getResultList();	
	}

}
