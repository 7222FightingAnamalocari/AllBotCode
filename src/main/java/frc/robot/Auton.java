package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Submodules.*;

public class Auton {
    public static Timer timer = new Timer();
    public static void setDrive(double leftVal, double rightVal) {
        driveTrain.leftG.set(leftVal);
        driveTrain.rightG.set(rightVal);
    }
    public static void initTimer() {
        timer.reset();
        timer.start();
    }
    public static void turnLeft() {
        initTimer();
        while(timer.get() < .2) {
            driveTrain.leftG.set(-.2);
            driveTrain.rightG.set(.2);
        }
        timer.stop();
    }
    public static void turnRight() {
        initTimer();
        while(timer.get() < .2) {
            driveTrain.rightG.set(.2);
            driveTrain.leftG.set(-.2);
        }
        timer.stop();
    }
    public static void straight(double botLengths) {
        initTimer();
        while(timer.get() < .5*botLengths) {
            driveTrain.leftG.set(.2);
            driveTrain.rightG.set(.2);
        }
        while(timer.get() > .5*botLengths) {
            driveTrain.rightG.set(0);
            driveTrain.leftG.set(0);
        }
        timer.stop();
    }
}
