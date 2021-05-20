// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.commands.Drive;
import frc.robot.commands.Solanoid;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.SolanoidSubsystem;
import frc.robot.commands.Solanoid;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  public SolanoidSubsystem m_SolanoidSystem = new SolanoidSubsystem();
  static Joystick driveController = new Joystick(Constants.DRIVE_CONTROLLER);
  public Solanoid solanoidCommand = new Solanoid();
  
  private final Drive m_Drive = new Drive();

  public static double GetDriverRawAccess(int axis) {
    return driveController.getRawAxis(axis);
  }
  // The robot's subsystems and commands are defined here...

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    m_DriveSubsystem.setDefaultCommand(new RunCommand(
        () -> m_DriveSubsystem.drive(driveController.getRawAxis(1), driveController.getRawAxis(0)), m_DriveSubsystem));

    for(int x = 0; x < 5; x++){

    m_SolanoidSystem.setDefaultCommand(new RunCommand(
      () -> m_SolanoidSystem.setSolanoidTrue()));

    }
    
    // Configure the button bindings
    configureButtonBindings();
  }.

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
