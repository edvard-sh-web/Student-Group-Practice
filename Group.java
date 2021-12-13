package lesson2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Group {
	private String name;
	private int groupSize;
	private Student[] groupStudents;
	private int studentCount;

	public Group(String name) {
		super();
		this.name = name;
		groupSize = 10;
		studentCount = 0;
		groupStudents = new Student[groupSize];

	}

	public Group() {
		super();
	}

	public void addStudent(Student st) throws GroupOverflowException {
		if (getStudentCount() > 9) {
			throw new GroupOverflowException();
		}
		for (int i = 0; i < groupSize; i++) {
			if (groupStudents[i] != null) {
			} else {
				groupStudents[i] = st;
				++studentCount;
				break;
			}
		}
	}

	public void deleteStudent(long id) {
		for (int i = 0; i < groupSize; i++) {
			if (groupStudents[i].getId() == id) {
				groupStudents[i] = null;
				--studentCount;
				break;
			}
		}
	}


	public Optional<Student> searchByLastName(String lastName) {
		Student result = null;
		for (Student student : groupStudents) {
			if (student != null) {
				if (student.getLastName() == lastName) {
					result = student;
					break;
				}
			}
		}
		return Optional.ofNullable(result);

	}

	public void sortByLastName(Group group) {
		Arrays.sort(group.getGroupStudents(), Comparator.nullsLast(new StudentLastNameComparator()));

	}
	
	public Student readStudent(){
		Student student = new Student();
		student.setName(StudentReader.nameReader());
		student.setLastName(StudentReader.lastNameReader());
		student.setGender(StudentReader.genderReader());
		student.setId(StudentReader.idReader());
		return student;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	public Student[] getGroupStudents() {
		return groupStudents;
	}

	public void setGroupStudents(Student[] groupStudents) {
		this.groupStudents = groupStudents;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", students=" + Arrays.toString(groupStudents) + ", studentCount=" + studentCount
				+ "]";
	}

}
