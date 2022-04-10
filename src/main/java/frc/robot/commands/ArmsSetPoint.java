// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;

public class ArmsSetPoint extends CommandBase {
  private Lift m_subsystem;
  private DoubleSupplier m_setPoint;

  public ArmsSetPoint(Lift subsystem, DoubleSupplier setPoint) {
    m_subsystem = subsystem;
    m_setPoint = setPoint;

    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.putSetPoint(m_setPoint.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return m_subsystem.isAtSetPoint();
  }
}
