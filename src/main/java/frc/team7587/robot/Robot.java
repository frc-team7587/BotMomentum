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

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.wpilibj.vision.*;

public class Robot extends TimedRobot {

  public static DriveTrain m_driveTrain = new DriveTrain();
  public static OI m_oi = new OI();
  //Timer timer = new Timer();

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

    // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());

    SmartDashboard.putData("Drive Train", m_driveTrain);
    SmartDashboard.putNumber("Joystick Y", m_oi.getLeftJoystick().getY());

    LiveWindow.add(m_driveTrain);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    // Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    // m_autoCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */
   // timer.reset();
    //timer.start();

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
  }

  @Override
  public void testInit() {

  }

  @Override
  public void testPeriodic() {

  }
}
