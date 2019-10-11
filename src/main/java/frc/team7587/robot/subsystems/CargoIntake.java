/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import frc.team7587.robot.OI;

/**
 * Add your docs here.
 */
public class CargoIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private SpeedController cargo = new PWMVictorSPX(OI.INTAKE_MOTOR);
  private Encoder encoder = new Encoder(0, 1, false, EncodingType.k4X);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    encoder.reset();
    encoder.setMinRate(4.0);
    encoder.setMaxPeriod(0.25);

  }

  public CargoIntake() {

  }

  public void output(double speed) {
    cargo.set(-0.5 * speed);
  }

  public void intake(double speed) {
    cargo.set(0.5 * speed);
  }

  public void stop() {
    cargo.set(0);
    cargo.stopMotor();
  }

  public void test(){
  }

  public void log(){
    SmartDashboard.putNumber("Encoder count: ", encoder.get());
    SmartDashboard.putNumber("Encoder rate: ", encoder.getRate());
  }
}
