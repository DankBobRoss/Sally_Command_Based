package org.usfirst.frc.team3859.robot.subsystems;

import org.usfirst.frc.team3859.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private boolean isCompressed;
	private boolean isSuperPunchOut;
	Timer cubeTimer = new Timer();

	public boolean init = false;

	String currentSuperPunchStep = "open intake";

	private static VictorSPX T5_blackIntakeMotor = new VictorSPX(RobotMap.T5_intakeBlackMotor);
	private static VictorSPX T10_blueIntakeMotor = new VictorSPX(RobotMap.T10_intakeBlueMotor);

	private static DoubleSolenoid intakeCompress = new DoubleSolenoid(RobotMap.intakeCompressForwardPort,
			RobotMap.intakeCompressReversePort);

	public void initDefaultCommand() {
		// setDefaultCommand(new StopIntake());
	}

	public void setBlueIntakeMotor(double intakeSpeed) {
		T10_blueIntakeMotor.set(ControlMode.PercentOutput, -intakeSpeed);
	}

	public void setBlackIntakeMotor(double intakeSpeed) {
		T5_blackIntakeMotor.set(ControlMode.PercentOutput, intakeSpeed);
	}

	public void setCompressionState(String compressionState) {

		if (compressionState == RobotMap.kForward) {

			intakeCompress.set(Value.kForward);
			isCompressed = true;

		} else if (compressionState == RobotMap.kReverse) {

			intakeCompress.set(Value.kReverse);
			isCompressed = false;

		}

	}

	public void setSuperPunchPneumatic(String superPunchState) {
		if (superPunchState == RobotMap.kForward) {
			// set forward
			isSuperPunchOut = true;

		} else if (superPunchState == RobotMap.kReverse) {
			// set reverse
			isSuperPunchOut = false;

		}
	}

	public void startTimer() {
		if (init == false) {
			cubeTimer.start();
			init = true;
		}
	}

	public void setSuperPunch() {
		startTimer();
		if (currentSuperPunchStep == "open intake") {
			cubeTimer.reset();
			setCompressionState(RobotMap.kReverse);
			currentSuperPunchStep = "set intake motors";
		} else if (currentSuperPunchStep == "set intake motors" && cubeTimer.get() >= .25 && cubeTimer.get() < .5) {
			setBlackIntakeMotor(-1);
			setBlueIntakeMotor(-1);
			currentSuperPunchStep = "super punch out";
		} else if (currentSuperPunchStep == "super punch out" && cubeTimer.get() >= .5) {
			setCompressionState(RobotMap.kForward);
			currentSuperPunchStep = "almost complete";
		} else if (currentSuperPunchStep == "almost complete" && cubeTimer.get() >= .6) {
			setSuperPunchPneumatic(RobotMap.kForward);
			currentSuperPunchStep = "complete";
		}

	}

	public boolean getIntakeCompression() {

		return isCompressed;

	}
}
