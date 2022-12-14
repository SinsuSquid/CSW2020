import java.util.Scanner;

interface Stack{
	int length(); // 현재 스택에 저장된 갯수
	int capacity(); // 스택의 전체 저장 가능한 갯수
	String pop(); // 스택의 top에 값은 제거하면서 반환
	boolean push(String val); // 스택에 값을 저장
}
class StringStack implements Stack{
	private int len;
	private int cap;
	private String[] stk;
	private Scanner sc;

	public StringStack(){
		stk = new String[setCap()];
		len = 0;
	}

	private int setCap(){
		sc = new Scanner(System.in);
		do{
			System.out.print("총 스택 저장 공간의 크기 입력 >> ");
			cap = sc.nextInt();
		}while(cap < 0);
		return cap;
	}
	public void run(){
		sc = new Scanner(System.in);
		String input;
		
		while(true){
			System.out.print("문자열 입력 >> ");
			input = sc.nextLine();

			if (input.equals("exit")) break;
			else if (!push(input)) System.out.println("스택이 가득 참");
		}
		System.out.print("스택에 저장된 모든 문자열 팝: ");
		popAll();
	}
	private void popAll(){
		int temp = len;
		for (int i = 0; i < temp; i++){
			System.out.print(pop()+" ");
		}
		System.out.println();
	}

	public int length(){return this.len;}
	public int capacity(){return this.cap;}
	public String pop(){return stk[(len--)-1];}
	public boolean push(String val){
		if (cap <= len) return false;
		else{
			stk[len++] = val;
			return true;
		}
	}
}
public class Ex05{
	public static void main(String[] args){
		StringStack stk = new StringStack();
		stk.run();
	}
}
