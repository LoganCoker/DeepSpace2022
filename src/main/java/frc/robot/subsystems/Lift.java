// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LiftConstants;
import frc.robot.Constants.UniversalConstants;

public class Lift extends SubsystemBase {
  private VictorSP m_leftArmMotor;
  private VictorSP m_rightArmMotor;
  private AnalogPotentiometer m_leftAnalogPotentiometer;
  private AnalogPotentiometer m_rightAnalogPotentiometer;
  private PIDController m_leftPIDController;
  private PIDController m_rightPIDController;
  /** Creates a new Lift. */
  public Lift() {
    m_leftArmMotor = new VictorSP(LiftConstants.m_leftArmMotor);
    m_rightArmMotor = new VictorSP(LiftConstants.m_rightArmMotor);

    m_leftAnalogPotentiometer = new AnalogPotentiometer(LiftConstants.m_leftAnalogPotentiometer);
    m_rightAnalogPotentiometer = new AnalogPotentiometer(LiftConstants.m_rightAnalogPotentiometer);

    m_leftPIDController = new PIDController(UniversalConstants.armsP, UniversalConstants.armsI, UniversalConstants.armsD);
    m_rightPIDController = new PIDController(UniversalConstants.armsP, UniversalConstants.armsI, UniversalConstants.armsD);
  }

  public void putSetPoint(DoubleSupplier m_setPoint) {

  }

  public void syncRight() {
    
  }

  public void stop() {
    m_leftArmMotor.set(UniversalConstants.stopSpeed);
    m_rightArmMotor.set(UniversalConstants.stopSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
