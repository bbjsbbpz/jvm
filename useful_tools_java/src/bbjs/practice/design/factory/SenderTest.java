package bbjs.practice.design.factory;

public class SenderTest {
	public static void main(String[] args) {
		Sender sender = SenderFactory.getMailSender();
		sender.send();
		sender = SenderFactory.getSmsSender();
		sender.send();
		
		Provider provider = new SmsSenderFactory();
		sender = provider.produce();
		sender.send();
		
		provider = new MailSenderFactory();
		sender = provider.produce();
		sender.send();
		
		provider = new WechatSenderFactory();
		sender = provider.produce();
		sender.send();
	}
}
