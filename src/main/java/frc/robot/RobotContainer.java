// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants.ControllerConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Auto;
import frc.robot.commands.BumpDown;
import frc.robot.commands.BumpUp;
import frc.robot.commands.ClawClosed;
import frc.robot.commands.ClawOpen;
import frc.robot.commands.DecreaseLift;
import frc.robot.commands.IncreaseLift;
import frc.robot.commands.WristDown;
import frc.robot.commands.WristUp;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Wrist;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_drivetrian = new DriveTrain();
  private final Camera m_camera = new Camera();
  private final Claw m_claw = new Claw();
  private final Lift m_lift = new Lift();
  private final Wrist m_wrist = new Wrist();

  private final XboxController m_driverController = new XboxController(ControllerConstants.m_driverController);

  private final Auto m_auto = new Auto(m_drivetrian);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drivetrian.setDefaultCommand(new ArcadeDrive(m_drivetrian, ()-> m_driverController.getLeftY(),()-> m_driverController.getLeftX()));

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton m_increaseIndexButton = new JoystickButton(m_driverController, ControllerConstants.increaseIndexButton);
    JoystickButton m_decreaseIndexButton = new JoystickButton(m_driverController, ControllerConstants.decreaseIndexButton);
    JoystickButton m_openClawButton = new JoystickButton(m_driverController, ControllerConstants.openClawButton);    
    JoystickButton m_closeClawButton = new JoystickButton(m_driverController, ControllerConstants.closeClawButton);
    JoystickButton m_bumpUpButton = new JoystickButton(m_driverController, ControllerConstants.bumpUpButtom);
    JoystickButton m_bumpDownButton = new JoystickButton(m_driverController, ControllerConstants.bumpDownButton);
    POVButton m_wristUpButton = new POVButton(m_driverController, 180);
    POVButton m_wristDownButton = new POVButton(m_driverController, 0);

    //Lift
    m_increaseIndexButton.whenPressed(new IncreaseLift(m_lift));
    m_decreaseIndexButton.whenPressed(new DecreaseLift(m_lift));
    m_bumpUpButton.whileHeld(new BumpUp(m_lift));
    m_bumpDownButton.whileHeld(new BumpDown(m_lift));

    //Wrist
    m_wristUpButton.whileHeld(new WristUp(m_wrist));
    m_wristDownButton.whileHeld(new WristDown(m_wrist));

    //Claw
    m_openClawButton.whenPressed(new ClawOpen(m_claw));
    m_closeClawButton.whenPressed(new ClawClosed(m_claw));
  }


  public Command getAutonomousCommand() {
    return m_auto;
 }
}
