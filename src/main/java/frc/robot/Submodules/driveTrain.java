package frc.robot.Submodules;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Auton;

public class driveTrain {

    private static Joystick stick0 = new Joystick(0);
    public static WPI_VictorSPX lBackV = new WPI_VictorSPX(1);
    public static WPI_TalonSRX lFrontT = new WPI_TalonSRX(2);
    public static WPI_VictorSPX rFrontV = new WPI_VictorSPX(3);
    public static WPI_TalonSRX rBackT = new WPI_TalonSRX(4);
    private static double yaxis;

    public static SpeedControllerGroup leftG = new SpeedControllerGroup(lBackV, lFrontT);
    public static SpeedControllerGroup rightG = new SpeedControllerGroup(rBackT, rFrontV);

    public static DifferentialDrive dDrive = new DifferentialDrive(rightG, leftG);

    public static void drive() {
        dDrive.arcadeDrive(stick0.getRawAxis(1)*-1,stick0.getRawAxis(0));
    }

    public static void setDrive(double leftVal, double rightVal) {
        leftG.set(leftVal*-1);
        rightG.set(rightVal);
    }

    public static void halt() {
        setDrive(0,0);
    }
}
