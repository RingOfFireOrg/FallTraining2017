package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;

/**
 * Don't change the name of this or it won't work. (The manifest looks for
 * "Robot")
 */
public class Robot extends IterativeRobot {
	UltrasonicSensor frontSensor = new UltrasonicSensor(RobotMap.frontSensor);
	AHRS ahrs;
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