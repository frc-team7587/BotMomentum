package frc.team7587.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team7587.robot.subsystems.DriveTrain;
import frc.team7587.robot.subsystems.Ramp;
import frc.team7587.robot.subsystems.ArmMotor;
import frc.team7587.robot.subsystems.Claw;

import org.opencv.core.Mat;

import edu.wpi.first.cameraserver.CameraServer;
import frc.team7587.GripPipeline;
import edu.wpi.first.wpilibj.vision.VisionPipeline;

public class Robot extends TimedRobot {

  public static OI m_oi = new OI();
  public static DriveTrain m_driveTrain = new DriveTrain();
  public static Claw m_claw = new Claw();
  public static Ramp m_ramp = new Ramp();
  public static ArmMotor m_arm = new ArmMotor();

  private GripPipeline grip = new GripPipeline();
  private CameraServer cameraFront = CameraServer.getInstance();
  private CameraServer cameraBack = CameraServer.getInstance();
  private Mat source0 = new Mat();

  Command m_autoCommand;
  // SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    grip.process(source0);
    cameraFront.startAutomaticCapture();
    cameraBack.startAutomaticCapture();
    cameraFront.getVideo(cameraFront.startAutomaticCapture());
    cameraBack.getVideo(cameraBack.startAutomaticCapture());
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void autonomousInit() {
    // schedule the autonomous command
    if (m_autoCommand != null) {
      m_autoCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autoCommand != null) {
      m_autoCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    log();
  }

  @Override
  public void testInit() {

  }

  @Override
  public void testPeriodic() {

  }

  public void log() {
    m_claw.log();
    m_driveTrain.log();
  }
}
