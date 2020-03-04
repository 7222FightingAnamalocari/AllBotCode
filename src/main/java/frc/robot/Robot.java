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

import java.util.Arrays;
import java.util.Set;

import static frc.robot.Submodules.driveTrain.lBackV;
import static frc.robot.Submodules.driveTrain.rBackT;

/**
 * The VM is configured to automatically run this class, and to call the
 * methods corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
    double mathstuffs;
    private static final String DEFAULT_AUTO = "Default";
    private static final String CUSTOM_AUTO = "My Auto";
    private static final String RIGHT_AUTO = "Turn Right";
    private String autoSelected;
    private final SendableChooser<String> chooser = new SendableChooser<>();

    /**
     * This method is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit()
    {
        driveTrain.lFrontT.addChild(lBackV);
        driveTrain.rFrontV.addChild(rBackT);
        chooser.setDefaultOption("Default Auto", DEFAULT_AUTO);
        chooser.addOption("My Auto", CUSTOM_AUTO);
        chooser.addOption("Turn Right", RIGHT_AUTO);
        SmartDashboard.putData("Auto choices", chooser);

        arms.leftArm.setInverted(true);

        SmartDashboard.putBoolean("Intake Runnung?",true);
        //HashSet<String> keys = SmartDashboard.getKeys();

        Set<String> keys = SmartDashboard.getKeys();
        String instructions = Arrays.toString(keys.toArray());
        //Parser.doAuton(instructions);
    }
    /**
     * This method is called every robot packet, no matter the mode. Use
     * this for items like diagnostics that you want ran during disabled,
     * autonomous, teleoperated and test.
     * <p>
     * This runs after the mode specific periodic methods, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        SmartDashboard.updateValues();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString line to get the auto name from the text box below the Gyro
     * <p>
     * You can add additional auto modes by adding additional comparisons to
     * the switch structure below with additional strings. If using the
     * SendableChooser make sure to add them to the chooser code above as well.
     */
    @Override
    public void autonomousInit()
    {
        autoSelected = chooser.getSelected();
        // autoSelected = SmartDashboard.getString("Auto Selector",
        // defaultAuto);
        System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This method is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic()
    {
        switch (autoSelected)
        {
            case CUSTOM_AUTO:
                Auton.turnLeft();
                Auton.straight(1);
                Auton.turnLeft();
                Auton.straight(1);
                Auton.turnLeft();
                Auton.straight(1);
                Auton.turnLeft();
                Auton.straight(1);
                break;
            case DEFAULT_AUTO:
            default:
                Auton.straight(1);
                break;
            case RIGHT_AUTO:
                Auton.turnRight();
                break;
        }



    }

    @Override
    public void teleopInit() {
        super.teleopInit();
    }

    /**
     * This method is called periodically during operator control.
     */

    @Override
    public void teleopPeriodic() {
        loader.runLoader();
        //arms.armControl();
        driveTrain.drive();
        frc.robot.Submodules.climb.lift();
    }

    /**
     * This method is called periodically during test mode.
     */
    @Override
    public void testPeriodic()
    {
    }
}
