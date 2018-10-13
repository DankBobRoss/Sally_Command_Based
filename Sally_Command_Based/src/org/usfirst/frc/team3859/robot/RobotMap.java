/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3859.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// TALONS - DRIVE MOTORS
	public static int T1_frontLeftDrive = 1;
	public static int T2_middleLeftDrive = 2;
	public static int T3_backLeftDrive = 3;

	public static int T6_frontRightDrive = 6;
	public static int T7_middleRightDrive = 7;
	public static int T8_backRightDrive = 8;

	public static int T10_intakeBlueMotor = 10;
	public static int T5_intakeBlackMotor = 5;

	public static int T9_armLeftMotor = 9;
	public static int T4_armRightMotor = 4;

	// JOYSTICKS - CONTROLLLERS
	public static int gamePad0Value = 0;
	public static int gamePad1Value = 1;
	public static int driveJoystickValue = 2;
	public static int driveSteeringWheelValue = 3;

	// PNEUMATICS

	public static int intakeCompressForwardPort = 0;
	public static int intakeCompressReversePort = 1;

	public static String kForward = "kForward";
	public static String kReverse = "kReverse";

	// CONSTANTS FOR INTAKE

	public static String intake = "intake";
	public static String score_superpunch = "score_superpunch";
	public static String score_low = "score_low";
	public static String score_medium = "score_medium";
	public static String score_high = "score_high";
	public static String disable = "disable";

	// CONSTANTS FOR ARM

	public static double intakeArmGoal = 0;
	public static double switchArmGoal = 43;
	public static double scaleArmGoal = 98;

}
