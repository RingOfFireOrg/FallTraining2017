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
	private double normalize(double angle){
		double retAngle = angle % 360;
		if(retAngle < 0){
			retAngle += 360;
		}
		return retAngle;
	}

	public void testMotor(int motor, double speed) {
		switch (motor) {
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

	public void drive(double x, double y) {
		motor1.set(x);
		motor3.set(x);
		motor2.set(y);
		motor0.set(y);
	}

	public void drive(double degrees, double magnitude, double currentAngle) {
		double driveAngle = normalize(degrees + currentAngle);
		
		//TODO: not sure I got the y and x right - we should test to make sure
		double yVector = Math.sin(Math.toRadians(driveAngle));
		double xVector = Math.cos(Math.toRadians(driveAngle));
		
		this.drive(xVector * magnitude, yVector * magnitude);
	}

	public void drive(double twist) {
		twist = Math.pow(twist,3);   //twist^3  - this keeps the sign, but makes small values much smaller
		
		this.drive(twist, twist);
	}
}
