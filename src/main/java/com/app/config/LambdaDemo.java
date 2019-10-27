package com.app.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Demo{
	
	void data(int i,String s);
	
	
	
}
public class LambdaDemo {
	
	
	
	
	
	
	
	
	
	public static void main(String []args ){
		
		Demo d=(i,s) -> System.out.println("hello"+i+s);
		d.data(19999,"aaaaaaaaaaaaa");
		
		List<String> l=Arrays.asList("a","b","c");
		List<String> ll=new ArrayList<>();
 l.stream().filter(c-> c!="c").map(a->a.toUpperCase()).forEach(s->ll.add(s));
			
		System.out.println(ll);
		
	}

}
