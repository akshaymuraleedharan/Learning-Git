package com.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		List<Person> people = getPeople();
		/*sort*/
		people.stream()
		.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
		.collect(Collectors.toList());
		
		/*filter*/
		List<Person> females = people.stream()
		.filter(pObj -> pObj.getGender().equals(Gender.FEMALE))
		.collect(Collectors.toList());
		females.forEach(System.out::println);
		
		/*all match*/
		
		boolean allMatch = people.stream()
		.allMatch(person -> person.getAge() > 5);
		
/*any match -- true or flase if snyone matches*/
		
		boolean anyMatch = people.stream()
		.anyMatch(person -> person.getAge() > 5);
		
/*none match -- true or flase if no one matches*/
		
		boolean noneMatch = people.stream()
		.noneMatch(person -> person.getAge() > 5);
		
		//min or max
		people.stream()
		.max(Comparator.comparing(Person::getAge))
		.ifPresent(System.out::println);
		
		//group
		
		Map<Integer, List<Person>> groupedByGender = people.stream()
		.collect(Collectors.groupingBy(Person::getAge));
		
		// using mulltiple together
		
		Optional<String> oldestFemale = people.stream()
		.filter(person -> person.getGender().equals(Gender.FEMALE))
		.max(Comparator.comparing(Person::getAge))
		.map(Person::getName);
		
		oldestFemale.ifPresent(System.out::println);
	}
	
	
	
	

	private static List<Person> getPeople() {
		return List.of(
				new Person("Ani", 15, Gender.MALE),
				new Person("Ashu", 25, Gender.MALE),
				new Person("James", 25, Gender.MALE),
				new Person("Sushmu", 25, Gender.FEMALE));
	}
}
