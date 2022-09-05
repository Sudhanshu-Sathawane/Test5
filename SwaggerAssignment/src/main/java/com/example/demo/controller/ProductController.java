package com.example.demo.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
	private List<Product> products=createList();
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public List<Product> firstPage(){
		return products;
	}
	@DeleteMapping( "/products/{id}" )
	public Product delete(@PathVariable("id") String id) {
		System.out.println("delete.................."+id);
		Product deletedProd = null;
		System.out.println(products);
		for (Product prod : products) {
			
			if (prod.getId().equals(id)) {
				System.out.println("id ******************  "+ id);
				System.out.println(products.size());
				products.remove(prod);
				System.out.println(products.size());
				deletedProd = prod;
				break;
			}
		}
		return deletedProd;
	}
	@PostMapping(value="/products")
	public Product create(@RequestBody Product user) {
		
		products.add(user);
		System.out.println(products+"  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		return user;
	}
	private static List<Product> createList() {
		List<Product> tempProducts = new ArrayList<>();
		Product pro1 = new Product();
		pro1.setName("Apple");
		pro1.setId("1");
		pro1.setPrice(10000);

		Product pro2 = new Product();
		pro2.setName("Mango");
		pro2.setId("2");
		pro2.setPrice(200);
		tempProducts.add(pro1);
		tempProducts.add(pro2);
		return tempProducts;
	}
}
