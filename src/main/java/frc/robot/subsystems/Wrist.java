// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.UniversalConstants;
import frc.robot.Constants.WristConstants;

public class Wrist extends SubsystemBase {
  private VictorSP m_wristMotor;

  public Wrist() {
    m_wristMotor = new VictorSP(WristConstants.m_wristMotor);
  }

  public void wristUp() {
    m_wristMotor.set(WristConstants.wristUp);
  }

  public void wristDown() {
    m_wristMotor.set(WristConstants.wristDown);
  }

  public void wristStop() {
    m_wristMotor.set(UniversalConstants.stopSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
