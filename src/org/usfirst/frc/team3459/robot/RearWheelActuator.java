package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.TalonSRX;
import com.ctre.CANTalon;
import java.util.Timer;
import java.util.TimerTask;

public class RearWheelActuator extends CANTalon{
	
	private static final double DEFAULT_SPEED = 0.5;
	private static final int TURN_TIME = 1000;
	
	private Boolean isWheelDown;
	
	public RearWheelActuator() {
		super(RobotMap.WHEEL_ACTUATOR);
//		isWheelDown = false;
	}

	public void wheelDown() {
		if (isWheelDown == true) return;
		setWheel(DEFAULT_SPEED);
		isWheelDown = true;
	}
	
	public void wheelUp() {
		if (isWheelDown == false) return;
		setWheel(-DEFAULT_SPEED);
		isWheelDown = false;
	}
		
	private void setWheel(double speed) {
		set(speed);
		new Timer().schedule(
				new TimerTask() {
					@Override
					public void run() {
						set(0);
					}
				}, TURN_TIME);
	
	}
}
