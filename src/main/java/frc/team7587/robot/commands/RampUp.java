/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.team7587.robot.Robot;
import frc.team7587.robot.subsystems.DriveTrain;

public class RampUp extends TimedCommand {
  public RampUp(double timeout) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    super(timeout);
    // requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.arm.drive();
  }

  // Called repeatedly when this Command is scheduled to run
  // @Override
  // protected void execute() {

  // }

  // Make this return true when this Command no longer needs to run execute()
  // @Override
  // protected boolean isFinished() {
  // return false;
  // }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.arm.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  // @Override
  // protected void interrupted() {
  // }
}
