
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import javax.swing.JToggleButton.ToggleButtonModel;
public class CompressorSubsystem extends SubsystemBase {

    public Compressor compressor = new Compressor(0);
    boolean bool = false;
    boolean value;
    public void compressorControl(Joystick controller){
    
        if(controller.getRawButton(12)){ //compressor on
            compressor.start();
            
        }
        if(controller.getRawButton(11)){ //compressor off
            compressor.stop();
        }
    
    }
    public boolean compressorValue(){
        value = compressor.getPressureSwitchValue();
        return value;
    }

    public void initDefaultCommand(){
    }
}
