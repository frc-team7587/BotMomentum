package frc.team7587.robot;

//essentials?
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

//subsystems
import frc.team7587.robot.subsystems.DriveTrain;
import frc.team7587.robot.subsystems.Ramp;
import frc.team7587.robot.subsystems.ArmPiston;
import frc.team7587.robot.subsystems.CargoIntake;
import frc.team7587.robot.subsystems.Claw;

//vision stuffs
import org.opencv.core.Mat;
import edu.wpi.first.cameraserver.CameraServer;
import frc.team7587.robot.GripPipeline;

public class Robot extends TimedRobot {

  public static OI m_oi = new OI();
  public static DriveTrain m_driveTrain = new DriveTrain();
  public static Claw m_claw = new Claw();
  public static Ramp m_ramp = new Ramp();
  public static ArmPiston m_arm = new ArmPiston();
  public static CargoIntake m_intake = new CargoIntake();

  // private GripPipeline grip = new GripPipeline();
  // private Mat matt1 = new Mat();
  private CameraServer cameraFront = CameraServer.getInstance();
  // private CameraServer cameraBack = CameraServer.getInstance();

  Command m_autoCommand;
  // SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    // grip.process(matt1);
    cameraFront.startAutomaticCapture();
    // cameraBack.getVideo(cameraFront.startAutomaticCapture());
    // cameraBack.addServer("GRIP", 1);
    // cameraBack.getInstance().putVideo("Find blue", 500, 400);
    // GripPipeline cameraBack2 = new GripPipeline();
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
    m_intake.log();
  }
}
