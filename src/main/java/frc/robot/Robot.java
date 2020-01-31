/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  int joystick_ = 0;
  Joystick joystick = new Joystick(joystick_);
  Spark m_RF = new Spark(3);
  Spark m_LF = new Spark(0);
  Spark m_RR = new Spark(2);
  Spark m_LR = new Spark(1);
  Spark m_test = new Spark(4);

  Servo mServo = new Servo(5);

  SpeedControllerGroup right = new SpeedControllerGroup(m_RF, m_RR);
  SpeedControllerGroup left = new SpeedControllerGroup(m_LF, m_LR);

  DifferentialDrive drive = new DifferentialDrive(left, right);


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    new Thread(() -> {
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
      camera.setResolution(320, 240);

      CvSink cvSink = CameraServer.getInstance().getVideo();
      CvSource outputStream = CameraServer.getInstance().putVideo("cam0", 320, 240);

      Mat source = new Mat();
      Mat output = new Mat();
      while (!Thread.interrupted()) {
        cvSink.grabFrame(source);
        Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
        outputStream.putFrame(output);
      }
    });
       right.setInverted(true);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
       switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here

        left.set(-.5);
        right.set(-.5);
        wait(5000);
        left.set(0);
        right.set(0);
        wait(5000);
      

        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }



  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
     
   drive.arcadeDrive(joystick.getRawAxis(0), joystick.getRawAxis(1));
   while(joystick.getRawButtonPressed(5)){
  m_test.set(1);
  }
  if(joystick.getRawButtonReleased(5)) {
   m_test.set(0);
  }
  while(joystick.getRawButtonPressed(3)){
    m_test.set(-1);
  }if(joystick.getRawButtonReleased(3)){
    m_test.set(0);
  }
  while(joystick.getRawButtonPressed(6)){
    mServo.set(0.5);
  }
  while(joystick.getRawButtonPressed(4)){
    mServo.set(0.1);
  }
  

}
  

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
