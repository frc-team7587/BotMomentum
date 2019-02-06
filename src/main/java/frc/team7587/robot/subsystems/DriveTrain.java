package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.DMC60;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team7587.robot.OI;
import frc.team7587.robot.Robot;
import frc.team7587.robot.commands.TankDriveWithGamepad;

public class DriveTrain extends Subsystem {

  private final SpeedController m_leftMotor = new PWMVictorSPX(OI.LEFT_MOTOR);
  private final SpeedController m_rightMotor = new PWMVictorSPX(OI.RIGHT_MOTOR);
  // private final SpeedController ramp = new DMC60(OI.TEST_MOTOR);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  public DriveTrain() {

    SmartDashboard.putData("drive train left", (PWMVictorSPX) m_leftMotor);
    SmartDashboard.putData("drive tran right", (PWMVictorSPX) m_rightMotor);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveWithGamepad());
  }

  public void drive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation);
  }

  public void log(){
    Joystick joy = Robot.m_oi.getLogiJoy();
    SmartDashboard.putNumber("Throttle: ", joy.getThrottle());
    SmartDashboard.putNumber("Drive Y: ", joy.getY());
    SmartDashboard.putNumber("Drive Z: ", joy.getTwist());

    SmartDashboard.putNumber("Drive New Vaulue: ",  -joy.getThrottle() * joy.getY() );
    SmartDashboard.putNumber("Drive old Value: ", ((-0.5 * joy.getThrottle()) + 1.5) * joy.getY());
    
  }

}
