import java.util.Random;

public class HW07{
	public static void main(String[] args){
		Gogo a = new Gogo(10);
		a.generate();
		a.display();
	}
}

class Gogo{
	private Point[] a;
	private Random rand;
	public Gogo(int num){
		a = new Point[num];
		rand = new Random(System.currentTimeMillis());
	}

	public void display(){
		double sum = 0;

		for (int i = 0; i < a.length; i++){
			System.out.printf("Index = %d:\n", i); 
			a[i].showInfo();
			sum += a[i].area();
			System.out.println();
		}

		System.out.println("Sum of Total Area: " + sum);
	}

	public void generate(){
		for (int i = 0; i < a.length; i++){
			switch(rand.nextInt(3)){
				case 0:
					a[i] = new Point(rand.nextInt(100), rand.nextInt(100));
					break;
				case 1:
					a[i] = new Circle(rand.nextInt(100),
							  rand.nextInt(100),
							  rand.nextInt(10) + 1);
					break;
				case 2:
					a[i] = new Rectangle(rand.nextInt(100),
							     rand.nextInt(100),
							     rand.nextInt(10) + 1,
							     rand.nextInt(10) + 1);
					break;
			}
		}
	}
}

class Point{
	private int x;
	private int y;
	public Point(int x, int y){ setXY(x,y); }
	public void setXY(int x, int y){ this.x=x; this.y=y; }
	public void showInfo(){ System.out.println("x="+x+", y="+y); }
	public double area(){ return 0.0; }
}

interface Quadrangular{
	void setLengths(int width, int height);
	int getWidth();
	int getHeight();
}

interface Round{
	void setR(int r);
	int getR();
}

class Rectangle extends Point implements Quadrangular{
	private int width, height;

	public Rectangle(int x, int y, int width, int height){
		super(x,y);
		this.setLengths(width, height);
	}

	public void setLengths(int width, int height){
		this.width = width;
		this.height = height;
	}
	public int getWidth(){ return this.width; }
	public int getHeight(){ return this.height; }

	@Override
	public double area(){ return (double)width * height; }

	@Override
	public void showInfo(){
		super.showInfo();
		System.out.println("width = " + getWidth() + ", height = " + getHeight() + ", area = " + area());
	}
}

class Circle extends Point implements Round{
	private int r;

	public Circle(int x, int y, int r){
		super(x,y);
		setR(r);
	}

	public void setR(int r){ this.r = r; }
	public int getR(){ return this.r; }

	@Override
	public double area(){ return Math.PI * r * r; }

	@Override
	public void showInfo(){
		super.showInfo();
		System.out.println("r = " + r + ", area = " + area());
	}
}

