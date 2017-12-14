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
	// UltrasonicSensor frontSensor = new UltrasonicSensor(RobotMap.frontSensor);
	AHRS ahrs;
	DriveTrain driveTrain = new DriveTrain();
	Joystick stick = new Joystick(1);
	AnalogInput light0 = new AnalogInput(0);
	AnalogInput light1 = new AnalogInput(1);
	AnalogInput light2 = new AnalogInput(2);
	AnalogInput light3 = new AnalogInput(3);

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
		DriverStation.reportWarning("Linda was here", true);
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
//		SmartDashboard.putNumber("Distance", frontSensor.getDistance());
		double reentrySpeed = -0.3;
		
		double xnav = 0.0;
		double ynav = reentrySpeed;
		while (true) {
			int value0 = light0.getValue();
			SmartDashboard.putNumber("Light0", value0);
			int value1 = light1.getValue();
			SmartDashboard.putNumber("Light1", value1);
			int value2 = light2.getValue();
			SmartDashboard.putNumber("Light2", value2);
			int value3 = light3.getValue();
			SmartDashboard.putNumber("Light3", value3);
			

			boolean backleft = false;
			boolean backright = false;
			boolean frontleft = false;
			boolean frontright = false;
			
			int threshold = 2000;
			
			if (value0 < threshold) {
				backleft = true;
			}
			if (value1 < threshold) {
				backright = true;
			}
			if (value2 < threshold) {
				frontright = true;
			}
			if (value3 < threshold) {
				frontleft = true;
			}
			
			if (backleft) {
				if (frontleft) {
					xnav = -reentrySpeed;
					ynav = 0;
				} else if (backright) {
					xnav = 0; 
					ynav = reentrySpeed;
				} else {
					xnav = -reentrySpeed;
					ynav = reentrySpeed;
				}
			} else if (backright) {
				if (frontright) {
					xnav = reentrySpeed;
					ynav = 0;
				} else {
					xnav = reentrySpeed;
					ynav = reentrySpeed;
				}
			} else if (frontright) {
				if (frontleft) {
					xnav = 0;
					ynav = -reentrySpeed;
				} else {
					xnav = reentrySpeed;
					ynav = -reentrySpeed;
				}
			} else if (frontleft) {
				xnav = -reentrySpeed;
				ynav = -reentrySpeed;
			}
			driveTrain.drive(xnav, ynav, 0.05);
			
			if (!isAutonomous()) {
				xnav = 0;
				ynav = 0;
				driveTrain.drive(xnav, ynav, 0);
				return;
			}
			
			Timer.delay(0.10);
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
		int value = light0.getValue();
		SmartDashboard.putNumber("Light0", value);
		value = light1.getValue();
		SmartDashboard.putNumber("Light1", value);
		value = light2.getValue();
		SmartDashboard.putNumber("Light2", value);
		value = light3.getValue();
		SmartDashboard.putNumber("Light3", value);
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
		
		// work out a 45 degree offset
		
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
