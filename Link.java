public class Link
{
	//public Student name;
	public Link next;
	public Link prev;
	Student student;
	


	public Link getNext() {
		return next;
	}
	public void setNext(Link next) {
		this.next = next;
	}
	public Link getPrev() {
		return prev;
	}
	public void setPrev(Link prev) {
		this.prev = prev;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Link (String n)
	{
		  student = new Student(n);
	}
	/*public void displayLink()
	{
		System.out.print("{" +name +"}");
	}*/
	public String toString()
	{
		return student.getId()+ " "+student.getName();
	}
}