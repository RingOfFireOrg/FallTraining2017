package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.Victor;

public class DriveTrain {
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
protected double rangeFix(double input, double limitLow, double limitHigh) {
	if (input < limitLow) {
		return limitLow;
	}
	if (input > limitHigh) {
		return limitHigh;
	}
	return input;
}
protected double computeTwist(double x, double y, double twist) {
	double rate = Math.max(x,y);
	return ((1-rate)*twist);
}

public void drive(double x, double y, double twist){
	double twistFactor = computeTwist(x, y, twist);
	
	motor1.set(rangeFix(x + twistFactor, -1.0, 1.0));
	motor3.set(rangeFix(x - twistFactor, -1.0, 1.0));
	motor2.set(rangeFix(y - twistFactor, -1.0, 1.0));
	motor0.set(rangeFix(y + twistFactor, -1.0, 1.0));
}
}
