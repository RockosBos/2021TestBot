
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
       /* if(controller.getRawButton(12)){
            if(bool){
                bool = false;
            }
            else{
                bool = true;
            }
        }*/
        if(controller.getRawButton(12)){
            compressor.start();

        }
        else{
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
