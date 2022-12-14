interface Person{
	void setName(String name);
	String getID();
	void setID(String id);
}
class SchoolPerson implements Person{
	String name;
	String id;

	public SchoolPerson(String name, String id){
		setName(name);
		setID(id);
	}

	public void setName(String name){this.name = name;}
	public String getID(){return this.id;}
	public void setID(String id){this.id = id;}
	
	public String toString(){return this.name;}
}
class Student extends SchoolPerson{
	double avg;
	int rank;
	public Student(String name, String id, double avg, int rank){
		super(name, id);
		this.avg = avg;
		this.rank = rank;
	}
	public double getAvg(){return this.avg;}
	public int getRank(){return this.rank;}
}
class Teacher extends SchoolPerson{
	String className;
	public Teacher(String name, String id, String className){
		super(name, id);
		this.className = className;
	}
	public String getClassName(){return this.className;}
}
public class Ex04{
	public static void main(String[] args){
		Student a = new Student("Hong", "A209911", 85.6, 4);
		Teacher b = new Teacher("Kim", "B5542", "3-2");

		System.out.print("Student Name: "+a+"\tID: "+a.getID());
		System.out.println("\tAvg: "+a.getAvg()+"\tRanking: "+a.getRank());

		System.out.print("Teacher Name: "+b+"\tID: "+b.getID());
		System.out.println("\tClassName: "+b.getClassName());
	}
}
