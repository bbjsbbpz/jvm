package bbjs.practice.design.factory;

public class SenderFactory {

	public static Sender getMailSender(){
		return new MailSender();
	}
	
	public static Sender getSmsSender(){
		return new SmsSender();
	}

}
