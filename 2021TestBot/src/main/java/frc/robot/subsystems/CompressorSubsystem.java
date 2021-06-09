
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class CompressorSubsystem extends SubsystemBase {

    private WPI_VictorSPX leftDrive = new WPI_VictorSPX(Constants.MOTOR_LEFT_ID);
    private WPI_VictorSPX rightDrive = new WPI_VictorSPX(Constants.MOTOR_RIGHT_ID);

    private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightDrive);
    private SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftDrive);

    public DifferentialDrive base = new DifferentialDrive(leftMotors, rightMotors);

    public void drive(double speed, double angle) {
        System.out.println("Drive");
        base.arcadeDrive(speed, angle);
    }

    public void initDefaultCommand() {
        // setDefaultCommand(new Drive(driveController.getRawAxis(1),
        // driveController.getRawAxis(0));
    }

    public void setLeftMotors(double speed) {
        leftDrive.set(ControlMode.PercentOutput, -speed);
    }

    public void setRightMotors(double speed) {
        rightDrive.set(ControlMode.PercentOutput, speed);
    }
}
