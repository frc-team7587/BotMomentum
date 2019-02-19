
package frc.team7587.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
// import frc.team7587.robot.commands.Arm;
import frc.team7587.robot.commands.ArmIn;
import frc.team7587.robot.commands.ArmOut;
import frc.team7587.robot.commands.CloseClaw;
import frc.team7587.robot.commands.RampUp;
import frc.team7587.robot.commands.OpenClaw;
import frc.team7587.robot.commands.RampDown;

public class OI {

  // array of Gamepad Buttons

  // Constants for joysticks
  public static final int LOGI_JOY_PORT = 0;
  public static final int GAMEPAD_PORT = 1;
  public static final int GAMEPAD_RIGHT_STICK_PORT = 5;

  // Constants for motors aka PWM ports
  public static final int LEFT_MOTOR = 0;
  public static final int RIGHT_MOTOR = 1;
  public static final int RAMP_MOTOR = 2;
  public static final int FORWARD_SOLENOID = 1;
  public static final int REVERSE_SOLENOID = 2;
  public static final int CLAW_SERVO = 9;

  // Input devices
  private final Joystick logiJoy = new Joystick(LOGI_JOY_PORT); // logitech joystick
  private final Joystick gamePad = new Joystick(GAMEPAD_PORT); // gamepad

  // Constants for DIO ports
  public static final int STOP_UP_SWITCH = 9;
  public static final int STOP_DOWN_SWITCH = 8;
  public static final int STOP_OUT_SWITCH = 7;
  public static final int STOP_IN_SWITCH = 6;

  // Buttons and ButtonMap
  private Map<String, Integer> buttonMap;

  private final Button btnClawOpen;
  private final Button btnClawClose;
  private final Button btnRampUp;
  private final Button btnRampDown;
  private final Button btnArmOut;
  private final Button btnArmIn;
  // private final Button btnArm;

  // Constants
  public static final int CLAW_TIMEOUT = 1;

  public OI() {
    
    String[] gamePadButtons = { "A", "B", "X", "Y" };
    int[] gamePadValues     = {  1,   2,   3,   4 };
    buttonMap = getButtonMap(gamePadButtons, gamePadValues);

    btnClawOpen = new JoystickButton(gamePad, buttonMap.get("X"));
    btnClawClose = new JoystickButton(gamePad, buttonMap.get("A"));
    btnRampUp = new JoystickButton(gamePad, buttonMap.get("Y"));
    btnRampDown = new JoystickButton(gamePad, buttonMap.get("B"));
    // btnArmOut = new JoystickButton(gamePad, gamePad.getPOV(0));
    // btnArmIn = new JoystickButton(gamePad, gamePad.getPOV(1));
    // btnArm = new JoystickButton(gamePad, 0);
    btnArmOut = new JoystickButton(gamePad, 5);
    btnArmIn = new JoystickButton(gamePad, 6);

    btnClawOpen.whenPressed(new OpenClaw(CLAW_TIMEOUT));
    btnClawClose.whenPressed(new CloseClaw(CLAW_TIMEOUT));
    btnRampUp.whenPressed(new RampUp());
    btnRampDown.whenPressed(new RampDown());
    btnArmOut.whenPressed(new ArmOut()); //left bumper
    btnArmIn.whenPressed(new ArmIn()); //right bumper
    // btnArm.whenPressed(new Arm());
    
  }

  public Joystick getLogiJoy() {
    return logiJoy;
  }

  public Joystick getPad() {
    return gamePad;
  }

  private Map<String, Integer> getButtonMap(String[] buttons, int[] values) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < buttons.length && i < values.length; i++) {
      map.put(buttons[i], values[i]);
    }
    return map;
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
