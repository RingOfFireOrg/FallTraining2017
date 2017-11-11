package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;

/**
 * Don't change the name of this or it won't work. (The manifest looks for
 * "Robot")
 */
public class Robot extends IterativeRobot {
	UltrasonicSensor frontSensor = new UltrasonicSensor(RobotMap.frontSensor);
	AHRS ahrs;
	DriveTrain driveTrain = new DriveTrain();
	Joystick stick = new Joystick(1);
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		try {
			ahrs = new AHRS(I2C.Port.kOnboard);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
		ahrs.reset();
	}

	/**
	 * This function is called once when we go into the autonomous mode
	 */
	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous (approx 20ms)
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("Distance", frontSensor.getDistance());
	}

	/**
	 * This function is called once when we go into the teleop mode
	 */
	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		double joyAngle = stick.getDirectionDegrees();
		double joyMagnitude = stick.getMagnitude();
		boolean triggerPressed = stick.getTrigger();
		
		if(!triggerPressed){   // if trigger not pressed, slow down
			joyMagnitude = joyMagnitude / 2;   
		}
		driveTrain.drive(joyAngle, joyMagnitude, ahrs.getAngle());
	}

	/**
	 * This function is called once when we go into the test mode
	 */
	@Override
	public void testInit() {
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		driveTrain.testMotor(0, 0.5);
	}
}