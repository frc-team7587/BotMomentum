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
  }

  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  protected void execute() {

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    timer.stop();
  }

  @Override
  protected void interrupted() {
  }
}
