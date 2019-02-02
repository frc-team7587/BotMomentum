package frc.team7587.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team7587.robot.commands.CloseClaw;
import frc.team7587.robot.commands.OpenClaw;

public class OI {

  // Constants for joysticks
  public static int LEFT_JOY = 0;
  public static int RIGHT_JOY = 1;
  public static int GAME_PAD = 0;   // logitech F310
  public static int GAMEPAD_RIGHT_STICK_PORT = 5;

  // Constants for motors
  public static int LEFT_MOTOR = 0;
  public static int RIGHT_MOTOR = 1;
  public static int TEST_MOTOR = 2;

  public static int CLAW_SERVO = 9;

  // input devices
  private final Joystick m_leftJoy = new Joystick(LEFT_JOY); //logitech joystick
  private final Joystick m_rightJoy = new Joystick(RIGHT_JOY); //gamepad
  private final Joystick m_gamePad = new Joystick(CLAW_SERVO);

  //Buttons
  public static int OPEN_BUTTON = 1;
  public static int CLOSE_BUTTON = 4;
  private final Button padA = new JoystickButton(m_rightJoy, OPEN_BUTTON);
  private final Button padY = new JoystickButton(m_rightJoy, CLOSE_BUTTON);



  public OI() {
    
    //padY.whenReleased(new OpenClaw(1));
    //padY.whileHeld(new CloseClaw());
    
    padY.whenPressed(new OpenClaw(4));
    padA.whenPressed(new CloseClaw(.5));

    // padZ.whenPress(new CloseClaw(3))

  }

  //public Button getPadA() {
  //  return padA;
  //}


  public Joystick getLeftJoystick() {
    return m_leftJoy;
  }

  public Joystick getRightJoystick(){
    return m_rightJoy;
  }

  public Joystick getGamepad(){
    return m_gamePad;
  }
  

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
