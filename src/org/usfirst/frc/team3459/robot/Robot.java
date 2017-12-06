package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
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
	AnalogInput light1 = new AnalogInput(0);
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		DriverStation.reportError("Blake was here!", false);
		DriverStation.reportWarning("Paul and Tanya", false);
		DriverStation.reportError("BrysonWasHere", false);
		DriverStation.reportWarning("Alan was here", false);
		DriverStation.reportWarning("Will Was Here", false);
		DriverStation.reportWarning("rose", false);
		DriverStation.reportWarning("Jason was here", true);
		DriverStation.reportWarning("Kayla is here", true);
		DriverStation.reportWarning("Rob was here", true);
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
		while (true) {
			int value = light1.getValue();
			SmartDashboard.putNumber("Light1", value);
			if (value < 505) {
				driveTrain.drive(0, 0, 0.2);
			} else {
				driveTrain.drive(0, 0, -0.2);
			}
			Timer.delay(0.05);
		}
	}

	protected double createDeadZone(double a) {
		if (Math.abs(a) < 0.1) {
			return (0.0);
		}
		return (a);
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
		int value = light1.getValue();
		SmartDashboard.putNumber("Light1", value);
		
		double xSpeed = stick.getX();
		double ySpeed = stick.getY();
		boolean triggerPressed = stick.getTrigger();
		double twist = stick.getTwist();
		
		xSpeed = createDeadZone(xSpeed);
		ySpeed = createDeadZone(ySpeed);
		twist = createDeadZone(twist);
		
		if(!triggerPressed){   // if trigger not pressed, slow down
			xSpeed = xSpeed / 2;   
			ySpeed = ySpeed / 2;
			twist = twist / 2;
		}
		driveTrain.drive(xSpeed, ySpeed, twist);
	
		
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
