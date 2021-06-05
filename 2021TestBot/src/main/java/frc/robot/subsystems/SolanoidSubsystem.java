// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;

public class SolanoidSubsystem extends SubsystemBase {

  public DoubleSolenoid doubleSolenoid = new DoubleSolenoid(0, 1);

  /** Creates a new SolanoidSubsystem. */

  public void solanoidControl(Joystick controller){
    if(controller.getRawButton(12)){
      doubleSolenoid.set(Value.kForward);
    }
    else if(controller.getRawButton(13)){
      doubleSolenoid.set(Value.kReverse);
    }
    else{
      doubleSolenoid.set(Value.kOff);
    }
  }
 
}
