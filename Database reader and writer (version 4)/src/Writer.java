// For SQL commands
import java.sql.*;
//import javax.sql.*;

// For storing controllers
import java.util.ArrayList;

// For generating sessionids
import java.security.SecureRandom;
import java.math.BigInteger;

public class Writer 
{
	private static String OS = System.getProperty("os.name").toLowerCase(); // gets the user's operating system, for file directory naming scheme.
	private volatile static Writer w;
	private ArrayList<Controller> controller;
	private ArrayList<String> key;

	// private constructor so that Writers can't be created with the new command.
	private Writer()
	{
		controller = new ArrayList<Controller>();
		key = new ArrayList<String>();
	}
	
	// public static method to return one and only one instance of the writer.
	public static Writer getInstance()
	{
		if (w == null) { w = new Writer(); }
		return w;
	}
	

	// Method for generating random string (a key for the controllers to use)
	public String getRandomString()
	{
		return new BigInteger(130, new SecureRandom()).toString(32);
	}
	
	
	// Methods for registering and de-registering controllers
	// register() adds the controller to the arraylist and gives it a key for verification.
	// deregister() removes the controller and key from their respective arraylists.
	public String register(Controller c)
	{
		String newKey = getRandomString();
		controller.add(c);
		key.add(newKey);
		return newKey;
	}
	
	public boolean deregister (Controller c)
	{
		for (int i=0; i<controller.size(); i++)
		{
			if (c.key.compareTo(key.get(i)) == 0)
			{
				controller.remove(i);
				key.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	
	
	/////////////////////////////////////////////
	///////////////STUDENT TABLE/////////////////
	/////////////////////////////////////////////
	// In the final version, the 10-digit id shouldn't be needed.
	public synchronized boolean insertStudent(String _asuriteID, String _tenDigitID)
	{
		int intID = 0;
		
		// check the length of the strings.
		if (_asuriteID.length() > 50) { return false; }
		if (_tenDigitID.length() > 10) { return false; }
		
		// parse the ID to an int (this is so that the 10-digit ID isn't given in scientific notation)
		try { intID = Integer.parseInt(_tenDigitID); }
		catch(Exception e) { return false; }
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO \"student.student\" (asuriteID, tenDigitID) VALUES ('" + _asuriteID + "', " + intID + ");";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public synchronized boolean deleteStudent(String _asuriteID)
	{
		// check the length of the strings.
		if (_asuriteID.length() > 50) { return false; }
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM \"student.student\" WHERE asuriteID='" + _asuriteID + "';";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	/////////////////////////////////////////////
	///////////////ADMIN TABLE//////////////////
	/////////////////////////////////////////////
	public synchronized boolean insertAdmin(String _asuriteID, String _tenDigitID)
	{
		int intID = 0;
		
		// check the length of the strings.
		if (_asuriteID.length() > 50) { return false; }
		if (_tenDigitID.length() > 10) { return false; }
		
		// parse the ID to an int (this is so that the 10-digit ID isn't given in scientific notation)
		try { intID = Integer.parseInt(_tenDigitID); }
		catch(Exception e) { return false; }
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO \"admin.admin\" (asuriteID, tenDigitID) VALUES ('" + _asuriteID + "', " + intID + ");";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public synchronized boolean deleteAdmin(String _asuriteID)
	{
		// check the length of the strings.
		if (_asuriteID.length() > 50) { return false; }
				
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM \"admin.admin\" WHERE asuriteID='" + _asuriteID + "';";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	/////////////////////////////////////////////
	///////////////STUDENTINCLUB TABLE///////////
	/////////////////////////////////////////////
	// Inserts an entry into the StudentInClubs table.
	public synchronized boolean insertStudentInClub(String _tenDigitID, String _clubName)
	{
		int intID = 0;
		
		// check the length of the strings.
		if (_tenDigitID.length() > 10) { return false; }
		
		// parse the ID to an int (this is so that the 10-digit ID isn't given in scientific notation)
		try { intID = Integer.parseInt(_tenDigitID); }
		catch(Exception e) { return false; }
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO \"studentInClub.studentInClub\" (tenDigitID, clubName) VALUES (" + intID + ", '" + _clubName + "');";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	// Deletes an entry from the StudentInClubs table.
	public synchronized boolean deleteStudentInClub(String _tenDigitID, String _clubName)
	{
		int intID = 0;
		
		// check the length of the strings.
		if (_tenDigitID.length() > 10) { return false; }
		
		// parse the ID to an int (this is so that the 10-digit ID isn't given in scientific notation)
		try { intID = Integer.parseInt(_tenDigitID); }
		catch(Exception e) { return false; }
				
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM \"studentInClub.studentInClub\" WHERE tenDigitID=" + intID + " AND clubName='" + _clubName + "';";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	/////////////////////////////////////////////
	///////////////CLUB TABLE////////////////////
	/////////////////////////////////////////////
	// Inserts an entry into the club table
	public synchronized boolean insertClub(String _clubName)
	{
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO \"club.club\" (clubName) VALUES ('" + _clubName + "');";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	// Deletes an entry from the club table
	public synchronized boolean deleteClub(String _clubName)
	{
		// check the length of the strings.
		if (_clubName.length() > 50) { return false; }
				
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM \"club.club\" WHERE clubName='" + _clubName + "';";
			stmt.executeUpdate(sql);
			
			// Also need to update the studentInClub database as well.
			sql = "DELETE FROM \"studentInClub.studentInClub\" WHERE clubName='" + _clubName + "';";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	/////////////////////////////////////////////
	///////////////MODULE TABLE//////////////////
	/////////////////////////////////////////////
	// Inserts an entry into the module table
	public synchronized boolean insertModule(String _moduleName, int _timeValidInMonths)
	{
		
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO \"module.module\" (moduleName, timeValidInMonths) VALUES ('" + _moduleName + "', " + _timeValidInMonths + ");";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	// Deletes an entry from the module table.
	public synchronized boolean deleteModule(String _moduleName)
	{
		// check the length of the strings.
		if (_moduleName.length() > 50) { return false; }
				
		try
		{
			Class.forName("com.nilostep.xlsql.jdbc.xlDriver");
			Connection conn;
			if (OS.indexOf("win") >= 0) { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "\\Test"); } // Directory that contains databases.
			else { conn = DriverManager.getConnection("jdbc:nilostep:excel:" + System.getProperty("user.dir") + "/Test"); }
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM \"module.module\" WHERE moduleName='" + _moduleName + "';";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			return true;
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
}
