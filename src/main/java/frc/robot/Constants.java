// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveTrainConstants {
        public static final int m_frontLeftMotor = 0;
        public static final int m_frontRightMotor = 1;
        public static final int m_backLeftMotor = 2;
        public static final int m_backRightMotor = 3;
        public static final double speed = 0.5;
        public static final double rotation = 0.5;
    }

    public static final class ClawConstants {
        public static final int m_servoMotor = 4;
        public static final double clawOpen = 0.2;
        public static final double clawClosed = 0.8;
    }

    public static final class CameraConstants {

    }

    public static final class LiftConstants {

    }

    public static final class WristConstants {
        public static final int m_wristMotor = 5;
    }
}
