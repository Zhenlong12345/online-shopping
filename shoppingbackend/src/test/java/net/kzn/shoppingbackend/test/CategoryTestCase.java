
package net.kzn.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
/*	@Test
	public void testAddCategory() {
		category=new Category();
		category.setName("Television");
		category.setDescription("Television description.");
		category.setImageURL("CAT_1.png");
		
		assertEquals("successfully",true,categoryDAO.add(category));
	}*/
	
	@Test
	public void testCRUDCategory() {
		category=new Category();
		category.setName("Laptop");
		category.setDescription("Laptop description.");
		category.setImageURL("CAT_1.png");
		assertEquals("successfully",true,categoryDAO.add(category));
		
		category=new Category();
		category.setName("Television");
		category.setDescription("Television description.");
		category.setImageURL("CAT_2.png");
		assertEquals("successfully",true,categoryDAO.add(category));
		
		//fetching and updating the category
		category=categoryDAO.get(2);
		category.setName("TV");
		assertEquals("successfully",true,categoryDAO.update(category));
	}
}
