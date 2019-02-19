/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team7587.robot.OI;
import frc.team7587.robot.Robot;

/**
 * Add your docs here.
 */
public class ArmMotor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final DoubleSolenoid armSolenoid = new DoubleSolenoid(OI.FORWARD_SOLENOID, OI.REVERSE_SOLENOID);
  private final DigitalInput outLimit = new DigitalInput(OI.STOP_OUT_SWITCH);
  private final DigitalInput inLimit = new DigitalInput(OI.STOP_IN_SWITCH);
  private final Joystick stick = Robot.m_oi.getPad();



  @Override
  public void initDefaultCommand() {

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  // clockwise out, negative? counterclockwise in, positive
  // public boolean getOutLimit(){
  //   return outLimit.get();
  //  }

// public boolean getInLimit(){
//   return inLimit.get();
// }

  public void armOut() {
    armSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void armIn() {
    armSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void stop() {
    armSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  public Joystick getStick(){
    return stick;
  }
}
