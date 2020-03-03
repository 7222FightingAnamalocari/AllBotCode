package frc.robot.Submodules;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class loader {
    private static Spark lIntake = new Spark(2);
    private static Spark rIntake = new Spark(1);

    static SpeedControllerGroup loader = new SpeedControllerGroup(lIntake, rIntake);

    public static void runLoader() {
        while(sticks.stick0.getRawButtonPressed(1)) {
            loader.set(.5);
        }
        while(sticks.stick0.getRawButtonReleased(1)) {
            loader.set(0);
        }
    }
}
