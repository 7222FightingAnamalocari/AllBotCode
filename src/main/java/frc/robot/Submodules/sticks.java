package frc.robot.Submodules;

import edu.wpi.first.wpilibj.Joystick;

public class sticks {
    static class stick0 {
        public static Joystick stick = new Joystick(0);
        public static double getX() {
            return stick.getX();
        }
        public static double getY() {
            return stick.getY();
        }
    }
}
