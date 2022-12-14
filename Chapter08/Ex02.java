class BankAccount{
	private String name;
	private String ID;
	private int total;

	public BankAccount(String name, String ID, int total){
		this.name = name;
		this.ID = ID;
		this.total = total;
	}
	private int deposit(int num){total += num; return total;}
	private int withdraw(int num){total -= num; return total;}
	public int bankTransfer(BankAccount ac, int num){
		withdraw(num);
		ac.deposit(num);
		return total;
	}
	public void showInfo(){
		System.out.println("Name:"+name);
		System.out.println("Account:"+ID);
		System.out.println("Balance:"+total);
		System.out.println();
	}
}
public class Ex02{
	public static void main(String[] args){
		BankAccount a1 = new BankAccount("Hong", "111-1234", 10000);
		BankAccount a2 = new BankAccount("Kim", "111-5678", 2000);
		a1.bankTransfer(a2,3000);
		a1.showInfo();
		a2.showInfo();
	}
}
