package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team7587.robot.OI;
import frc.team7587.robot.Robot;
import frc.team7587.robot.commands.TeleopDrive;

public class DriveTrain extends Subsystem implements PIDOutput{

  private final SpeedController m_leftMotor = new PWMVictorSPX(OI.LEFT_MOTOR);
  private final SpeedController m_rightMotor = new PWMVictorSPX(OI.RIGHT_MOTOR);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;
  private ADXRS450_Gyro m_gyro;

  static final double kP = 0.03;
  static final double kI = 0.00;
  static final double kD = 0.00;
  static final double kF = 0.00;

  static final double kToleranceDegrees = 2.0f;

  PIDController turnController;
  double rotateToAngleRate;

  public DriveTrain() {

    SmartDashboard.putData("drive train left", (PWMVictorSPX) m_leftMotor);
    SmartDashboard.putData("drive tran right", (PWMVictorSPX) m_rightMotor);
    
    m_gyro = new ADXRS450_Gyro(kGyroPort);    
    m_gyro.setPIDSourceType(PIDSourceType.kRate);
    m_gyro.calibrate();

    turnController = new PIDController(kP, kI, kD, kF, m_gyro, this);
    
    // turnController.setInputRange(-180.0f, 180.0f);
    // turnController.setOutputRange(-1.0, 1.0);
    turnController.setAbsoluteTolerance(kToleranceDegrees);
    turnController.setContinuous(true);
  
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TeleopDrive());
  }

  public void testGyro(){
    double angle = m_gyro.getAngle();
    double rate = m_gyro.getRate();
    String name = m_gyro.getName();

    SmartDashboard.putNumber("gyro rate", rate);
    SmartDashboard.putNumber("gyro angle", angle);
    SmartDashboard.putString("gyro name", name);

  }

  public void rotateAngle(double angle){
    turnController.setSetpoint(angle);
    turnController.enable();

    // the rotateAngle is now output from the controller, use it here:
    m_drive.arcadeDrive(0, this.rotateToAngleRate);

  }

  public void drive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation);
  }

  public void log() {
    Joystick joy = Robot.m_oi.getLogiJoy();
    SmartDashboard.putNumber("Throttle: ", joy.getThrottle());
    SmartDashboard.putNumber("Drive Y: ", joy.getY());
    SmartDashboard.putNumber("Drive Z: ", joy.getTwist());

    SmartDashboard.putNumber("Drive New Vaulue: ", -joy.getThrottle() * joy.getY());
    SmartDashboard.putNumber("Drive old Value: ", ((-0.5 * joy.getThrottle()) + 1.5) * joy.getY());

  }

  @Override
  public void pidWrite(double output) {
    rotateToAngleRate = output;
  }

}
