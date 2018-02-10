package org.usfirst.frc746.Robot7462018.commands;

import org.usfirst.frc746.Robot7462018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class timedExtend extends Command {
	
	double seconds;

    public timedExtend(double timer) {
    	
    	seconds = timer;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(seconds);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.setArmMotor(-.45);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
