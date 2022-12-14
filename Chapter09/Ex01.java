public class Ex01{
	public static void main(String[] args){
		Box[][] bx = {
			{new Box(101,"Coffee"), new Box(102,"Computer")},
			{new Box(201,"Apple"), new Box(202,"Dress")},
			{new Box(301,"Play Station"), new Box(302,"Fairy-tale book")}
		};

		for (int i = 0; i < bx.length; i++){
			for (int j = 0; j < bx[i].length; j++){
				System.out.print(bx[i][j]);
			}
			System.out.println();
		}
	}
}
class Box{
	private int num;
	private String item;

	public Box(int num, String item){
		this.num = num;
		this.item = item;
	}

	public int getBoxNum(){return num;}
	public String toString(){return "["+num+":"+item+"]";}
}
