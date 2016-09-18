package bbjs.practice.callback;


public class Button {
	private OnClickListener onClickListener;
	
	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}
	
	public void click(){
		System.out.println("before on click.");
		onClickListener.onClick();
		System.out.println("after on click.");
	}
}
