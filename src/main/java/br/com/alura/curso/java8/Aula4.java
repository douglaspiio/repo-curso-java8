package br.com.alura.curso.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Cursos{
	
	private String nome;
	private int alunos;
	
	public Cursos(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	public int getAlunos() {
		return alunos;
	}
}

public class Aula4 {
	public static void main(String[] args) {
		List<Cursos> cursos = new ArrayList<>();
		cursos.add(new Cursos("Python", 45));
		cursos.add(new Cursos("JavaScript", 150));
		cursos.add(new Cursos("Java 8", 113));
		cursos.add(new Cursos("C",55));
		
		cursos.sort(Comparator.comparing(Cursos::getAlunos));
		//palavras.forEach(p -> System.out.println(p.length()));
		
		
		//exploração stream
		cursos.stream()
		.filter(c ->c.getAlunos() >= 100)
		//.forEach(c -> System.out.println(c.getNome()));
		.map(c -> c.getAlunos())
		.forEach(total -> System.out.println(total));
		
		
		//mapToInt
		int sum = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.mapToInt(Cursos::getAlunos)
		.sum();
		System.out.println(sum);
		
		
		
	}
}

