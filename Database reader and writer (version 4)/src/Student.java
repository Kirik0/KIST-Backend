public class Student 
{
	private String studentName = "";
	private int asuriteID = 0;
	
	public Student(String _studentName, int _asuriteID)
	{
		studentName = _studentName;
		asuriteID = _asuriteID;
	}
	
	public String getName() { return studentName; }
	public int getID() { return asuriteID; }
}
