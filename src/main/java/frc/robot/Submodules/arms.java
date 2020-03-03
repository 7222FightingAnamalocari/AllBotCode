package frc.robot.Submodules;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class arms {
    public static Spark leftArm = new Spark(3);
    private static Spark rightArm = new Spark(0);

    static SpeedControllerGroup arms = new SpeedControllerGroup(leftArm, rightArm);

    public static void armsUp() {
        arms.set(1);
    }

    public static void armsDown() {
        arms.set(-.5);
    }

    public static void armControl() {
        while(sticks.stick0.getRawButtonPressed(5)) {
            armsUp();
        }
        while(sticks.stick0.getRawButtonPressed(3)) {
            armsDown();
        }
        while(sticks.stick0.getRawButtonReleased(3) || sticks.stick0.getRawButtonReleased(5)) {
            arms.set(0);
        }
    }
}
