import java.util.Scanner;

public class HW06{
	public static void main(String[] args){
		Dictionary d = new Dictionary(5);
		d.start();
	}
}

class Dictionary{
	private EngWord[] dic;
	private int filled;

	public Dictionary(int num){ 
		dic = new EngWord[num];
		filled = 0;
	}

	public void start(){
		Scanner sc = new Scanner(System.in);

		while(true){
			System.out.printf("Eng2Kor Dictionary (%d/%d words)\n", filled, dic.length);
			System.out.print("[Add Word:New Word / Find Word:Contained Word / Exit: Type \"exit\"] ");
			System.out.print("Input Word: ");
			String input = sc.nextLine();

			if("exit".equals(input)) break;
			else if (checkWord(input)) System.out.println(findWord(input));
			else if (checkFull()) System.out.println("The dictionary is full.");
			else{
				System.out.printf("Type meaning of word \"%s\" : ", input);
				appendWord(sc.nextLine(), input);
			}

			System.out.println();
		}
	}

	private boolean checkFull(){ return dic.length == filled; }
	private boolean checkWord(String word){
		for (int i = 0; i < filled; i++){
			if (dic[i].checkWord(word)) return true;
		}
		return false;
	}
	private void appendWord(String kor, String eng){ dic[filled++] = new EngWord(kor, eng); }
	private String findWord(String word){
		for (int i = 0; i < filled; i++){
			if (dic[i].checkWord(word)){
				return dic[i].toString();
			}
		}
		return "";
	}
}

class EngWord{
	private String kor;
	private String eng;

	public EngWord(String kor, String eng){
		this.kor = kor;
		this.eng = eng;
	}

	public boolean checkWord(String word){ return eng.equals(word); }
	public String toString(){ return this.kor; }
}
