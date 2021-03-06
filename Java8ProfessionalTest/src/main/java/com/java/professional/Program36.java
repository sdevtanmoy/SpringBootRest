package com.java.professional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program36 {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>(Arrays.asList(
				new Product(1, 10),
				new Product(2, 30),
				new Product(3, 20)
				));

		Product p = products.stream().reduce(new Product(4, 0), (p1, p2)->{
			p1.price+=p2.price;
			return new Product(p1.id, p1.price);
		});
		//System.out.println(p);
		//System.out.println("-----------------------------------");
		//System.out.println(products.size());
		products.add(p);
		
		products.stream().parallel()
			.reduce((p1, p2) -> p1.price > p2.price ? p1 : p2)
			.ifPresent(System.out::println);
	}
	
}

class Product{
	int id, price;
	
	public Product(int id, int price){
		this.id =id; this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + "]";
	}
	
	
}