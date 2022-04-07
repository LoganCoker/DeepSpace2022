// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  private VictorSP m_leftArmMotor;
  private VictorSP m_rightArmMotor;
  private AnalogPotentiometer m_leftAnalogPotentiometer;
  private AnalogPotentiometer m_rightAnalogPotentiometer;
  private PIDController m_leftPIDController;
  private PIDController m_rightPIDController;
  /** Creates a new Lift. */
  public Lift() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
