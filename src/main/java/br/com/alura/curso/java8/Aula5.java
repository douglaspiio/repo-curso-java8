package br.com.alura.curso.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Aula5 {
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
		
		
		//utilização do Optional
		Optional<Cursos> optionalCurso = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.findAny();
		
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		//conversão de stream em lista
		List<Cursos> collect = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toList());
		
		
		//utilização map
		Map<String, Integer> map = cursos.stream()
		.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		System.out.println(map);
		
		//integracao stream, map e foreach
		cursos.stream()
		.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
		.forEach((nome, alunos) -> System.out.println(nome + "tem " + alunos + "alunos"));
		
		//calculo de média
		cursos.stream()
	    .mapToInt(c -> c.getAlunos())
	    .average();
	}
	
}