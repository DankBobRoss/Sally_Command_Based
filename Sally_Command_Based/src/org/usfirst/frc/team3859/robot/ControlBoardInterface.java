package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.Joystick;

public interface ControlBoardInterface {

	double getTurn();

	double getDriveSpeed();

	boolean getButtonPressed(Joystick controller, int button);
}
