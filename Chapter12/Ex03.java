class Animal{
	public void eat(){System.out.println("먹습니다.");}
}
class Wolf extends Animal{
	@Override
	public void eat(){System.out.println("늑대는 고기를 먹습니다.");}
}
class Rabbit extends Animal{
	@Override
	public void eat(){System.out.print("토끼는 당근을 "); super.eat();}
}
class Cow extends Animal{
	@Override
	public void eat(){System.out.print("소는 풀을 "); super.eat();}
}

public class Ex03{
	public static void main(String[] args){
		Animal[] a = {new Wolf(), new Rabbit(), new Cow()};

		for (Animal ani : a)
			ani.eat();
	}
}
