package com.helpezee.microservices.SpringBootHttpBasicSecurityUsingInMemory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {
	 
	public static List<Item> items;
	    static{
	        items = new ArrayList<>(Arrays.asList(new Item(1,"Spring Boot in Action","Books"),
	                new Item(2,"Java 8 in Action","Books"),
	                new Item(3,"Data Structures","Books")));
	    }

	    public List<Item> getAllItems(){
	        return items;
	    }

	    public void addItem(Item item){
	        items.add(item);
	    }
	    public void deleteItem(int id){
	        items.removeIf(i -> i.getId().equals(id));
	    }

}
