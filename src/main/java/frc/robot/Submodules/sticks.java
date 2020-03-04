package frc.robot.Submodules;

import edu.wpi.first.wpilibj.Joystick;

public class sticks {
    public static Joystick stick0 = new Joystick(0);
    static class stick0 {

        public static Joystick stick = stick0;
        public static double getX() {
            return stick.getX();
        }
        public static double getY() {
            return stick.getY();
        }
    }
    public static Joystick stick1 = new Joystick(1);
    static class stick1 {
        public static Joystick stick = stick1;
        public static double getX() {
            return stick.getX();
        }
        public static double getY() {
            return stick.getY();
        }
    }
}
