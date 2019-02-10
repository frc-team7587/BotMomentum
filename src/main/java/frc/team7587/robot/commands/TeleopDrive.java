/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team7587.robot.OI;
import frc.team7587.robot.Robot;

/**
 * Have the robot drive tank style using the logitech F310 gamepad
 */
public class TeleopDrive extends Command {

  Joystick stick = Robot.m_oi.getLogiJoy();

  public TeleopDrive() {
    requires(Robot.m_driveTrain);
  }

  // arcade drive with joystick
  @Override
  protected void execute() {
    Robot.m_driveTrain.drive(-stick.getThrottle() * stick.getY(), 0.5 * stick.getTwist());
  }

  @Override
  protected boolean isFinished() {
    return false; // Runs until interrupted
  }

  @Override
  protected void end() {

  }

}
