/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Submodules.arms;
import frc.robot.Submodules.driveTrain;
import frc.robot.Submodules.loader;

import static frc.robot.Submodules.driveTrain.*;

public class Robot extends TimedRobot
{
    private static final String DEFAULT_AUTO = "Default";
    private static final String CUSTOM_AUTO = "My Auto";
    private static final String RIGHT_AUTO = "Turn Right";
    private static final String TEST_AUTON = "Forward";
    private String autoSelected;
    private final SendableChooser<String> chooser = new SendableChooser<>();

    public static boolean inTeleop = false;

    @Override
    public void robotInit() {
        driveTrain.lFrontT.addChild(lBackV);
        driveTrain.rFrontV.addChild(rBackT);
        chooser.setDefaultOption("Default Auto", DEFAULT_AUTO);
        chooser.addOption("My Auto", CUSTOM_AUTO);
        chooser.addOption("Turn Right", RIGHT_AUTO);
        chooser.addOption("Forward", TEST_AUTON);
        SmartDashboard.putData("Auto choices", chooser);

        arms.leftArm.setInverted(true);
        //HashSet<String> keys = SmartDashboard.getKeys();

        //Set<String> keys = SmartDashboard.getKeys();
        //String instructions = Arrays.toString(keys.toArray());
        //Parser.doAuton(instructions);
    }

    @Override
    public void robotPeriodic() {
        SmartDashboard.updateValues();
    }

    @Override
    public void autonomousInit() {
        Auton.timer.start();
        autoSelected = chooser.getSelected();
        // autoSelected = SmartDashboard.getString("Auto Selector",
        // defaultAuto);
        System.out.println("Auto selected: " + autoSelected);
    }

    @Override
    public void autonomousPeriodic() {
        if(Auton.timer.get() < 5) {
            driveTrain.setDrive(.2,.2);
        } else {
            driveTrain.halt();
        }
        /*switch (autoSelected) {
            case CUSTOM_AUTO:
                break;
            case DEFAULT_AUTO:
            default:
                Auton.straight(1);
                break;
            case RIGHT_AUTO:
                Auton.turnRight();
                break;
            case TEST_AUTON:
                Auton.straight(1);
                break;
        }*/
    }

    @Override
    public void disabledInit() {
        super.disabledInit();
        inTeleop=false;
    }

    @Override
    public void teleopInit() {
        teleopPeriodic();
        inTeleop = true;
        driveTrain.setDrive(0,0);
        Auton.timer.stop();
    }

    @Override
    public void teleopPeriodic() {
        loader.runLoader();
        frc.robot.Submodules.climb.lift();
        driveTrain.drive();
    }
}
