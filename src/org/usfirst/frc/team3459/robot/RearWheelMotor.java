package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.TalonSRX;

public class RearWheelMotor extends TalonSRX {
	
	private static final double DEFAULT_SPEED = 1.0;
	
	public RearWheelMotor() {
		super(RobotMap.WHEEL_MOTOR);
	}

	public void goForward() {
		setSpeed(DEFAULT_SPEED);
	}
	
	public void goBackward() {
		setSpeed(-DEFAULT_SPEED);
	}
	
	public void stop() {
		stopMotor();
	}
}
