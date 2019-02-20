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

public class RampDown extends Command {
  private static final int RUN_TIMEOUT = 3;
  private Timer timer = new Timer();
  private static final double INIT_JOLT = 0.3;
  public RampDown() {
    // requires(Robot.m_ramp);
  }

  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  protected void execute() {
    while(timer.get() < INIT_JOLT){
      Robot.m_ramp.rampDown(0.85);
    }
    // for (int a = 0; Robot.m_ramp.rampGet() > -0.2; a++){
    //   Robot.m_ramp.rampDown(Robot.m_ramp.rampGet() - (a * -0.05));
    // }

    // counter force!
    Robot.m_ramp.rampDown(-0.2);
  }

  @Override
  protected boolean isFinished() {
    // return Robot.m_ramp.downLimitReached() ? true : timer.get() > RUN_TIMEOUT;
    // return timer.get() > 4;
    return timer.get() > 2;  // to be tested
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
