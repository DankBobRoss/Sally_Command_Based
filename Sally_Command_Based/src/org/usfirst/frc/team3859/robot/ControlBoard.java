package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ControlBoard implements ControlBoardInterface {

	public Joystick driveJoystick;
	public Joystick steeringWheel;
	public Joystick gamePad0;
	public Joystick gamePad1;

	public ControlBoard() {

		driveJoystick = new Joystick(RobotMap.driveJoystickValue);
		steeringWheel = new Joystick(RobotMap.driveSteeringWheelValue);

		gamePad0 = new Joystick(RobotMap.gamePad0Value);
		gamePad1 = new Joystick(RobotMap.gamePad1Value);

	}

	@Override
	public double getTurn() {

		double turnSpeed = steeringWheel.getX();

		return turnSpeed;

	}

	@Override
	public double getDriveSpeed() {

		double driveSpeed = driveJoystick.getY();

		return -driveSpeed;

	}

	@Override
	public boolean getButtonPressed(Joystick controller, int button) {
		boolean isButtonPressed = controller.getRawButton(button);

		// if(controller.getRawButton(button) == true) {
		// isButtonPressed = true;
		// }

		return isButtonPressed;
	}

}
