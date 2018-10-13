package org.usfirst.frc.team3859.robot.commands;

import org.usfirst.frc.team3859.robot.RobotMap;
import org.usfirst.frc.team3859.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ScoreSuperPunch extends Command {

	Intake intake = new Intake();

	public ScoreSuperPunch() {
		// Use requires() here to declare subsystem dependencies
		requires(intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		intake.setSuperPunch();

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		intake.setBlackIntakeMotor(0);
		intake.setBlueIntakeMotor(0);

		// Intake.this.init = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
