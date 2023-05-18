package br.com.alura.curso.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Aula1 {
	
	//default methods
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("casa do codigo");
		palavras.add("caelum");
		
		ComparadorPorTamanho comparador = new ComparadorPorTamanho();

		palavras.sort(comparador);
		System.out.println(palavras);
		
	}
	

}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        return 0;
    }
}