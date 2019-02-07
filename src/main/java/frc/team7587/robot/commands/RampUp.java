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
import frc.team7587.robot.subsystems.DriveTrain;

public class RampUp extends Command {
  private boolean ouch;
  private Timer timer = new Timer();
  public RampUp() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    
  
    // super(timeout);
    // requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
    Robot.ramp.rampUp();
  }

  // Called repeatedly when this Command is scheduled to run
  // @Override
  protected void execute() {
    ouch = Robot.ramp.getUpDigitInput().get();
    if (timer.get()>5)
    {
      ouch = true;
    }
    // System.out.println("AHHHHHH " + ouch);
    // if (ouch) {
    //   Robot.ramp.stop();
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return ouch;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.ramp.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  // @Override
  // protected void interrupted() {
  // }
}
