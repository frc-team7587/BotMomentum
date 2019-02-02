/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DMC60;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import frc.team7587.robot.OI;
import frc.team7587.robot.Robot;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Servo claw = new Servo(OI.CLAW_SERVO);
  SpeedController gripperJoint = new DMC60(OI.TEST_MOTOR);

  public void open() {
    claw.set(1.0);
  }

  public void close() {
    claw.set(0.0);
  }

  public void stop(){
    claw.stopMotor();
  //  claw.set(claw.get());
    //TODO 
  }

  public void pointDown(){
    for (int a = 0 ; a < 50 ; a++){
    gripperJoint.set(0.1);
    }
    gripperJoint.stopMotor();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
