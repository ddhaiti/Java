public class CircularList
{
	private Link cursor = null;
	private Link prev = null;
	private Link next = null;
	private int size = 0;
	private int numElm = 0;


	public CircularList()
	{
	}

	public boolean isEmpty()
	{
		return (cursor == null);
	}

	public void add(String s)
	{
		Link newNode = new Link(s);


		if(numElm==0)
		{
			cursor = newNode;
			cursor.next = cursor;
			cursor.prev = cursor;
			numElm++;
		}
		else if (numElm==1)
		{
			newNode.prev = cursor;
			newNode.next = cursor.next;
			cursor.prev = newNode;
			cursor.next = newNode;
			numElm++;
		}
		else
		{
			newNode.prev = cursor;
			newNode.next = cursor.next;
			cursor.next = newNode;
			newNode.next.prev = newNode;
			numElm++;
		}
	}

	public Link remove (int key)
	{
		String id = Integer.toString(key);

		int run = 0;
		while (!(cursor.getStudent().getId().equals(id)))
		{
			if (run == numElm)
				return null;
			else
				cursor = cursor.next;
			run++;
		}
		numElm--;
		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		cursor = cursor.next;


		return cursor;
	}


	public String search (int key)
	{
			String id = Integer.toString(key);

			int run = 0;
			while (!(cursor.getStudent().getId().equals(id)))
			{
				if (run == numElm)
					return "not found";
				else
					cursor = cursor.next;
				run++;
			}
		String x = cursor.toString();
		return x;
	}

	public String toString()
	{
		String s = "";
		for (int i =0;i<numElm;i++)
		{
			s += "\n" + cursor.toString();
			cursor = cursor.next;
		}
		return s;
	}
}
