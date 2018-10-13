package org.usfirst.frc.team3859.robot.subsystems;

import org.usfirst.frc.team3859.robot.RobotMap;
import org.usfirst.frc.team3859.robot.commands.drive.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	double speedd = 0;

	boolean check = false;
	boolean finished = false;

	Timer driveTimer = new Timer();

	public static TalonSRX T1_frontLeftDrive = new TalonSRX(RobotMap.T1_frontLeftDrive),
			T6_frontRightDrive = new TalonSRX(RobotMap.T6_frontRightDrive);

	public static VictorSPX T2_middleLeftDrive = new VictorSPX(RobotMap.T2_middleLeftDrive),
			T3_backLeftDrive = new VictorSPX(RobotMap.T3_backLeftDrive),
			T7_middleRightDrive = new VictorSPX(RobotMap.T7_middleRightDrive),
			T8_backRightDrive = new VictorSPX(RobotMap.T8_backRightDrive);

	public void initDefaultCommand() {

		// setDefaultCommand(new DriveWithJoysticks());

	}

	public void setLeft(double value) {
		T1_frontLeftDrive.set(ControlMode.PercentOutput, value);
		T2_middleLeftDrive.set(ControlMode.PercentOutput, value);
		T3_backLeftDrive.set(ControlMode.PercentOutput, value);
	}

	public void setRight(double value) {
		T6_frontRightDrive.set(ControlMode.PercentOutput, -value);
		T7_middleRightDrive.set(ControlMode.PercentOutput, -value);
		T8_backRightDrive.set(ControlMode.PercentOutput, -value);
	}

	// math for calculating steering wheel angles
	public double turnSense(double notPopTart) {
		double sense = .052; // steering sensitivity
		return sense * notPopTart * notPopTart * notPopTart + notPopTart * (1 - sense);
	}

	public double inverse(double start) {
		double inverse = .1;
		return (start) * inverse + start;
	}

	public void turbo(double speed, double turn) {
		double turboSpeed = .8;

		if (Math.signum(speed) == -1) {
			speedd = -turboSpeed;
		} else if (Math.signum(speed) == 1) {
			speedd = turboSpeed;
		}

		// double rightSide = -(inverse(speed) - (inverse(speed) * turnSense(turn));
		double rightSide = -(inverse(speedd) - (inverse(speedd) * turnSense(turn)));
		double leftSide = inverse(speedd) + (inverse(speedd) * turnSense(turn));

		setRight(rightSide);
		setLeft(leftSide);
	}

	public void sloww(double speed, double turn) {
		double slowwSpeed = .2;

		if (Math.signum(speed) == 1) {
			speedd = slowwSpeed;
		} else if (Math.signum(speed) == -1) {
			speedd = -slowwSpeed;
		}

		// double rightSide = -(inverse(speed) - (inverse(speed) * turnSense(turn));
		double rightSide = -(inverse(speedd) - (inverse(speedd) * turnSense(turn)));
		double leftSide = inverse(speedd) + (inverse(speedd) * turnSense(turn));

		setRight(rightSide);
		setLeft(leftSide);
	}

	/**
	 * 
	 * 
	 * @param speed
	 *            - the value used for how fast(usually a x value of a joystick)
	 * @param turn
	 *            - the value used for how much turn(usually a y value of a steering
	 *            wheel)
	 */
	public void move(double speed, double turn) {
		double speedd;

		if (speed > 0.5) {
			speedd = .5;
		} else if (speed < -0.5) {
			speedd = -.5;
		} else {
			speedd = speed;
		}

		// double rightSide = -(inverse(speed) - (inverse(speed) * turnSense(turn));
		double rightSide = inverse(speedd) - (inverse(speedd) * turnSense(turn));
		double leftSide = inverse(speedd) + (inverse(speedd) * turnSense(turn));

		setRight(rightSide);
		setLeft(leftSide);

	}

	public void turn(double speed) {
		setRight(speed);
		setLeft(speed);
	}

	public double getDriveTimer() {
		return driveTimer.get();
	}
	// AUTO

	public void autoTimeDrive(double timeDrive, double speed) {
		if (!check) {
			driveTimer.start();
			driveTimer.reset();
			check = true;
		}

		if (getDriveTimer() <= timeDrive) {
			setRight(speed);
			setRight(speed);
		} else {
			setRight(0);
			setRight(0);
			check = false;
			finished = true;
		}

	}

}
