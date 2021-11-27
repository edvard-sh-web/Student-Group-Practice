package lesson2;

import java.util.Optional;

public class Main {

	public static void main(String[] args) throws GroupOverflowException {

		Student st1 = new Student("John", "Doe", Gender.Male, 1);
		Student st2 = new Student("James", "Green", Gender.Male, 2);
		Student st3 = new Student("Savannah", "Daniels", Gender.Female, 3);
		Student st4 = new Student("Abby", "Crow", Gender.Other, 4);

		Group group = new Group("325B");

		try {
			group.addStudent(st1);
			group.addStudent(st2);
			group.addStudent(st3);

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}

		group.deleteStudent(1);
		group.addStudent(st4);

		Optional<Student> result = group.searchByLastName("Crow");

		if (result.isPresent()) {
			Student student = result.get();
			System.out.println(student);
		} else {
			System.out.println("Student was not found.");
		}

		group.addStudent(group.readStudent());
		
		group.sortByLastName(group);

		String s = st1.toCSVString();
		System.out.println(s);

		System.out.println(st1.fromCSVString(s));

		System.out.println(group.toString());

	}
}