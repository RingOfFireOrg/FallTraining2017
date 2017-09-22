package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltrasonicSensor extends AnalogInput {

	public UltrasonicSensor(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}
	public double getDistance() {
		double voltsPerInch = 0.0098;
		return getAverageVoltage() / voltsPerInch;
	}

}
