// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class LED extends SubsystemBase {
  /** Creates a new LED. */

  private AddressableLED led;
  private AddressableLEDBuffer ledBuffer;
  private int rainbowFirstPixelHue, pressureBasedValue;
  private double pressureValue;

  public LED(int port, int length) {
    led = new AddressableLED(port);
    ledBuffer = new AddressableLEDBuffer(length);
    led.setLength(ledBuffer.getLength());
    led.setData(ledBuffer);
    led.start();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setTestLED() {

    for (var i = 0; i < ledBuffer.getLength(); i++) {

      final var hue = (rainbowFirstPixelHue + (i * 180 / ledBuffer.getLength())) % 180;
      // Set the value
      ledBuffer.setHSV(i, hue, 255, 128);
    }
    // Increase by to make the rainbow "move"
    rainbowFirstPixelHue += 3;
    // Check bounds
    rainbowFirstPixelHue %= 180;

    led.setData(ledBuffer);
  }

  public void setTestLEDSolid() {
    for (int i = 0; i < ledBuffer.getLength() - 1; i++) {
      ledBuffer.setRGB(i, 200, 200, 200);
    }

    led.setData(ledBuffer);
  }

  public void pressureBasedLED() {
    pressureValue = getPressureValue();
    pressureBasedValue = Math.toIntExact(Math.round((pressureValue / 90) * 100) / 100) * 255;
    System.out.println("Here: " + Math.round((pressureValue / 90) * 100) / 100);
    System.out.println("Pressure: " + pressureValue);
    System.out.println("Pressure Value: " + pressureBasedValue);
    for (int i = 0; i < ledBuffer.getLength() - 1; i++) {
      ledBuffer.setRGB(i, pressureBasedValue, pressureBasedValue, pressureBasedValue);
    }

    led.setData(ledBuffer);
  }

  public double getPressureValue() {

    // double pressureValue = Math.round((CompressorSubsystem.pressure / 90) * 100)
    // / 100;
    double pressureValue = CompressorSubsystem.pressure;
    return pressureValue;
  }
}
