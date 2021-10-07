// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ShooterTurnSubsystem extends SubsystemBase {

  public WPI_VictorSPX shooterTurnDrive = new WPI_VictorSPX(Constants.MOTOR_SHOOTERTURN_ID);

  public DigitalInput leftLimit = new DigitalInput(0);

  public DigitalInput rightLimit = new DigitalInput(1);

  /** Creates a new ShooterTurnSubsystem. */
  public void ShooterTurn(Joystick controller) {
    /*
     * if(controller.getRawButton(3)){
     * shooterTurnDrive.set(Constants.SHOOTER_TURN_SPEED); } else
     * if(controller.getRawButton(4)){
     * shooterTurnDrive.set(-Constants.SHOOTER_TURN_SPEED); } else{
     * shooterTurnDrive.set(0); }
     */
    if ((-controller.getRawAxis(2) > .1 && !rightLimit.get())
        || (-controller.getRawAxis(2) < -.1 && !leftLimit.get())) {
      shooterTurnDrive.set(-controller.getRawAxis(2) * Constants.SHOOTER_TURN_MULTIPLIER);
    } else {
      shooterTurnDrive.set(0);
    }
    System.out
        .println("Right: " + rightLimit.get() + " Left: " + leftLimit.get() + " Speed: " + -controller.getRawAxis(2));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
