// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc746.Robot7462018;

import org.usfirst.frc746.Robot7462018.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc746.Robot7462018.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton intake1;
    public JoystickButton intakeOut1;
    public Joystick driver1;
    public JoystickButton callExtend;
    public JoystickButton callRetract;
    public JoystickButton intake2;
    public JoystickButton intakeOut2;
    public JoystickButton driveToggle;
    public Joystick operator2;
    
    public JoystickButton forward;
    public JoystickButton reverse;
    public JoystickButton left;
    public JoystickButton right;
    //boolean left = driver1.button(LogitechF310.DPAD_LEFT);
    //boolean right = driver1.button(LogitechF310.DPAD_RIGHT);
    //boolean up = driver1.button(LogitechF310.DPAD_UP);
    //boolean down = driver1.getRawButton(driver1.getPOV(180));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        operator2 = new Joystick(1);
        
        callRetract = new JoystickButton(operator2, 3);
        callRetract.whileHeld(new retractArm());
        callExtend = new JoystickButton(operator2, 1);
        callExtend.whileHeld(new extendArm());
        driver1 = new Joystick(0);
        
        intake1 = new JoystickButton(operator2, 5);
        intake1.whileHeld(new robotIntake());
        intakeOut1 = new JoystickButton(operator2, 7);
        intakeOut1.whileHeld(new robotOutake());
        
       
        forward = new JoystickButton(driver1,4);
        forward.whileHeld(new tankDrive(.3,.3));
        
        reverse = new JoystickButton(driver1,2);
        reverse.whileHeld(new tankDrive(-.3,-.3));
        
        left = new JoystickButton(driver1,1);
        left.whileHeld(new tankDrive(-.3,.3));
  
        right = new JoystickButton(driver1,3);
        right.whileHeld(new tankDrive(.3,-.3));
        
        

        // SmartDashboard Buttons
        //SmartDashboard.putData("robotIntake", new robotIntake());
        //SmartDashboard.putData("extendArm", new extendArm());
        //SmartDashboard.putData("retractArm", new retractArm());
        //SmartDashboard.putData("reverseTank", new reverseTank());
        //SmartDashboard.putData("tankDrive", new tankDrive());
        //SmartDashboard.putData("AutoLeftBlue", new AutoLeftBlue());             
        //SmartDashboard.putData("autonomousTest", new autonomousTest());
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriver1() {
        return driver1;
    }

    public Joystick getOperator2() {
        return operator2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

