package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.Victor;

public class DriveTrain {
	 Victor motor0 = new Victor(0);
	 Victor motor1 = new Victor(1);
	 Victor motor2 = new Victor(2);
	 Victor motor3 = new Victor(3);
      
	public DriveTrain() {
	}
	public void testMotor(int motor,double speed){
		switch(motor){
		case 0:
			motor0.set(speed);
			break;
		case 1:
			motor0.set(speed);
			break;
		case 2:
			motor0.set(speed);
			break;
		case 3:
			motor0.set(speed);
			break;
		}
	}
	

}
