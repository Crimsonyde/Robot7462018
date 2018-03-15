package org.usfirst.frc746.Robot7462018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightMidline extends CommandGroup {

    public AutoRightMidline() {
    	addSequential(new autoMove(0,0,0));
    	addSequential(new autoMove(0,0,0));
    	addSequential(new autoMove(0,0,0));
    }
}
