package com.helpezee.microservices.SpringBootHttpBasicSecurityUsingInMemory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items =  itemService.getAllItems();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @PostMapping(value = "/addItem",consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<Item> addItem(@RequestBody Item item,UriComponentsBuilder builder){
        itemService.addItem(item);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addItem/{id}").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<Item>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id){
        itemService.deleteItem(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}