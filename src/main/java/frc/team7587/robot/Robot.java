package frc.team7587.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team7587.robot.commands.Autonomous;
import frc.team7587.robot.subsystems.DriveTrain;
import frc.team7587.robot.subsystems.Ramp;
import frc.team7587.robot.subsystems.Claw;
import edu.wpi.first.wpilibj.Servo;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.wpilibj.vision.*;

public class Robot extends TimedRobot {

  public static OI m_oi = new OI();
  public static DriveTrain m_driveTrain = new DriveTrain();
  public static Claw m_claw = new Claw();
  public static Ramp arm = new Ramp();
  // Timer timer = new Timer();

  private CameraServer Camera;
  private CameraServer Camera2;

  Command m_autoCommand;
  // SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {

    Camera = CameraServer.getInstance();
    Camera.startAutomaticCapture();

    Camera2 = CameraServer.getInstance();
    Camera2.startAutomaticCapture();

    m_autoCommand = new Autonomous();
    //m_claw = new Claw();
    
    // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());

    // TODO: this doesn't work!
    // LiveWindow.add(m_driveTrain);

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
    // m_autoCommand = m_chooser.getSelected();

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
    // m_claw.log();
    m_driveTrain.log();
  }
}
