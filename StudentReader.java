package lesson2;

import java.util.Scanner;

public class StudentReader {

	public static String nameReader() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name:");
		String name = sc.nextLine();
		return name;

	}

	public static String lastNameReader() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the last name:");
		String lastName = sc.nextLine();
		return lastName;

	}

	public static Gender genderReader() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose gender: Male, Female or Other");
		String temp = sc.nextLine();
		Gender gender;
		if (temp.equals("Male")) {
			gender = Gender.Male;
		} else if (temp.equals("Female")) {
			gender = Gender.Female;

		} else {
			gender = Gender.Other;
		}
		return gender;

	}

	public static long idReader() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id:");
		long id = sc.nextLong();
		sc.close();
		return id;
	}

}
