package frc.robot.Submodules;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class climb {
    public static Spark elevator = new Spark(5);
    public static WPI_VictorSPX lifter = new WPI_VictorSPX(5);
    //public static SpeedControllerGroup elevator = new SpeedControllerGroup(down,up);
    public static void lift() {
        lifter.setInverted(true);
        while(sticks.stick1.getRawButtonPressed(4)) {
            elevator.set(1);
        }
        while(sticks.stick1.getRawButtonPressed(2)) {
            elevator.set(-.7);
        }
        while(sticks.stick1.getRawButtonReleased(4) || sticks.stick1.getRawButtonReleased(2)) {
            elevator.set(0);
        }
        while(sticks.stick1.getRawButtonPressed(12)) {
            lifter.set(1);
        }
        while(sticks.stick1.getRawButtonReleased(12)) {
            lifter.set(0);
        }
    }
}
