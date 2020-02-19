package frc.robot.Submodules;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class arms {
    private Spark leftArm = new Spark(3);
    private Spark rightArm = new Spark(0);

    SpeedControllerGroup arms = new SpeedControllerGroup(leftArm, rightArm);

    public void armsUp() {
        arms.set(1);
    }

    public void armsDown() {
        arms.set(-.5);
    }
}
