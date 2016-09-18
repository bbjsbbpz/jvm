package bbjs.practice.design.factory;

public class WechatSenderFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new WechatSender();
	}

}
