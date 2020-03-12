package frc.robot.Submodules;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class loader {
    private static Spark lIntake = new Spark(2);
    private static Spark rIntake = new Spark(1);

    static SpeedControllerGroup loader = new SpeedControllerGroup(lIntake, rIntake);

    public static void runLoader() {
        lIntake.setInverted(true);
        while(sticks.stick1.getRawButtonPressed(8)) {
            loader.set(-.5);
        }
        while(sticks.stick1.getRawButtonPressed(7)) {
            loader.set(.5);
        }
        while(sticks.stick1.getRawButtonReleased(7) || sticks.stick1.getRawButtonReleased(8)) {
            loader.set(0);
        }
    }
}
