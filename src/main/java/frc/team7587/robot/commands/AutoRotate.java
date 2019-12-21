/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team7587.robot.Robot;
import frc.team7587.robot.subsystems.DriveTrain;

public class AutoRotate extends Command {

  private double rotateAngle;
  private int inErrZoneCount;

  public AutoRotate(double rotateAngle) {
    requires(Robot.m_driveTrain);
    this.rotateAngle = rotateAngle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_driveTrain.initGyro(rotateAngle);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_driveTrain.rotateAngle();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    // this may not work per some posts
    //return Robot.m_driveTrain.getTurnController().onTarget();

    double tolerance = DriveTrain.kToleranceDegrees;
    double err = Math.abs(Robot.m_driveTrain.getGyroAngle() - this.rotateAngle);
    
    // this didn't seeem to work either...
    // double err = Robot.m_driveTrain.getTurnController().getError();

    if( Math.abs(err) < tolerance ){
      return (++inErrZoneCount) >= 5;   // after 5 consecutive inZone test
    }else{
      inErrZoneCount = 0;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.stop();
    Robot.m_driveTrain.getTurnController().disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
