
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSolenoidSubsystem extends SubsystemBase {

    Solenoid shooterSolenoid = new Solenoid(2);

    public void shooterControl(Joystick controller) {
        if (controller.getRawButton(1)) {
            shooterSolenoid.set(true);
            System.out.println("True");
        } else {
            shooterSolenoid.set(false);
            System.out.println("False");
        }
    }
}
