import java.util.ArrayList;

public class WriterMain 
{
	public static void main(String[] args)
	{
		Controller c = new Controller();
		ArrayList<Student> student = new ArrayList<Student>();
		
		student = c.getStudents();
		for (int i=0; i<student.size(); i++)
		{
			System.out.println(student.get(i).getName());
			System.out.println(student.get(i).getID());
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Insert Student");
		System.out.println();
		
		c.insertStudent("testStudent", Integer.toString(1234567890));
		
		student = c.getStudents();
		for (int i=0; i<student.size(); i++)
		{
			System.out.println(student.get(i).getName());
			System.out.println(student.get(i).getID());
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("Delete Student");
		System.out.println();
		
		c.deleteStudent("testStudent");
		
		student = c.getStudents();
		for (int i=0; i<student.size(); i++)
		{
			System.out.println(student.get(i).getName());
			System.out.println(student.get(i).getID());
		}
		
		//WriterTestView testView = new WriterTestView();
		//testView.view();
		
		ArrayList<Student> s = c.getStudents("student1");
		for (int i=0;i<s.size(); i++)
		{
			System.out.println(student.get(i).getName());
			System.out.println(student.get(i).getID());
		}
		/*c.getAdmins();
		c.insertAdmin("TestAdmin", "1234567890");
		c.getAdmins();
		c.deleteAdmin("TestAdmin");
		c.getAdmins();*/
		
		/*c.getStudentInClubs();
		c.insertStudentInClub("1234567890", "Airplane Club");
		c.getStudentInClubs();
		c.deleteClub("Catapult Club");
		c.getClubs();
		c.getStudentInClubs();*/
		
		//c.getModules();
		//c.insertModule("How To Fight Batman", 7);
		//c.getModules();
		c.deleteModule("How To Fight Batman");
		//c.getModules();
	}
}
