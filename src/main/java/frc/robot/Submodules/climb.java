package frc.robot.Submodules;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class climb {
    public static VictorSPX elevator = new VictorSPX(5);
    public static SpeedControllerGroup lifter = new SpeedControllerGroup((SpeedController) elevator);
    public static void lift() {
        while(sticks.stick1.getRawButtonPressed(1) && sticks.stick1.getRawButtonPressed(3)) {
            lifter.set(1);
        }
    }
}
