package bbjs.practice.effective;

public class Varargs {
	
	public static int sum(int... args){
		int sum=0;
		for(int arg:args){
			sum+=arg;
		}
		System.out.println(sum);
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sum(1,2,3);
		sum(4,5,6,7);
	}

}
