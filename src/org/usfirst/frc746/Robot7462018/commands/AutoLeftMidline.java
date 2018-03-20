package org.usfirst.frc746.Robot7462018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftMidline extends CommandGroup {

    public AutoLeftMidline() {
        addSequential(new autoMove(0,0,0));
        addSequential(new autoMove(0,0,0));
        addSequential(new autoMove(0,0,0));
    }
}
