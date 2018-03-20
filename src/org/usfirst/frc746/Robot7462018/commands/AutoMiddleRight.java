package org.usfirst.frc746.Robot7462018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleRight extends CommandGroup {

    public AutoMiddleRight() {
    	addSequential(new autoMove(.6,.35,2.2));
    	addSequential(new autoMove(0,.4,1.3));
    	addParallel(new timedExtend(2.9));
    	addSequential(new autoMove(.4,.4,1.4));
    	addSequential(new autoNothing(1.5));
    	//addSequential(new autoMove(0,0,0));
    	addParallel (new timedRetract(2));
    	addSequential(new autoMove(-.5,-.7,1.5));
    	addSequential(new autoNothing(1));
    	addSequential(new autoMove(.65,.5,2));
    	addSequential(new autoMove(.2,.5,1.2));
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
