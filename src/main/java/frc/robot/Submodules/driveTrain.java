package frc.robot.Submodules;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.robot.Submodules.sticks.stick0.stick;

public class driveTrain {
    public static WPI_VictorSPX lBackV = new WPI_VictorSPX(1);
    public static WPI_TalonSRX lFrontT = new WPI_TalonSRX(2);
    public static WPI_VictorSPX rFrontV = new WPI_VictorSPX(3);
    public static WPI_TalonSRX rBackT = new WPI_TalonSRX(4);

    public static SpeedControllerGroup leftG = new SpeedControllerGroup(lBackV, lFrontT);
    public static SpeedControllerGroup rightG = new SpeedControllerGroup(rBackT, rFrontV);

    public static DifferentialDrive dDrive = new DifferentialDrive(rightG, leftG);

    static int mathstuffs = 1;

    /*public static void invertdrive() {
        if(stick.getRawAxis(3) > 0) {
            mathstuffs = 1;
        } else {
            mathstuffs = -1;
        }
    }*/

    public static void drive() {
        //invertdrive();
        dDrive.arcadeDrive(sticks.stick0.getY()*mathstuffs,sticks.stick0.getX());
    }
}
