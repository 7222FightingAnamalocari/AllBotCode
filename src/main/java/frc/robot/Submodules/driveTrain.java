package frc.robot.Submodules;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class driveTrain {
    public WPI_VictorSPX lBackV = new WPI_VictorSPX(1);
    public WPI_TalonSRX lFrontT = new WPI_TalonSRX(2);
    public WPI_VictorSPX rFrontV = new WPI_VictorSPX(3);
    public WPI_TalonSRX rBackT = new WPI_TalonSRX(4);
    public WPI_TalonSRX intake = new WPI_TalonSRX(7);

    SpeedControllerGroup leftG = new SpeedControllerGroup(lBackV, lFrontT);
    SpeedControllerGroup rightG = new SpeedControllerGroup(rBackT, rFrontV);

    DifferentialDrive dDrive = new DifferentialDrive(rightG, leftG);

    public void drive() {
        dDrive.arcadeDrive(sticks.stick0.getY(),sticks.stick0.getX());
    }
}
