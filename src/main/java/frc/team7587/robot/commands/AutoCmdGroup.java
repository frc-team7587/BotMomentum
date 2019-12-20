package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCmdGroup extends CommandGroup {

    public AutoCmdGroup(){
        // drive straight for 2 secs
        // addSequential(new AutoDriveStraight(1.5));
        
        // then turn right by 90 degrees
        addSequential(new AutoRotate(90f));

    }

}