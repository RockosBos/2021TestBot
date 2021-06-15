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
  DigitalInput leftLimitSwitch = new DigitalInput(0);
  DigitalInput rightLimitSwitch = new DigitalInput(1);
  String string;
  /** Creates a new ShooterTurnSubsystem. */
  public void ShooterTurn(Joystick controller){
    //Checks last movement       

    if(!rightLimitSwitch.get() && !leftLimitSwitch.get()){//checks limit switch hit
      if(controller.getRawButton(3)){
        shooterTurnDrive.set(Constants.SHOOTER_TURN_SPEED);
      }
      else if(controller.getRawButton(4)){
        shooterTurnDrive.set(-Constants.SHOOTER_TURN_SPEED);
      }
      else{
        shooterTurnDrive.set(0);
      }
    }
    else if(leftLimitSwitch.get()){ //hits limit switch while turning left
      if(controller.getRawButton(4)){
        shooterTurnDrive.set(-Constants.SHOOTER_TURN_SPEED);
      }
      else{
        shooterTurnDrive.set(0);
      }
    }
    else if(rightLimitSwitch.get()){//hits limit switch while turning right
      if(controller.getRawButton(3)){
        shooterTurnDrive.set(Constants.SHOOTER_TURN_SPEED);
      }
      else{
        shooterTurnDrive.set(0);
      }
    }

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
