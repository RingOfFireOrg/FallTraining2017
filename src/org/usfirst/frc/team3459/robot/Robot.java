package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * Don't change the name of this or it won't work. (The manifest looks for
 * "Robot")
 */
public class Robot extends IterativeRobot {
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		DriverStation.reportError("Blake was here", true);
		DriverStation.reportWarning("Paul and Tanya", false);
		DriverStation.reportError("BrysonWasHere", false);
		DriverStation.reportWarning("Alan was here", false);
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
	}
}