package org.usfirst.frc746.Robot7462018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDelayMove extends CommandGroup {

    public AutoDelayMove() {
    	addSequential(new autoNothing(10));
    	addSequential(new AutoStraight());
       
    }
}
