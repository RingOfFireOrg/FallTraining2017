package org.usfirst.frc.team3459.robot;

import com.ctre.CANTalon;
import java.util.Timer;
import java.util.TimerTask;

public class RearWheelActuator extends CANTalon {
	
	private static final double DEFAULT_SPEED = 0.8;
	private static final int TURN_TIME = 1000;
	
	private boolean isWheelDown;
	
	public RearWheelActuator() {
		super(RobotMap.WHEEL_ACTUATOR);
		isWheelDown = true;
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

	public void forceWheelDown() {
		set(DEFAULT_SPEED);
	}

	public void forceWheelUp() {
		set(-DEFAULT_SPEED);
	}

	public void stop() {
		set(0.0);
	}

	private void setWheel(double speed) {
		set(speed);
		new Timer().schedule(
				new TimerTask() {
					@Override
					public void run() {
						stop();
					}
				}, TURN_TIME);
	}
}
