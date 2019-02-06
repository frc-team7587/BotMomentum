/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.DMC60;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team7587.robot.OI;

/**
 * Add your docs here.
 */
public class Ramp extends Subsystem {
  private final SpeedController armMotor = new DMC60(OI.TEST_MOTOR);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void drive() {
    armMotor.set(0.2);
  }

  public void reverse(){
    armMotor.set(-0.2);
  }

  public void stop() {
    armMotor.stopMotor();
  }
}
