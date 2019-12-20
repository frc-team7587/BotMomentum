package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
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

  static final double kP = 0.06;
  static final double kI = 0.00;
  static final double kD = 0.005;
  static final double kF = 0.00;

  static final double kToleranceDegrees = 2.0f;

  PIDController turnController;
  double rotateToAngleRate;

  public DriveTrain() {

    SmartDashboard.putData("drive train left", (PWMVictorSPX) m_leftMotor);
    SmartDashboard.putData("drive tran right", (PWMVictorSPX) m_rightMotor);
    
    m_gyro = new ADXRS450_Gyro(kGyroPort);    
    m_gyro.calibrate();
    m_gyro.reset();
    // m_gyro.setPIDSourceType(PIDSourceType.kRate);

    turnController = new PIDController(kP, kI, kD, kF, m_gyro, this);
    
    turnController.setInputRange(-180.0f, 180.0f);
    // turnController.setOutputRange(-1.0, 1.0);
    turnController.setOutputRange(-0.75, 0.75);
    turnController.setAbsoluteTolerance(kToleranceDegrees);
    turnController.setContinuous(true);
  
    testGyro();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TeleopDrive());
  }

  public void testGyro(){
    SmartDashboard.putNumber("gyro rate", m_gyro.getRate());
    SmartDashboard.putNumber("gyro angle", m_gyro.getAngle());
    SmartDashboard.putString("gyro name", m_gyro.getName());
    SmartDashboard.putNumber("PID output", rotateToAngleRate);
    SmartDashboard.putNumber("PID error", turnController.getError());
  }

  public void rotateAngle(double targetAngle){
    // m_gyro.reset();
    turnController.reset();
    turnController.setSetpoint(targetAngle);
    turnController.enable();

    // the rotateAngleRate is now output from the controller
    m_drive.arcadeDrive(0, this.rotateToAngleRate);
    
  }

  public void drive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation);
  }

  public void stop(){
    m_drive.arcadeDrive(0,0);
    m_leftMotor.stopMotor();
    m_rightMotor.stopMotor();
    
  }

  public void log() {

  }

  public PIDController getTurnController(){
    return this.turnController;
  }

  @Override
  public void pidWrite(double output) {
    rotateToAngleRate = output;
  }

}
