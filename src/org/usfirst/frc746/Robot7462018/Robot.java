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

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.usfirst.frc746.Robot7462018.commands.*;
import org.usfirst.frc746.Robot7462018.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<String> chooser = new SendableChooser<>();
    //SendableChooser<Command> chooser = new SendableChooser<>();
    
    public static OI oi;
    public static DriveTrain driveTrain;
    public static Arm arm;
    public static Intake intake;
    //private UsbCamera camera0;
	//private UsbCamera camera1;
    UsbCamera camera1;

	final String autonomousTest = "Auto Test";
    final String AutoLeftBlue = "Auto Left Blue";
    final String AutoLeftRed = "Auto Left Red";
    final String AutoMiddleRed = "Middle Red Alliance";
    final String AutoMiddleBlue = "Middle Blue Alliance";
    final String AutoRightBlue = "Auto Right Blue";
    final String AutoRightRed = "Auto Right Red";
    final String AutoStraight = "Auto Straight";
    final String AutoLeftMid = "Middle Left Straight";
    final String AutoRightMid = "Middle Right Straight";


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
    	

		//AxisCamera Camera = CameraServer.getInstance().addAxisCamera("axis-camera.local");
		

    	/*
    	
    	Thread t = new Thread(() -> {
			boolean allowCam1 = false;
			UsbCamera Cam1 = CameraServer.getInstance().startAutomaticCapture();
			Cam1.setResolution(320, 240);
			Cam1.setFPS(15);
			UsbCamera Cam2 = CameraServer.getInstance().startAutomaticCapture();
			Cam2.setResolution(320, 240);
			Cam2.setFPS(15);
			// MjpegServer server = new MjpegServer("Output to dashboard",
			// 5800);

			CvSink cvSink1 = CameraServer.getInstance().getVideo(Cam1);
			CvSink cvSink2 = CameraServer.getInstance().getVideo(Cam2);
			CvSource outputStream = CameraServer.getInstance().putVideo("Switcher", 320, 240);
			Mat image = new Mat();
			while (!Thread.interrupted()) {

				if (oi.getDriver1().getRawButton(9)) {
					allowCam1 = !allowCam1;
				}
				if (allowCam1) {

					cvSink2.setEnabled(false);
					cvSink1.setEnabled(true);
					cvSink1.grabFrame(image);
				} else {
					cvSink1.setEnabled(false);
					cvSink2.setEnabled(true);
					cvSink2.grabFrame(image);

				}
				outputStream.putFrame(image);

			}

		});
		t.start();
    	
    	*/
        RobotMap.init();

        driveTrain = new DriveTrain();
        arm = new Arm();
        intake = new Intake();

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
             
		
		/*
		camera0 = CameraServer.getInstance().startAutomaticCapture();
		camera1 = CameraServer.getInstance().startAutomaticCapture();
		 */
		
		  autonomousCommand = new AutonomousCommand();
		  
	      chooser.addObject("Auto Left Blue",  AutoLeftBlue);
	      chooser.addObject("Auto Left Red", AutoLeftRed);
	      chooser.addObject("Middle Red Alliance", AutoMiddleRed);
	      chooser.addObject("Middle Blue Alliance", AutoMiddleBlue);
	      chooser.addObject("Auto Right Blue", AutoRightBlue);
	      chooser.addObject("Auto Right Red", AutoRightRed);
	      chooser.addObject("Auto Straight", AutoStraight);
	      chooser.addObject("Middle Left Straight", AutoLeftMid);
	      chooser.addObject("Middle Right Straight", AutoRightMid);
	      chooser.addDefault("Auto Test", autonomousTest);
	   	        	               
	       //chooser = new SendableChooser<Command>();
	       //chooser.addObject("Auto Left Blue", new AutoLeftBlue());
	       //chooser.addDefault("Autonomous Test", new autonomousTest());
	      SmartDashboard.putData("Auto mode", chooser);
		
	      UsbCamera Cam1 = CameraServer.getInstance().startAutomaticCapture();
			//AxisCamera Camera = CameraServer.getInstance().addAxisCamera("axis-camera.local");
			Cam1.setResolution(320,240);
			Cam1.setFPS(15);

    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){
    	Robot.driveTrain.stop();
    	Robot.arm.stop();
    	Robot.intake.stop();

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
       
    	String gameData;
    	String autoSelected = chooser.getSelected();
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
        System.out.println("Auto selected: " + autoSelected);
		switch (autoSelected) {
		
		case autonomousTest:
			default:
			autonomousCommand = new autonomousTest();
			break;
		
		case AutoStraight:
			autonomousCommand = new AutoStraight();
			break;
		
		case AutoLeftBlue:
			if(gameData.charAt(0) == 'L') {
				autonomousCommand = new AutoLeftBlue();
				break;
			}
			else {
				autonomousCommand = new AutoStraight();
				break;
			}
				
		case AutoLeftRed:
			if (gameData.charAt(0) == 'L') {
				autonomousCommand = new AutoLeftRed();
				break;
			}
			else {
				autonomousCommand = new AutoStraight();
				break;
			}
			
		
		case AutoRightBlue:
			if (gameData.charAt(0) == 'L') {
				autonomousCommand = new AutoRightBlue();
				break;
			}
			else {
				autonomousCommand = new AutoStraight();	
				break;
			}
			
		
		case AutoRightRed:
			if (gameData.charAt(0) == 'L') {				
				autonomousCommand = new AutoRightRed();
				break;
			}
			else {
				autonomousCommand = new AutoStraight();
				break;
			}
			
			
		case AutoMiddleRed:
			if (gameData.charAt(0) == 'L') {
				autonomousCommand = new AutoMiddleLeft();
				break;
			}
			else {			
				autonomousCommand = new AutoMiddleRight();	
				break;
			}
			
		case AutoMiddleBlue:
			if (gameData.charAt(0) == 'L') {
				autonomousCommand = new AutoMiddleRight();
				break;
			}
			else {
				autonomousCommand = new AutoMiddleLeft();
				break;
			}
		}
		
    	//autonomousCommand = (Command) chooser.getSelected();    
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
     
    	 if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {   	
        Scheduler.getInstance().run();
        
        
        /*
        if (oi.getDriver1().getRawButton(9)) {
			NetworkTable.getTable("").putString("CameraSelection", camera0.getName());
		} else if (oi.getDriver1().getRawButton(1)) {
			NetworkTable.getTable("").putString("CameraSelection", camera1.getName());
		}
		*/
	}
	
    }

