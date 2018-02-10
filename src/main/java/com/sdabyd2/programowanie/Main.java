package com.sdabyd2.programowanie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdabyd2.programowanie.model.Item;
import com.sdabyd2.programowanie.model.Order;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        Item item = new Item("mleko","2", "Tesco");
        Item item2 = new Item("chleb","3", "Tesco");
        Item item3 = new Item("kakao","10", "Tesco");

        List<Item> itemList = Arrays.asList(item,item2,item3); //zamiast itemlist.add mozna uzyc Arrays.asList()

        Order order = new Order(itemList,1);

        //trzeba wykorzystac klase objectmapper zeby zmapowac obiekt do json

        ObjectMapper mapper = new ObjectMapper();
        File fileName = new File("order.json");
        fileName.createNewFile();
        mapper.writeValue(fileName,order);

        Order readorders =
                mapper.readValue(new File("order.json"),
                        Order.class);

        for(Item items: readorders.getItemList()){
            System.out.print(items.getName() + "\t");
            System.out.print(items.getPrice()+ "\t");
            System.out.print(items.getShop()+"\n");
        }

    }
}
