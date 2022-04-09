// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  private DriveTrain m_subsystem;
  private DoubleSupplier m_speed;
  private DoubleSupplier m_rotation;

  public ArcadeDrive(DriveTrain subsystem, DoubleSupplier speed, DoubleSupplier rotation) {
    m_subsystem = subsystem;
    m_speed = speed;
    m_rotation = rotation;

    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.arcadeDrive(m_speed.getAsDouble(), m_rotation.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.arcadeDrive(0.0, 0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
