package org.usfirst.frc746.Robot7462018.commands;

import org.usfirst.frc746.Robot7462018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoMove extends Command {

	double left;
	double right;
	double seconds;
	
    public autoMove(double leftValue, double rightValue, double timer) {
    	left = leftValue;
    	right = rightValue;
    	seconds = timer;
    	
    	requires(Robot.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.stop();
    	setTimeout(seconds);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setTankDrive(left, right, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
