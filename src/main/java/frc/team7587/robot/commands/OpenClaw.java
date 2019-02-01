/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.team7587.robot.OI;
import frc.team7587.robot.Robot;

public class OpenClaw extends TimedCommand {
  private Timer timer = new Timer();
  // OI padPort = new OI();
  // private Button padA = padPort.getPadA();
  // private Joystick gamePad = padPort.getRightJoystick();
  // private int padPort = OI.RIGHT_JOY;

  private double timeout;

  public OpenClaw(double timeout) {
    super(timeout);
    this.timeout = timeout;
    
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    // requires(Robot.m_claw);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // timer.reset();
    // timer.start();
    Robot.m_claw.open();

  }

  // Called repeatedly when this Command is scheduled to run
  // @Override
  // protected void execute() {

  //   Robot.m_claw.open();

  // }

  // Make this return true when this Command no longer needs to run execute()
  // @Override
  // protected boolean isFinished() {
  //   return timer.get() > this.timeout;
  // }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_claw.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  // @Override
  // protected void interrupted() {
  // }
}
