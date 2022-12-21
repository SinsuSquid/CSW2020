interface Motion{
	public void play();
	public void stop();
	public void pick(String obj);
	public String put();
}
interface Position{
	public String isspace();
	public void gospace(String a);
}
public class Exam3{
	public static void main(String[] args){
		Robot a = new Robot("ROBO1",3);
		a.play();
		a.gospace("Area 5");
		System.out.println(a + " is " + a.isspace());
		a.pick("Parts 1-1");
		a.pick("Parts 2-11");
		a.pick("Parts 3-99");
		a.pick("Parts 4-99");
		a.show();
		a.put();
		a.show();
		a.put();
		a.show();
		a.put();
		a.show();
		a.put();
		a.pick("Your mother");
		a.show();
		a.put();
		a.stop();
	}
}
class Robot implements Motion, Position{
	private String name;
	private String space;
	private String[] parts;
	private int occupied;

	public Robot(String name, int numPart){
		this.name = name;
		parts = new String[numPart];
		occupied = 0;
	}

	public void play(){ System.out.println(name + " is on."); }
	public String isspace(){ return this.space; }
	public void gospace(String a){ this.space = a; }
	public void pick(String obj){
		if(occupied < parts.length) parts[occupied++] = obj;
		else System.out.println(name + " no longer has empty slot(s).");
	}
	public void show(){
		int temp = occupied;
		System.out.print(name + " has ");
		for (int i = 0; i < temp; i++){
			System.out.print("[" + parts[i] + "]");
		}
		System.out.println();
	}
	public String put(){ 
		if (occupied == 0) return "";
		String temp = parts[occupied - 1];
		parts[--occupied] = null;
		return temp;
	}
	public void stop(){ System.out.println(name + " turn off."); }
	public String toString(){ return this.name; }
}
