package frc.team7587.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

  // Constants for joysticks
  public static int LEFT_JOY = 0;
  public static int RIGHT_JOY = 1;
  public static int GAME_PAD = 0;   // logitech F310
  public static int GAMEPAD_RIGHT_STICK_PORT = 5;

  // Constants for motors
  public static int LEFT_MOTOR = 0;
  public static int RIGHT_MOTOR = 1;

  // input devices
  private final Joystick m_lefJoy = new Joystick(LEFT_JOY);
  private final Joystick m_rightJoy = new Joystick(RIGHT_JOY);
  private final Joystick m_gamePad = new Joystick(LEFT_JOY);

  public OI() {

  }

  public Joystick getLeftJoystick() {
    return m_lefJoy;
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
