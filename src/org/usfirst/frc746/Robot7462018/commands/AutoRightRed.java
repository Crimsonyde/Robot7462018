package org.usfirst.frc746.Robot7462018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightRed extends CommandGroup {

    public AutoRightRed() {
    	addSequential(new autoMove(.60,.60,2.5));
    	addSequential(new autoMove(-.4,.4,0.75));
    	addParallel(new timedExtend(2.9));
    	addSequential(new autoMove(.3,.3,1));
    	addSequential(new autoNothing(1));
    	addParallel (new timedRetract(2));
    	addSequential(new autoMove(-.3,-.3,1));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
