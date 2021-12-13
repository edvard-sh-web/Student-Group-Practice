package lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {

	public static void saveGroupToCSV(Group gr) {

		File file = new File(gr.getName() + ".csv");

		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (PrintWriter pw = new PrintWriter(file)) {
			Student[] students = gr.getGroupStudents();

			for (Student st : students) {
				if (st != null) {
					pw.println(st.toCSVString());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}

		System.out.println("Congrats! Your group was saved in file \"" + file + "\".");

	}

	public static Group loadGroupFromCSV(File file) {

		Group group = new Group(file.getName());
		group.setName(file.getName().substring(0, file.getName().length() - 4));
		Student[] students = new Student[group.getGroupSize()];

		try (Scanner sc = new Scanner(file)) {
			for (int i = 0; sc.hasNextLine(); i++) {
				Student temp = new Student();
				students[i] = temp.fromCSVString(sc.nextLine());
				group.setStudentCount(i + 1);
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		group.setGroupStudents(students);

		return group;
	}

	public static File findFileByGroupName(String groupName, File workFolder) {
		File file = new File(".");
		groupName = groupName + ".csv";
		File[] files = workFolder.listFiles();

		for (File f : files) {
			if (f.getName().equals(groupName)) {
				file = f;
				break;
			}
		}

		return file;
	}

}
