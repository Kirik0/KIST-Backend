import java.sql.*;
//import javax.sql.*;
import java.util.ArrayList;

public class Controller 
{
	private static String OS = System.getProperty("os.name").toLowerCase(); // gets the user's operating system, for file directory naming scheme.
	String key;
	Writer w;
	
	public Controller()
	{
		w = Writer.getInstance();
		key = w.register(this);
	}
	
	public ArrayList<Student> getStudents()
	{
		ArrayList<Student> student = new ArrayList<Student>();
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM \"student.student\""; // [xlsfilename].[sheetname]
			ResultSet rs = stmt.executeQuery(sql);
				
			while (rs.next())
			{
				student.add(new Student(rs.getString("asuriteID"), rs.getInt("tenDigitID")));
			}
				
			rs.close();
			stmt.close();
			conn.close();
			return student;
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		return null;
	}
	
	
	public ArrayList<Student> getStudents(String name)
	{
		ArrayList<Student> student = new ArrayList<Student>();
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM \"student.student\" WHERE asuriteID = '" + name + "'"; // [xlsfilename].[sheetname]
			ResultSet rs = stmt.executeQuery(sql);
				
			while (rs.next())
			{
				student.add(new Student(rs.getString("asuriteID"), rs.getInt("tenDigitID")));
			}
				
			rs.close();
			stmt.close();
			conn.close();
			return student;
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		return null;
	}
	
	public void insertStudent(String userName, String id)
	{
		w.insertStudent(userName, id);
		return;
	}
	
	public void deleteStudent(String userName)
	{
		w.deleteStudent(userName);
		return;
	}
	
	
	
	public void getAdmins()
	{
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM \"admin.admin\""; // [xlsfilename].[sheetname]
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				System.out.println(rs.getString("asuriteID"));
				System.out.println(rs.getInt("tenDigitID"));
				System.out.println();
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return;
	}
	
	public void insertAdmin(String userName, String id)
	{
		w.insertAdmin(userName, id);
		return;
	}
	
	public void deleteAdmin(String userName)
	{
		w.deleteAdmin(userName);
		return;
	}
	
	
	
	public void getStudentInClubs()
	{
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM \"studentInClub.studentInClub\""; // [xlsfilename].[sheetname]
			ResultSet rs = stmt.executeQuery(sql);
				
			while (rs.next())
			{
				System.out.println(rs.getInt("tenDigitID"));
				System.out.println(rs.getString("clubName"));
				System.out.println();
			}
				
			rs.close();
			stmt.close();
			conn.close();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		return;
	}
	
	public void insertStudentInClub(String id, String clubName)
	{
		w.insertStudentInClub(id, clubName);
		return;
	}
	
	public void deleteStudentInClub(String id, String clubName)
	{
		w.deleteStudentInClub(id, clubName);
		return;
	}
	
	
	
	public void getClubs()
	{
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM \"club.club\""; // [xlsfilename].[sheetname]
			ResultSet rs = stmt.executeQuery(sql);
				
			while (rs.next())
			{
				System.out.println(rs.getString("clubName"));
				System.out.println();
			}
				
			rs.close();
			stmt.close();
			conn.close();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		return;
	}
	
	public void insertClub(String clubName)
	{
		w.insertClub(clubName);
		return;
	}
	
	public void deleteClub(String clubName)
	{
		w.deleteClub(clubName);
		return;
	}
	
	
	
	public void getModules()
	{
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM \"module.module\""; // [xlsfilename].[sheetname]
			ResultSet rs = stmt.executeQuery(sql);
				
			while (rs.next())
			{
				System.out.println(rs.getString("moduleName"));
				System.out.println(rs.getInt("timeValidInMonths"));
				System.out.println();
			}
				
			rs.close();
			stmt.close();
			conn.close();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		return;
	}
	
	public void insertModule(String moduleName, int timeValidInMonths)
	{
		w.insertModule(moduleName, timeValidInMonths);
		return;
	}
	
	public void deleteModule(String moduleName)
	{
		w.deleteModule(moduleName);
		return;
	}
}
