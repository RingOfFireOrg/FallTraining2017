package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class TouchSensor extends DigitalInput {

	public TouchSensor(int channel) {
		super(channel);
	}

	public boolean isPressed() {
	  return get();
	}
}
