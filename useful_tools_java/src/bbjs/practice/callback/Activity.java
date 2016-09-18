package bbjs.practice.callback;

public class Activity {
	
	public static void main(String[] args) {
		Button buttonA = new Button();
		buttonA.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("click buttonA");
			}
		});		
		buttonA.click();
		
		Button buttonB = new Button();
		buttonB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("click buttonB");
			}
		});
		
		buttonB.click();
		
	}
}




