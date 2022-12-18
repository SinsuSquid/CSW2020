import java.util.Scanner;

public class HW05{
	public static void main(String[] args){
		new AccountMenu("Hong","111-1234", 10000, "Kim", "111-5678", 2000);
	}
}

class AccountMenu{
	private BankAccount ac1, ac2;
	private Scanner sc;

	public AccountMenu(String n1, String a1, int b1, String n2, String a2, int b2){
		this.ac1 = new BankAccount(n1, a1, b1);
		this.ac2 = new BankAccount(n2, a2, b2);
		run();
	}

	public void run(){
		sc = new Scanner(System.in);
		int ans, num;

		while(true){
			System.out.println();
			showInfo();
			ans = showMenu();
			if (ans < 0 || ans > 6) continue;
			else if (ans == 0) break;
			else{
				System.out.print("How much do you want [menu" + ans + "]: ");
				num = sc.nextInt();
				switch(ans){
					case 1:
						ac1.deposit(num); break;
					case 2:
						ac2.deposit(num); break;
					case 3:
						ac1.withdraw(num); break;
					case 4:
						ac2.withdraw(num); break;
					case 5:
						ac1.bankTransfer(ac2, num); break;
					case 6:
						ac2.bankTransfer(ac1, num); break;
				}
			}
		}
	}

	public void showInfo(){
		System.out.print("Account1:\n\t");
		ac1.showInfo();
		System.out.print("Account2:\n\t");
		ac2.showInfo();
	}
	public int showMenu(){
		System.out.print("1. Deposit A1 2. Deposit A2 3. Withdraw A1 4. Withdraw A2 5. Transfer A1->A2 6. Transfer A2->A1 0. exit : ");
		return sc.nextInt();
	}
}

class BankAccount{
	private String name;
	private String account;
	private int balance;

	public BankAccount(String name, String account, int balance){
		this.name = name;
		this.account = account;
		this.balance = balance;
	}
	public int bankTransfer(BankAccount a, int num){
		if (num > balance) num = balance;
		
		this.withdraw(num);
		a.deposit(num);

		return balance;
	}
	public void showInfo(){
		System.out.print("Name : " + name);
		System.out.print(", Account : " + account);
		System.out.println(", Balance : " + balance);
	}
	public int deposit(int num){ balance += num; return balance; }
	public int withdraw(int num){ 
		if (num > balance) num = balance;
		balance -= num;
		return balance;
	}
}
