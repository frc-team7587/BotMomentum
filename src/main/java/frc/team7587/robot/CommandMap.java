/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot;

import java.util.HashMap;

public class CommandMap extends HashMap{
    public CommandMap(String[] buttons, int[] values){
        for(int i = 0; i < buttons.length && i < values.length; i++){
            put(buttons[i], values[i]);
        }
        
    }
}
