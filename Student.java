package lesson2;
import java.util.Arrays;

public class Student extends Person implements CSVConverter {
	private long id;

	
	public Student(String name, String lastName, Gender gender, long id) {
		super(name, lastName, gender);
		this.id = id;
	}

	public Student(String name, String lastName, Gender gender) {
		super(name, lastName, gender);
	}

	public Student() {
		super();
	}
	
	public String toCSVString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + ";");
		sb.append(getLastName() + ";");
		sb.append(getGender()+ ";");
		sb.append(getId());
		String s = sb.toString();
		return s;
	}
	
	public Student fromCSVString(String s) {
		
		Student student = new Student();
		String[] st = s.split("[;]");
		student.setName(st[0]);
		student.setLastName(st[1]);
		student.setGender(Gender.valueOf(st[2]));
		student.setId(Long.parseLong(st[3]));
		return student;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student " + super.toString() + ", id=" + id + "]";
	}

}
