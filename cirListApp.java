import java.util.Scanner;

public class cirListApp
{
	public static void main (String[]args)
	{
		Scanner scan = new Scanner(System.in);
		CircularList list = new CircularList();

		System.out.println("enter: \t1 to add a student\n \t2 to remove a student\n \t3 to search for a student\n \t4 to display all student info\n \t5 to quit");
		int option = scan.nextInt();
		scan.nextLine();
		while(option>=1&&option<=5)
		{
			switch(option)//switch statement
			{
				case 1://add link
					System.out.println("enter student name: ");
					String n = scan.nextLine();
					list.add(n);
					break;

				case 2://remove Link
					if(list.isEmpty())
						System.out.println("The list is empty");
					else
					{
						System.out.println("enter student id four digits ####: ");
						int k = scan.nextInt();
						list.remove(k);
					}
					break;

				case 3://search for Link
					if(list.isEmpty())
						System.out.println("The list is empty");
					else
					{
						System.out.println("enter student id four digits ####: ");
						int k = scan.nextInt();
						System.out.println(list.search(k));
					}
					break;
				case 4://display
					if(list.isEmpty())
						System.out.println("The list is empty");
					else
					{
						System.out.println(list.toString());
					}
					break;
				case 5:
					option = 6;
					System.out.println("Goodbye");
					break;
				}

				if (!(option == 6))
				{
					System.out.println("enter: \t1 to add a student\n \t2 to remove a student\n \t3 to search for a student\n \t4 to display all student info\n \t5 to quit");
					option = scan.nextInt();
					scan.nextLine();
			}
				else
				break;

		}

	}
}