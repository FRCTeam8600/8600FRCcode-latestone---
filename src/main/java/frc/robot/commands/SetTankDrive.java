// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class SetTankDrive extends Command {
  /** Creates a new SetTankDrive. */
  public SetTankDrive() {
    addRequirements(RobotContainer.m_driveTrain);
    // Unse addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
    double rightStickY = RobotContainer.GetDriverRawAxis(Constants.RIGHT_STICK_Y);
    double leftStickY = RobotContainer.GetDriverRawAxis(Constants.LEFT_STICK_Y);
    RobotContainer.m_driveTrain.setLeftMotors(leftStickY);
    RobotContainer.m_driveTrain.setRightMotors(rightStickY);
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveTrain.setLeftMotors(0);
    RobotContainer.m_driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
