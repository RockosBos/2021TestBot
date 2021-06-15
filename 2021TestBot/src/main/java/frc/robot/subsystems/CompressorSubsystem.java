
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;
public class CompressorSubsystem extends SubsystemBase{

    public Compressor compressor = new Compressor(0);
    boolean bool = false;
    boolean value;
    ToggleButtonModel button = new ToggleButtonModel();
    public void compressorControl(Joystick controller){
       
        if(controller.getRawButton(12)){
            compressor.start();
        }
        if(controller.getRawButton(11)){
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
