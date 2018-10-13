package org.usfirst.frc.team3859.robot.subsystems;

import org.usfirst.frc.team3859.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {

	PIDcontrol armPID = new PIDcontrol();

	private static TalonSRX T9_armLeftMotor = new TalonSRX(RobotMap.T9_armLeftMotor); // arm sensor motor
	private static VictorSPX T4_armRightMotor = new VictorSPX(RobotMap.T4_armRightMotor);

	private static SensorCollection armSensor = new SensorCollection(T9_armLeftMotor);

	double error;

	public void initDefaultCommand() {

	}

	public void setArmMotors(double armSpeed) {

		T9_armLeftMotor.set(ControlMode.PercentOutput, armSpeed);
		T4_armRightMotor.set(ControlMode.PercentOutput, armSpeed);

	}

	// sets up the arm motors to be in the correct states
	public void setUp() {
		T4_armRightMotor.setInverted(true); // right arm must be inverted to match
		// left arm
		T9_armLeftMotor.setSensorPhase(true); // sets sensor to output positive
		// values
	}

	// gets the position of the arm in terms of degreess
	double getPosition() {
		// calls arm set up code
		setUp();
		double position = ((armSensor.getQuadraturePosition() / 366) * 90) / 1024;

		return position;
	}

	public void set(double goalAngle) {

		error = goalAngle + getPosition();

		double P = 0.33;
		double I = 0;
		double D = 0;

		armPID.setPID(P, I, D);
		// double speed = armPID.calculate(error);

		if (error >= 0) {

			setArmMotors((P * -1 * error) / 12);

		} else if (error < 0) {

			setArmMotors((P * -.32 * error) / 12);

		}

		SmartDashboard.putNumber("Actual Angle", getPosition());
		SmartDashboard.putNumber("Goal Angle", goalAngle);
	}
}
