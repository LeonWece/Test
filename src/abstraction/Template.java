package abstraction;

/**
 * 模版模式
 * 
 * @author Lwj
 * @since 2016年8月28日
 */
public class Template {
	public static void main(String[] args) {
		CarModel car1 = new BWM();
		CarModel car2 = new Benz();
		car1.drive();
		car2.drive();
	}
}

abstract class CarModel {
	public abstract void start();

	public abstract void alarm();

	public abstract void stop();

	/**
	 * 模版方法
	 */
	public void drive() {
		start();
		if (isAlarm()) {
			alarm();
		}
		stop();

	}

	public boolean isAlarm() {
		return true;
	}
}

class BWM extends CarModel {

	@Override
	public void start() {
		System.out.println("BWM start() ...");
	}

	@Override
	public void alarm() {
		System.out.println("BWM alarm() ...");
	}

	@Override
	public void stop() {
		System.out.println("BWM stop() ...");
	}

}

class Benz extends CarModel {

	private boolean isAlarmFlag;

	public boolean isAlarmFlag() {
		return isAlarmFlag;
	}

	public void setAlarmFlag(boolean isAlarmFlag) {
		this.isAlarmFlag = isAlarmFlag;
	}

	@Override
	public boolean isAlarm() {
		return isAlarmFlag();
	}

	@Override
	public void start() {
		System.out.println("Banz start() ...");
	}

	@Override
	public void alarm() {
		System.out.println("Banz alarm() ...");
	}

	@Override
	public void stop() {
		System.out.println("Banz stop() ...");
	}

}