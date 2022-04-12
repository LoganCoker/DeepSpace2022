// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  private double m_setPoint;
  private double[] m_liftArray;
  private int m_lastIndex;

  public Lift() {
    m_leftArmMotor = new VictorSP(LiftConstants.m_leftArmMotor);
    m_rightArmMotor = new VictorSP(LiftConstants.m_rightArmMotor);

    m_leftAnalogPotentiometer = new AnalogPotentiometer(LiftConstants.m_leftAnalogPotentiometer);
    m_rightAnalogPotentiometer = new AnalogPotentiometer(LiftConstants.m_rightAnalogPotentiometer);

    m_leftPIDController = new PIDController(UniversalConstants.armsP, UniversalConstants.armsI, UniversalConstants.armsD);
    m_rightPIDController = new PIDController(UniversalConstants.armsP, UniversalConstants.armsI, UniversalConstants.armsD);

    m_liftArray = LiftConstants.liftArray;
    m_lastIndex = 0;
  }

  public void putSetPoint(Double setPoint) {
    m_leftPIDController.setSetpoint(setPoint);
    setPoint = m_setPoint;
    syncRight();
  }

  public void syncRight() {
    m_rightPIDController.setSetpoint(m_leftAnalogPotentiometer.get());
  }

  public boolean isAtSetPoint() {
    return (Math.abs(m_setPoint - m_leftAnalogPotentiometer.get()) <= LiftConstants.liftPIDTolorence);
  }

  public int incramentIndex(){
    if (m_lastIndex < m_liftArray.length - 1) {
      m_lastIndex++;
    }
    return m_lastIndex;
  }

  public int decramentIndex(){
    if (m_lastIndex > 0){
      m_lastIndex--;
    }
    return m_lastIndex;
  }

  public void incramentSetPoint(){
    m_leftPIDController.setSetpoint(m_leftPIDController.getSetpoint() + 1);
    if (m_leftPIDController.getSetpoint() >= m_liftArray[m_lastIndex + 1]) {
      if (m_lastIndex < m_liftArray.length - 1) {
        m_lastIndex++;
      }
    }
  }

  public void decramentSetPoint(){
    m_leftPIDController.setSetpoint(m_leftPIDController.getSetpoint() - 4);
    if (m_leftPIDController.getSetpoint() <= m_liftArray[m_lastIndex - 1]) {
      if (m_lastIndex > 0) {
        m_lastIndex--;
      }
    }
  }

  public void stop() {
    m_leftArmMotor.set(UniversalConstants.stopSpeed);
    m_rightArmMotor.set(UniversalConstants.stopSpeed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Arm Potition", m_leftAnalogPotentiometer.get());
    SmartDashboard.putNumber("Right Arm Potition", m_rightAnalogPotentiometer.get());
    SmartDashboard.putBoolean("Arms Set Point", isAtSetPoint());
  }
}
