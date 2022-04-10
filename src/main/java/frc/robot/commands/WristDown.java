// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wrist;

public class WristDown extends CommandBase {
  private Wrist m_subsystem;

  public WristDown(Wrist subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);  
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.wristDown();
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.wristStop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
