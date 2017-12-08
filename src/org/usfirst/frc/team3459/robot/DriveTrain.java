package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.Victor;
import com.ctre.CANTalon;

public class DriveTrain {
	 Victor motor0 = new Victor(0);
	 Victor motor1 = new Victor(1);
	 Victor motor2 = new Victor(2);
	 Victor motor3 = new Victor(3);
      
	 CANTalon motor4 = new CANTalon(4);
	 CANTalon motor5 = new CANTalon(5);

	 
	public DriveTrain() {
		motor5.setInverted(true);
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
	
// public void drive(double x, double y){
//	motor1.set(x);
//	motor3.set(x);
//	motor2.set(y);
//	motor0.set(y);
//}
	public void drivetank(double left, double right){
		motor4.set(left);
		motor5.set(right);
		
	}
}
