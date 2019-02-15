/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.team7587.robot.Robot;

public class OpenClaw extends TimedCommand {

  public OpenClaw(double timeout) {
    super(timeout);
    //requires(Robot.m_claw);
  }

  @Override
  protected void initialize() {
    Robot.m_claw.open();
  }

  @Override
  protected void end() {
    Robot.m_claw.stop();
  }

  @Override
  protected void interrupted(){
    end();
  }
  
}
