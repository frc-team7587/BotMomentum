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

public class RampUp extends Command {
  private static final int RUN_TIMEOUT = 2;
  private Timer timer = new Timer();

  public RampUp() {
    // requires(Robot.m_ramp);
  }

  @Override
  protected void initialize() {
    timer.reset();
    timer.start();

  }

  protected void execute() {
    Robot.m_ramp.rampUp();
  }

  @Override
  protected boolean isFinished() {
    return Robot.m_ramp.upLimitReached() ? true : timer.get() > RUN_TIMEOUT;
    // return false;
  }

  @Override
  protected void end() {
    Robot.m_ramp.stop();
    timer.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
