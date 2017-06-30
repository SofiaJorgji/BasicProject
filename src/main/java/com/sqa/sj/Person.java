package com.sqa.sj;

/**
 * @author Jorgji, Sofia
 * @version 1.0
 */
public class Person {

	public String name;

	private int age;

	private String address;

	private String jobTitle;

	private char sex;

	private double weight;

	private boolean married;

	// have to create this because once I create my own constructor, it
	// automatically kills the default constructor
	public Person() {
		this.name = "John Doe";
		this.jobTitle = "Unemployed";
		this.age = 18;
		this.sex = 'M';
		this.address = "Homeless";
		this.weight = 100.0;
		this.married = false;
	}

	public Person(String name, String jobTitle) {
		this();
		this.name = name;
		this.jobTitle = jobTitle;
	}

	public Person(String name, String jobTitle, int age, char sex) {
		// super(); // Object's class constructor is called or all the other
		// classes that are extended
		this(name, jobTitle);
		this.name = name;
		this.jobTitle = jobTitle;
		this.age = age;
		this.sex = sex;
	}

	public Person(String name, String jobTitle, int age, char sex, String address, double weight, boolean married) {
		// super(); // Object's class constructor is called or all the other
		// classes that are extended
		this.name = name;
		this.jobTitle = jobTitle;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.weight = weight;
		this.married = married;
	}

	public void doWork(String task) {
		System.out.println(this.name + " does work and " + task + ".");
	}

	public String getAddress() {
		return this.address;
	}

	public int getAge() {
		return this.age;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public String getName() {
		return this.name;
	}

	public char getSex() {
		return this.sex;
	}

	public double getWeight() {
		return this.weight;
	}

	public boolean isMarried() {
		return this.married;
	}

	public void move(int miles) {
		System.out.println(this.name + " walks " + miles + " miles.");
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void sleep() {
		System.out.println(this.name + " goes to sleep.");
	}

	@Override
	public String toString() {
		return "Person [name=" + this.name + ", jobTitle=" + this.jobTitle + ", age=" + this.age + ", sex=" + this.sex
				+ ", address=" + this.address + ", weight=" + this.weight + ", married=" + this.married + "]";
	}
}
