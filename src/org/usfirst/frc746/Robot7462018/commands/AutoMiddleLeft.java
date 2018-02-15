package org.usfirst.frc746.Robot7462018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleLeft extends CommandGroup {

    public AutoMiddleLeft() {
    	addSequential(new autoMove(.3,.7,1.5));
    	addSequential(new autoMove(.5,.1,2));
    	addParallel(new timedExtend(2.9));
    	addSequential(new autoMove(.4,.4,1.4));
    	addSequential(new autoNothing(1.5));
    	//addSequential(new autoMove(0,0,0));
    	addParallel (new timedRetract(2));
    	addSequential(new autoMove(-.7,-.5,1.5));
    	addSequential(new autoNothing(.5));
    	addSequential(new autoMove(.65,.55,2.7));
    	//addSequential(new autoMove(.7,.5,.8));
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
