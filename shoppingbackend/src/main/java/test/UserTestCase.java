package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CartLineDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.CartLine;
import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartLineDAO cartLineDAO=null;
	private static ProductDAO productDAO=null;
	private static UserDAO userDAO;
	
	private Product product=null;
	private User user=null;
	private Cart cart=null;
	private CartLine cartLine=null;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		userDAO=(UserDAO)context.getBean("userDAO");
		cartLineDAO=(CartLineDAO)context.getBean("cartLineDAO");
	}
	
	@Test
	public void testAddNewCartLine() {
		//1.get the user
		user=userDAO.getByEmail("zouzhenlongapp@163.com");
		
		//2.fetch the cart
		cart=user.getCart();
		
		//3.get the product
		product=productDAO.get(1);
		
		//4.create a new cartline
		cartLine=new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount()+1);
		
		cartLine.setTotal(cartLine.getProductCount()*product.getUnitPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("fail to add to cartline",true,cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		assertEquals("fail to add to cart",true,cartLineDAO.updateCart(cart));
	}
}
/*	@Test
	public void testAdd() {
		user=new User();
		user.setFirstName("Hri");
		user.setLastName("Roshan");
		user.setEmail("zouzhenlongapp@gmail.com");
		user.setContactNumber("1234567");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add user!",true,userDAO.addUser(user));
		
		address=new Address();
		address.setAddressLineOne("Jurong east");
		address.setAddressLineTwo("Marina Bay");
		address.setCity("Singapore");
		address.setState("Finish");
		address.setCountry("Singapore");
		address.setPostalCode("600001");
		address.setBilling(true);
		//link the user with the address using user id
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("Failed to add address!",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			cart=new Cart();
			cart.setUser(user);
			
			//add the cart
			assertEquals("Failed to add cart!",true,userDAO.addCart(cart));

			//add a shipping address for this user
			address=new Address();
			address.setAddressLineOne("Jurong east");
			address.setAddressLineTwo("Marina Bay");
			address.setCity("Singapore");
			address.setState("Finish");
			address.setPostalCode("600001");
			//set shipping to true
			address.setShipping(true);
			
			//link it with the user
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
		}
		
	}*/
	
/*	@Test
	public void testAdd() {
		user=new User();
		user.setFirstName("Hri");
		user.setLastName("Roshan");
		user.setEmail("zouzhenlongapp@gmail.com");
		user.setContactNumber("1234567");
		user.setRole("USER");
		user.setPassword("123456");

		if(user.getRole().equals("USER")) {
			//create a cart for this user
			cart=new Cart();
			
			cart.setUser(user);
			
			//attach cart with the user
			user.setCart(cart);
		}
		//add the user
		assertEquals("Failed to add user!",true,userDAO.addUser(user));
		
	}*/
	
/*	@Test
	public void testUpdateCart() {
		//fetch the user by its email
			user=userDAO.getByEmail("zouzhenlongapp@gmail.com");
		
		//get the cart of the user
		cart=user.getCart();
		
		cart.setGrandTotal(5555);
		
		cart.setCartLines(2);
		
		assertEquals("Failed to update the cart!",true,userDAO.updateCart(cart));
	}*/
	/*
	@Test
	public void testAddAddress() {
		
		//we need to add an user
		user=new User();
		user.setFirstName("Hri");
		user.setLastName("Roshan");
		user.setEmail("zouzhenlongapp@gmail.com");
		user.setContactNumber("1234567");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add user!",true,userDAO.addUser(user));
		
		//link the user with the address using user id
		address=new Address();
		address.setAddressLineOne("Jurong east");
		address.setAddressLineTwo("Marina Bay");
		address.setCity("Singapore");
		address.setState("Finish");
		address.setCountry("Singapore");
		address.setPostalCode("600001");
		address.setBilling(true);
		
		//attach the user to the address
		address.setUser(user);
		assertEquals("Failed to add address",true,userDAO.addAddress(address));
		
		//we are alse going to add the shipping address
		address=new Address();
		address.setAddressLineOne("Jurong east");
		address.setAddressLineTwo("Marina Bay");
		address.setCity("Singapore");
		address.setState("Finish");
		address.setPostalCode("600001");
		//set shipping to true
		address.setShipping(true);
		
		//attach the user to the address
		address.setUser(user);
		assertEquals("Failed to shipping address",true,userDAO.addAddress(address));
	}
}
*/
	
/*	@Test
	public void testAddAddress() {
		user=userDAO.getByEmail("zouzhenlongapp@gmail.com");
		
		//we are alse going to add the shipping address
		address=new Address();
		address.setAddressLineOne("Bonua Vista");
		address.setAddressLineTwo("Marina Bay");
		address.setCity("Singapore West");
		address.setState("Done");
		address.setPostalCode("600001");
		//set shipping to true
		address.setShipping(true);
		
		//attach the user to the address
		address.setUser(user);
		assertEquals("Failed to shipping address",true,userDAO.addAddress(address));
	}*/
	
	/*@Test*/
	/*public void testGetAddresses() {
		user=userDAO.getByEmail("zouzhenlongapp@gmail.com");
		
		assertEquals("Failed to fetch the list of address and size does not match",2,
				userDAO.listShippingAddress(user).size());
		
		assertEquals("Failed to fetch the billing address and size does not match","Singapore",
				userDAO.getBillingAddress(user).getCity());
	}
}*/