import java.util.Scanner;

class ChangeUnit{
	static final double MILE_PER_KILO = 0.62137;

	static double kilo2mile(double i){return i * MILE_PER_KILO;}
	static double mile2kilo(double i){return i / MILE_PER_KILO;}
}
public class Ex01{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int menu;
		do{
			System.out.println("1.km->mile 2.mile->km");
			System.out.print("Your choice:");
			menu = sc.nextInt();
		}while(menu != 1 && menu != 2);

		if(menu == 1){
			System.out.print("km:");
			double i = sc.nextDouble();
			System.out.println(ChangeUnit.kilo2mile(i) + " mile");
		}
		else{
			System.out.print("mile:");
			double i = sc.nextDouble();
			System.out.println(ChangeUnit.mile2kilo(i) + " km");
		}
	}
}
