/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.team7587.robot.Robot;

/**
 * Add your docs here.
 */
public class ArmOut extends Command {
  /**
   * Add your docs here.
   */
  private Timer timer = new Timer();

  public ArmOut() {

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
    Robot.m_arm.armOut();
    System.out.println("Arm out");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

  }

  @Override
  protected boolean isFinished() {
    // return Robot.m_arm.getOutLimit() ? true : timer.get() > 1;
    return timer.get() > 1;
  }

  // Called once after timeout
  @Override
  protected void end() {
    timer.stop();
    Robot.m_arm.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
