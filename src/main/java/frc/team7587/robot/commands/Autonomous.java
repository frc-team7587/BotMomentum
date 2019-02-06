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

public class Autonomous extends Command {

  private Timer timer = new Timer();
  private int t1 = 10;
  private int t2 = 20;

  public Autonomous() {
    requires(Robot.m_driveTrain);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if (timer.get() < t1) {
    //   Robot.m_driveTrain.drive(0.75, 0);
    // } else if (timer.get()>=t1 && timer.get()< t2)  {
    //   Robot.m_driveTrain.drive(-0.75, 0);
    // } else {
    //   Robot.m_driveTrain.drive(0,0);
    // }
    Robot.m_driveTrain.drive(0.5,0);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    timer.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
