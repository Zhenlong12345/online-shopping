package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDao;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDao {

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
	@Override
	public List<Category> list() {
		return categories;
	}
	@Override
	public Category get(int id) {
        for(Category category:categories) {
        	if(category.getId()==id) {
        		return category;
        	}
        }
        return null;
	}

}
