package org.usfirst.frc.team3459.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;

public class RearWheelMotor extends CANTalon {
	
	private static final double DEFAULT_SPEED = 0.4;
	
	public RearWheelMotor() {
		super(RobotMap.WHEEL_MOTOR);
		setInverted(true);
	}

	public void goForward() {
		set(DEFAULT_SPEED);
	}
	
	public void goForward(long milliseconds) {
		go(DEFAULT_SPEED, milliseconds);
	}
	
	public void goForwardFast() {
		set(1);
	}
	
	public void goBackward() {
		set(-DEFAULT_SPEED);
	}
	
	public void goBackward(long milliseconds) {
		go(-DEFAULT_SPEED, milliseconds);
	}
	
	public void stop() {
		set(0.0);
	}
	
	public void go(double speed, long milliseconds) {
		DriverStation.reportWarning("IN GO " + speed, false);
		long start = System.currentTimeMillis();
		long end = start + milliseconds;
		while (System.currentTimeMillis() < end) {
			set(speed);
		}
		stop();
		DriverStation.reportWarning("Out of GO", false);
	}
}
