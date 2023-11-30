package com.shoppingcart.doa;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
 
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Product;
 
 
public class ProductDoa {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet res;
	public ProductDoa(Connection con) {
		this.con = con;
	}
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		try {
			query ="select * from products";
			pst = this.con.prepareStatement(query);
			res = pst.executeQuery();
			while(res.next()) {
				Product row = new Product();
				row.setId(res.getInt("id"));
				row.setName(res.getString("name"));
				row.setCategory(res.getString("category"));
				row.setPrice(res.getDouble("price"));
				row.setImage(res.getString("image"));
				products.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return products;
	}
 
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
	    List<Cart> products = new ArrayList<>();
 
	    try {
	        if (cartList.size() > 0) {
	            for (Cart item : cartList) {
 
	                Product product = getProductById(item.getId());
	                if (product != null) {
	                    item.setName(product.getName());
	                    item.setCategory(product.getCategory());
	                    item.setPrice(product.getPrice() * item.getQuantity());
	                    item.setImage(product.getImage()); 
	                    products.add(item); 
	                }
	            }
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return products;
	}
 
	// Helper method to fetch Product details by ID
	private Product getProductById(int productId) {
	    Product product = null;
	    try {
	        query = "SELECT * FROM products WHERE id=?";
	        pst = this.con.prepareStatement(query);
	        pst.setInt(1, productId);
	        res = pst.executeQuery();
 
	        if (res.next()) {  
	            product = new Product();
	            product.setId(res.getInt("id"));
	            product.setName(res.getString("name"));
	            product.setCategory(res.getString("category"));
	            product.setPrice(res.getDouble("price"));
	            product.setImage(res.getString("image"));
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return product;
	}
 
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
		double sum = 0;
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query = "select price from products where id=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					res = pst.executeQuery();
					while(res.next()) {
						sum+=res.getDouble("price")*item.getQuantity();
					}
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
	public Product getSingleProduct(int id) {
		Product row = null;
		try {
			query = "select * from products where id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			res = pst.executeQuery();
			while(res.next()) {
				row= new Product();
				row.setId(res.getInt("id"));
				row.setName(res.getString("name"));
				row.setCategory(res.getString("category"));
				row.setPrice(res.getDouble("price"));
				row.setImage(res.getString("image"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
}