
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import javax.swing.JToggleButton.ToggleButtonModel;

public class CompressorSubsystem extends SubsystemBase {

    public Compressor compressor = new Compressor(0);
    boolean bool = false;
    boolean value;
    AnalogInput pressureSensor = new AnalogInput(0);
    double pressure = 0;
    double maxPressure;

    public void compressorControl(Joystick controller) {
        pressure = convertVoltageToPressure(pressureSensor.getAverageVoltage());
        maxPressure = SmartDashboard.getNumber("Max Pressure", 40);
        System.out.println(maxPressure);
        /*
         * if(controller.getRawButton(12)){ if(bool){ bool = false; } else{ bool = true;
         * } }
         */
        if (controller.getRawButton(12) && pressure < maxPressure) {
            compressor.start();

        } else {
            compressor.stop();
        }
        updateDashboard();

    }

    public double convertVoltageToPressure(double voltage) {
        double pressure = 0;
        pressure = 250 * (voltage / 5) - 19.5;

        return pressure;
    }

    public double getPressure() {
        return pressure;
    }

    public void initDefaultCommand() {
    }

    public void updateDashboard() {
        SendableChooser maxPressureChooser = new SendableChooser<>();
        maxPressureChooser.setDefaultOption("90 PSI", 90);
        maxPressureChooser.addOption("80 PSI", 80);
        maxPressureChooser.addOption("70 PSI", 70);
        maxPressureChooser.addOption("60 PSI", 60);
        maxPressureChooser.addOption("50 PSI", 50);
        maxPressureChooser.addOption("40 PSI", 40);

        SmartDashboard.putData("Max Pressure", maxPressureChooser);
        SmartDashboard.putNumber("Pressure", Math.round(pressure * 1000) / 1000);

    }
}
