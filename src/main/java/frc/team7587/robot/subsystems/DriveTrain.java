package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team7587.robot.commands.TankDriveWithGamepad;

public class DriveTrain extends Subsystem {

  private final SpeedController m_leftMotor = new PWMVictorSPX(0);
  private final SpeedController m_rightMotor = new PWMVictorSPX(1);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  public DriveTrain() {

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveWithGamepad());
  }

  public void drive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation);
  }

}
