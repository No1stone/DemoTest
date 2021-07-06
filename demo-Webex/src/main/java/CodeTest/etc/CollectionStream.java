package CodeTest.etc;

import java.util.*;
import java.util.stream.*;

public class CollectionStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== Array ===");
		ArrayList<String> list = new ArrayList<>(Arrays.asList(
				"Apple", "Banana", "Melon", "Grape", "Strawberry"));
		System.out.println(list);
		
		System.out.println("");
		System.out.println("MAP");
		System.out.println("=== Map Joining ===");
		list.stream().map(s -> s.toUpperCase());
		list.stream().map(String::toUpperCase);
		
		System.out.println(list.stream().map(s -> s.toUpperCase())
				.collect(Collectors.joining("")));
		

		System.out.println("=== Map ToList Stream ===");
		System.out.println(list.stream().map(s->s.toUpperCase())
				.collect(Collectors.toList()));

		System.out.println("=== Map Tolist nString:: ===");
		System.out.println(list.stream().map(String::toUpperCase)
				.collect(Collectors.toList()));
		

		System.out.println("=== Map ForEach ===");
		list.stream().map(String::toUpperCase)
				.forEach(s -> System.out.println(s));
		
	

		System.out.println("");
		System.out.println("Filter");
		System.out.println(list.stream().filter(t -> t.length()>5));

		System.out.println("=== Filter Joining ===");
		System.out.println(list.stream().filter(t -> t.length()>5)
				.collect(Collectors.joining("")));

		System.out.println("=== Filter ToList ===");
		System.out.println(list.stream().filter(t -> t.length()>5)
				.collect(Collectors.toList()));
	

		System.out.println("");
		System.out.println("Sorted");
		System.out.println(list.stream().sorted());
		System.out.println("=== Sorted ToList ===");
		
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		
	}

}
