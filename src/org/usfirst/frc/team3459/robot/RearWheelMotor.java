package org.usfirst.frc.team3459.robot;

import com.ctre.CANTalon;

public class RearWheelMotor extends CANTalon {
	
	private static final double DEFAULT_SPEED = 0.5;
	
	public RearWheelMotor() {
		super(RobotMap.WHEEL_MOTOR);
	}

	public void goForward() {
		set(DEFAULT_SPEED);
	}
	
	public void goBackward() {
		set(-DEFAULT_SPEED);
	}
	
	public void stop() {
		set(0.0);
	}
}
