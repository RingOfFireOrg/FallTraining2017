package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.TalonSRX;
import java.util.Timer;
import java.util.TimerTask;

public class RearWheelActuator extends TalonSRX {
	
	private static final double DEFAULT_SPEED = 1.0;
	private static final int TURN_TIME = 1000;
	
	private boolean isWheelDown;
	
	public RearWheelActuator() {
		super(RobotMap.WHEEL_ACTUATOR);
		isWheelDown = false;
	}

	public void wheelDown() {
		if (isWheelDown) return;
		setWheel(DEFAULT_SPEED);
		isWheelDown = true;
	}
	
	public void wheelUp() {
		if (!isWheelDown) return;
		setWheel(-DEFAULT_SPEED);
		isWheelDown = false;
	}
		
	private void setWheel(double speed) {
		setSpeed(speed);
		new Timer().schedule(
				new TimerTask() {
					@Override
					public void run() {
						stopMotor();
					}
				}, TURN_TIME);
	
	}
}
