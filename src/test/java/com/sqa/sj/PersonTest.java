package com.sqa.sj;

import org.testng.annotations.*;

public class PersonTest {

	@Test
	public void PersonTest() {
		Person[] people = new Person[4];
		// System.out.println("Person Details: " + person);
		// it automatically uses toString() and gives "Person Details:
		// com.sqa.sj.Person@6b09bb57"
		// person.setName("Sofia");
		// System.out.println("Person Details: " + person.getName());
		people[0] = new Person();
		people[1] = new Person("SJ", "Engineer");
		people[2] = new Person("Sofia", "Student", 21, 'F');
		people[3] = new Person("Das", "PI", 32, 'M', "SFO", 150, true);
		for (int i = 0; i < people.length; i++) {
			// System.out.println("Person Details: " + (i + 1) + ": " +
			// people[i]);
			// cast to int, otherwise it gives double
			people[i].move(((int) Math.ceil(Math.random() * 10)));
			people[i].doWork("Call school");
			people[i].sleep();
		}
	}
}
