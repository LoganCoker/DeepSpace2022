// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
  private VictorSP m_frontLeftMotor;
  private VictorSP m_backLeftMotor;
  private MotorControllerGroup m_leftDrive;
  private VictorSP m_frontRightMotor;
  private VictorSP m_backRightMotor;
  private MotorControllerGroup m_rightDrive;
  private DifferentialDrive m_driveTrain;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    m_frontLeftMotor = new VictorSP(DriveTrainConstants.m_frontLeftMotor);
    m_backLeftMotor = new VictorSP(DriveTrainConstants.m_backLeftMotor);
    m_leftDrive = new MotorControllerGroup(m_frontLeftMotor, m_backLeftMotor);

    m_frontRightMotor = new VictorSP(DriveTrainConstants.m_frontRightMotor);
    m_backRightMotor = new VictorSP(DriveTrainConstants.m_backRightMotor);
    m_rightDrive = new MotorControllerGroup(m_frontRightMotor, m_backRightMotor);
    m_rightDrive.setInverted(true);

    m_driveTrain = new DifferentialDrive(m_leftDrive, m_rightDrive);
  }

  public void arcadeDrive() {
    m_driveTrain.arcadeDrive(DriveTrainConstants.speed, DriveTrainConstants.rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
