// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClawConstants;

public class Claw extends SubsystemBase {
  private Servo m_clawMotor;
  /** Creates a new Claw. */
  public Claw() {
    m_clawMotor = new Servo(ClawConstants.m_servoMotor);
  }

  public void clawOpen() {
    m_clawMotor.set(ClawConstants.clawOpen);
  }

  public void clawClosed() {
    m_clawMotor.set(ClawConstants.clawClosed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
