package frc.robot;

import edu.wpi.first.math.geometry.Transform3d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double TANK_DRIVE_SLOW_FACTOR = 0.25;
    public static final int PCM_CAN_ID = 12;
    
    public static final int SOLENOID_1 = 1;
    public static final int SOLENOID_2 = 2;
    public static final int SOLENOID_3 = 3;
    public static final int SOLENOID_4 = 4;
    public static final int SOLENOID_5 = 5;
    public static final int SOLENOID_6 = 6;

    public static class MotorID {
        // TODO: Find motor ports
        public static final int LEFT_DRIVE_1 = 1;
        public static final int LEFT_DRIVE_2 = 2;
        public static final int RIGHT_DRIVE_1 = 3;
        public static final int RIGHT_DRIVE_2 = 4;
        public static final int ARM = 5;
        public static final int CLAMP = 6;
    }

    public static class DriveTrain {
        public static final double MIN_MOTOR_OUTPUT = 0.3;
    }
}
