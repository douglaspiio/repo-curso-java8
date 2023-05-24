package br.com.alura.curso.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Aula3 {
	
	//method reference
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("casa do codigo");
		palavras.add("caelum");
		
		palavras.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		palavras.forEach(System.out::println);
		
		System.out.println(palavras);
		
	}

}
