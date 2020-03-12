package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Submodules.*;

public class Auton {
    public static Timer timer = new Timer();

    public static void initTimer() {
        timer.reset();
    }

    public static void turnLeft() {
        initTimer();
        if(timer.get() < .2) {
            driveTrain.setDrive(-.5,-.5);
        } else {
            driveTrain.halt();
        }
    }
    public static void turnRight() {
        initTimer();
        if(timer.get() < .2) {
            driveTrain.setDrive(.5,.5);
        } else {
            driveTrain.halt();
        }
    }
    public static void straight(double botLengths) {
        initTimer();
        if(timer.get() < .5*botLengths) {
            driveTrain.setDrive(.6,.6);
        } else {
            driveTrain.halt();
        }
    }
}
