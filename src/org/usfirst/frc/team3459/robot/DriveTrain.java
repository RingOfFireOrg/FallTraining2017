
package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.Victor;

public class DriveTrain {

	private static final double TWIST_LIMIT_LOW = -1.0;
	private static final double TWIST_LIMIT_HIGH = 1.0;

	Victor frontLeft = new Victor(2);
	Victor frontRight = new Victor(1);
	Victor backLeft = new Victor(3);
	Victor backRight = new Victor(0);

	public DriveTrain() {
		frontLeft.setInverted(true);
	}

	public void testMotor(int motor,double speed){
		switch(motor){
		case 0:
			backRight.set(speed);
			break;
		case 1:
			frontRight.set(speed);
			break;
		case 2:
			frontLeft.set(speed);
			break;
		case 3:
			backLeft.set(speed);
			break;
		}
	}

	public void drive(double x, double y, double twist){
		double twistFactor = computeTwist(x, y, twist);
		
		frontLeft.set(rangeFix(y - x - twistFactor));
		frontRight.set(rangeFix(y + x + twistFactor));
		backRight.set(rangeFix(y - x + twistFactor));
		backLeft.set(rangeFix(y + x - twistFactor));
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
