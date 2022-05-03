// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class ControllerConstants {
        public static final int m_driverController = 0;
        public static final int bumpUpButtom = XboxController.Button.kRightBumper.value;
        public static final int bumpDownButton = XboxController.Button.kLeftBumper.value;
        public static final int increaseIndexButton = XboxController.Button.kB.value;
        public static final int decreaseIndexButton = XboxController.Button.kA.value;
        public static final int openClawButton = XboxController.Button.kY.value;
        public static final int closeClawButton = XboxController.Button.kX.value;
        public static final int manualLift = XboxController.Button.kRightStick.value;
    }
    
    
    public static final class DrivetrainConstants {
        public static final int m_frontLeftMotor = 0;
        public static final int m_frontRightMotor = 2;
        public static final int m_backLeftMotor = 1;
        public static final int m_backRightMotor = 3;
        public static final double speed = 0.5;
        public static final double rotation = 0.5;
    }

    public static final class ClawConstants {
        public static final int m_servoMotor = 6;
        public static final double clawOpen = 0.2;
        public static final double clawClosed = 0.8;
    }
    
    public static final class LiftConstants {
        public static final int m_leftArmMotor = 5;
        public static final int m_rightArmMotor = 4;
        public static final int m_leftAnalogPotentiometer = 1;
        public static final int m_rightAnalogPotentiometer = 0;
        public static final double liftPIDTolorence = 0.5;
        public static final double[] liftArray = {19.0, 22.0, 33.0, 50.0, 60.0, 80.0, 93.0};
        public static final double m_scalingFactor = 116.5;
        public static final double m_offSet = 5;
    }

    public static final class WristConstants {
        public static final int m_wristMotor = 7;
        public static final double wristUp = 0.6;
        public static final double wristDown = -0.6;
    }

    public static final class UniversalConstants {
        public static final double stopSpeed = 0.0;
        public static final double armsP = 1.0;
        public static final double armsI = 0.0;
        public static final double armsD = 0.0; 
    }
}
