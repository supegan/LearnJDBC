package tempLearn;

public class Son extends Father{
	
	@Override
	public void play(){
		System.out.println(456);
	}
	
	public static void main(String[] args) {
		Son s = new Son();
		s.play();
		
		Father f = new Son();
		f.playTanqiu();
	}
}
