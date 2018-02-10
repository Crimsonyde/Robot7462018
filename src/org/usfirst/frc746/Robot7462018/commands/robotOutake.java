package org.usfirst.frc746.Robot7462018.commands;

import org.usfirst.frc746.Robot7462018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class robotOutake extends Command {

    public robotOutake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.rightIntakeMotor(-.75);
    	Robot.intake.leftIntakeMotor(.75);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
