package org.usfirst.frc.team3859.robot;

import org.usfirst.frc.team3859.robot.commands.IntakeCube;
import org.usfirst.frc.team3859.robot.commands.ScoreCube;
import org.usfirst.frc.team3859.robot.commands.ScoreSuperPunch;
import org.usfirst.frc.team3859.robot.commands.setArmToSwitch;
import org.usfirst.frc.team3859.robot.commands.drive.DriveWithJoysticks;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {

	//
	// intakeArmButton = Constants.launchPad1.getRawButton(8);
	// switchArmButton = Constants.launchPad0.getRawButton(3);
	// scaleArmButton = Constants.launchPad1.getRawButton(7);
	// backArmButton = Constants.launchPad1.getRawButton(6);
	//
	// climbDeployButton = Constants.launchPad0.getRawButton(13);
	// // climbPoleButton1 = Constants.launchPad0.getRawButton(9);
	// rightClimbReDeploy = Constants.launchPad0.getRawButton(9);
	// engagePTO = Constants.launchPad1.getRawButton(11);
	//
	// intakeCompress = Constants.launchPad0.getRawButton(14);
	// intakeUncompress = Constants.launchPad1.getRawButton(9);
	// intakeNeutral = Constants.launchPad1.getRawButton(10);
	//
	// climbFeet1 = Constants.launchPad1.getRawButton(12);

	// ENUM VARIABLE USED FOR THE VARIOUS STATES OF THE INTAKE
	public enum intakeStates {
		intake, score_low, score_medium, score_high, score_superpunch, disable;
	}

	// Command

	Command driveWithJoysticks = new DriveWithJoysticks();

	ControlBoard OIControl = new ControlBoard();

	// INTAKE BUTTONS
	Button intakeInButton = new JoystickButton(OIControl.gamePad0, 7);
	Button shootMediumButton = new JoystickButton(OIControl.gamePad1, 5);
	Button shootHardButton = new JoystickButton(OIControl.gamePad1, 4);
	Button shootSuperPunchButton = new JoystickButton(OIControl.gamePad1, 3);

	Button engagePTO = new JoystickButton(OIControl.gamePad1, 11);

	// ARM BUTTONS

	Button armIntakeButton = new JoystickButton(OIControl.gamePad1, 8);
	Button armSwitchButton = new JoystickButton(OIControl.gamePad0, 3);
	// Button armScaleButton = new JoystickButton(OIControl.gamePad1, 7);
	// Button armBackButton = new JoystickButton(OIControl.gamePad1, 6);

	public void enable() {

		// DRIVE
		driveWithJoysticks.start();

		// INTAKE

		intakeInButton.whileActive(new IntakeCube());

		shootMediumButton.whileActive(new ScoreCube(-.45));

		shootHardButton.whileActive(new ScoreCube(-.9));

		shootSuperPunchButton.whileActive(new ScoreSuperPunch());

		// ARM

//		armIntakeButton.whenPressed(new setArmToIntake());
//
		armSwitchButton.whenPressed(new setArmToSwitch());

//		armIntakeButton.whileActive(new setArmToIntake());

//		armSwitchButton.whileActive(new setArmToSwitch());

	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whileHeld(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}