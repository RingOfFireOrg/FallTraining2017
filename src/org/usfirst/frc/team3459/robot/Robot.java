package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Don't change the name of this or it won't work. (The manifest looks for
 * "Robot")
 */
public class Robot extends IterativeRobot {

	DriveTrain driveTrain = new DriveTrain();
	Joystick stick = new Joystick(RobotMap.JOYSTICK);
	RearWheelMotor wheelMotor = new RearWheelMotor();
	RearWheelActuator wheelActuator = new RearWheelActuator();

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
		DriverStation.reportWarning("Jason was here", false);
		DriverStation.reportWarning("Kayla is here", false);
		SmartDashboard.putString("Team Name:", "Green Llamas");
	}

	/**
	 * This function is called once when we go into the autonomous mode
	 */
	@Override
	public void autonomousInit() {
		wheelMotor.goBackward(1000);
		wheelMotor.go(1, 500);
		wheelMotor.goBackward(1000);
		wheelMotor.goForward(3000);
	}

	/**
	 * This function is called periodically during autonomous (approx 20ms)
	 */
	@Override
	public void autonomousPeriodic() {
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
		engageDrive();
		manageRearWheel();
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

	private void engageDrive() {
		double xSpeed = stick.getX();
		double ySpeed = stick.getY();
		double twist = stick.getTwist();

		xSpeed = createDeadZone(xSpeed) / 2;
		ySpeed = createDeadZone(ySpeed) / 2;
		twist = createDeadZone(twist) / 2;

		driveTrain.drive(xSpeed, ySpeed, twist);
	}

	private double createDeadZone(double input) {
		if (Math.abs(input) < 0.1) {
			return (0.0);
		}
		return input;
	}

	private void manageRearWheel() {
		boolean downButtonPressed = stick.getRawButton(RobotMap.JS_BUTTON_WHEEL_DOWN);
		SmartDashboard.putBoolean("Wheel Down button pressed", downButtonPressed);
		boolean upButtonPressed = stick.getRawButton(RobotMap.JS_BUTTON_WHEEL_UP);
		SmartDashboard.putBoolean("Wheel Up button pressed", upButtonPressed);
		boolean forwardButtonPressed = stick.getRawButton(RobotMap.JS_BUTTON_WHEEL_FORWARD);
		SmartDashboard.putBoolean("Wheel Forward button pressed", forwardButtonPressed);
		boolean backButtonPressed = stick.getRawButton(RobotMap.JS_BUTTON_WHEEL_BACK);
		SmartDashboard.putBoolean("Wheel Back button pressed", backButtonPressed);
		boolean fastButtonPressed = stick.getRawButton(RobotMap.JS_BUTTON_WHEEL_FAST);

		if (downButtonPressed) {
			wheelActuator.forceWheelDown();
		}
		else if (upButtonPressed) {
			wheelActuator.forceWheelUp();
		}
		else {
			wheelActuator.stop();
		}

		if (forwardButtonPressed) {
			wheelMotor.goForward();
		}
		else if (backButtonPressed) {
			wheelMotor.goBackward();
		}
		else if (fastButtonPressed) {
			wheelMotor.goForwardFast();
		}
		else {
			wheelMotor.stop();
		}
	}
}
