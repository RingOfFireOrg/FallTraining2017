package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.Victor;

public class DriveTrain {

	private static final double TWIST_LIMIT_LOW = -1.0;
	private static final double TWIST_LIMIT_HIGH = 1.0;

	Victor motor0 = new Victor(0);
	Victor motor1 = new Victor(1);
	Victor motor2 = new Victor(2);
	Victor motor3 = new Victor(3);

	public DriveTrain() {
		motor2.setInverted(true);
	}

	public void testMotor(int motor,double speed){
		switch(motor){
		case 0:
			motor0.set(speed);
			break;
		case 1:
			motor1.set(speed);
			break;
		case 2:
			motor2.set(speed);
			break;
		case 3:
			motor3.set(speed);
			break;
		}
	}

	public void drive(double x, double y, double twist){
		double twistFactor = computeTwist(x, y, twist);

		motor1.set(rangeFix(x + twistFactor));
		motor3.set(rangeFix(x - twistFactor));
		motor2.set(rangeFix(y - twistFactor));
		motor0.set(rangeFix(y + twistFactor));
	}

	private double computeTwist(double x, double y, double twist) {
		double rate = Math.max(x,y);
		return ((1-rate) * twist);
	}

	private double rangeFix(double twist) {
		if (twist < TWIST_LIMIT_LOW) {
			return TWIST_LIMIT_LOW;
		}
		if (twist > TWIST_LIMIT_HIGH) {
			return TWIST_LIMIT_HIGH;
		}
		return twist;
	}
}
