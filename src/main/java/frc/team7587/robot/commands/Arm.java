// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.team7587.robot.commands;

// import edu.wpi.first.wpilibj.command.CommandGroup;
// import frc.team7587.robot.OI;
// import frc.team7587.robot.Robot;

// /**
//  * Add your docs here.
//  */
// public class Arm extends CommandGroup {
//   /**
//    * Add your docs here.
//    */


//   public Arm() {

//     // Use requires() here to declare subsystem dependencies
//     // eg. requires(chassis);

//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize() {
//     if (Robot.m_arm.getStick().getPOV(1) == 0) {
//       addSequential(new ArmOut());
//     } else if (Robot.m_arm.getStick().getPOV(1) == 180) {
//       addSequential(new CloseClaw(OI.CLAW_TIMEOUT));
//       addSequential(new ArmIn());
//     }

//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   protected void execute() {
//     if (Robot.m_arm.getStick().getPOV(1) == 0) {
//       addSequential(new ArmOut());
//     } else if (Robot.m_arm.getStick().getPOV(1) == 180) {
//       addSequential(new CloseClaw(OI.CLAW_TIMEOUT));
//       addSequential(new ArmIn());
//     }
//   }

//   // Called once after timeout
//   @Override
//   protected void end() {

//   }

//   // Called when another command which requires one or more of the same
//   // subsystems is scheduled to run
//   @Override
//   protected void interrupted() {
//   }
// }
