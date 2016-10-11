import java.util.Random;

public class Student
{
	Random rand = new Random();

	private String _name = "";
	static private String _id;
	private String real_id;

	public Student(String n)
	{
		_name = n;

		if(_id==null)
		{	
			_id=Integer.toString(1000);
			real_id=_id;
		}
		else
		{	
			_id=Integer.toString((Integer.parseInt(_id)+1));
			real_id=_id;
		}
		
		//int i = rand.nextInt(9000)+1000;
		//_id = Integer.toString(i);
	}

	public String getName()
	{
		return _name;
	}

	public String getId()
	{
		return real_id;
	}

	public void setName(String n)
	{
		_name = n;
	}

	public void setId(String i)
	{
		real_id = i;
	}

	public String toString()
	{
		return "name: " + _name + "\nid#: " + _id + "\n";
	}
}
