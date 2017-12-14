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
	
public void drive(double x, double y, double z){
	motor1.set(x + z);
	motor3.set(x - z);
	motor2.set(y - z);
	motor0.set(y + z);
}
}
