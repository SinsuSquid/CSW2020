import java.util.Scanner;

class BankAccount{
	private String name;
	private String ID;
	private int total;

	public BankAccount(String name, String ID, int total){
		this.name = name;
		this.ID = ID;
		this.total = total;
	}
	public int deposit(int num){total += num; return total;}
	public int withdraw(int num){
		if (total >= num){
			total -= num; return total;
		}
		else{
			total = 0; return total;
		}
	}
	public int bankTransfer(BankAccount ac, int num){
		if (total >= num){
			ac.deposit(num);
			withdraw(num);
			return total;
		}
		else{
			ac.deposit(total);
			withdraw(total);
			return total;
		}
	}
	public void showInfo(){
		System.out.print(" Name:"+name);
		System.out.print(" Account:"+ID);
		System.out.print(" Balance:"+total);
		System.out.println();
	}
}
class AccountMenu{
	private BankAccount a1;
	private BankAccount a2;
	Scanner sc;

	public AccountMenu(String name1, String ID1, int num1, String name2, String ID2, int num2){
		a1 = new BankAccount(name1, ID1, num1);
		a2 = new BankAccount(name2, ID2, num2);
		run();
	}
	private void run(){
		sc = new Scanner(System.in);
		int menu;
		int howMuch;
		do{
			printInfo();
			menu = showMenu();
			if (menu == 0) return;

			howMuch = getHowMuch(menu);

			switch(menu){
				case 1:
					a1.deposit(howMuch); break;
				case 2:
					a2.deposit(howMuch); break;
				case 3: 
					a1.withdraw(howMuch); break;
				case 4:
					a2.withdraw(howMuch); break;
				case 5:
					a1.bankTransfer(a2, howMuch); break;
				case 6:
					a2.bankTransfer(a1, howMuch);
			}
			System.out.println();
		}while(true);
	}
	private int getHowMuch(int menu){
		System.out.print("How much do you want [menu" + menu +"]:");
		return sc.nextInt();
	}
	private void printInfo(){
		a1.showInfo();
		a2.showInfo();
	}
	private int showMenu(){
		int menu;
		do{
			System.out.print("1.Deposit A1 2.Deposit A2 3.Withdraw A1 4.WithdrawA2 5.Transfer A1->A2 6.Transfer A2->A1 0.exit:");
			menu = sc.nextInt();
		}while(menu < 0 || menu > 6);
		return menu;
	}
}
public class Ex03{
	public static void main(String[] args){
		AccountMenu am = new AccountMenu("Hong","111-1234",10000,"Kim","111-5678",2000);
	}
}
