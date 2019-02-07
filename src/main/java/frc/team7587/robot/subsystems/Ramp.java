/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.DMC60;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team7587.robot.OI;

/**
 * Add your docs here.
 */
public class Ramp extends Subsystem {
  private final SpeedController rampMotor = new DMC60(OI.TEST_MOTOR);
  DigitalInput stopUpSwitch = new DigitalInput(9);
  DigitalInput stopDownSwitch = new DigitalInput(8);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public DigitalInput getUpDigitInput(){
    return stopUpSwitch;
  }

  public DigitalInput getDownDigitInput(){
    return stopDownSwitch;
  }

  public void rampUp() {
    rampMotor.set(0.2);
  }

  public void rampDown(){
    rampMotor.set(-0.2);
  }
  
  public void stop() {
    rampMotor.set(0);
  }
}
