package org.usfirst.frc.team3859.robot.commands.drive;

import org.usfirst.frc.team3859.robot.ControlBoard;
import org.usfirst.frc.team3859.robot.RobotMap;
import org.usfirst.frc.team3859.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticks extends Command {

	public Drive drive = new Drive();

	private ControlBoard driveControlBoard = new ControlBoard();

	public DriveWithJoysticks() {
		requires(drive);
	}

	protected void execute() {

		double turn = driveControlBoard.getTurn();
		double speed = driveControlBoard.getDriveSpeed();

		// if (driveControlBoard.getButtonPressed(driveControlBoard.driveJoystick, 2)) {
		//
		// drive.turn(driveControlBoard.driveJoystick.getX());
		//
		// } else {
		drive.move(speed, turn);
		// }
	}

	protected boolean isFinished() {
		return false;
	}
}
