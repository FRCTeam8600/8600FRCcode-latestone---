// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

/** An example command that uses an example subsystem. */
public class SetTankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private DriveTrain drivetrainSubsystem;
  private ShooterSubsystem shooterSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveTrain  The Drivetrain used by this command.
   */
  public SetTankDrive(DriveTrain drivetrainSubsystem, ShooterSubsystem shooterSubsystem) {
     this.drivetrainSubsystem = drivetrainSubsystem;
     this.shooterSubsystem = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
         double forwardSpeed = RobotContainer.joystick.getLeftY();
         double turningSpeed = RobotContainer.joystick.getRightX();
         drivetrainSubsystem.arcadeDrive(forwardSpeed, turningSpeed);

         if (RobotContainer.joystick.getXButtonPressed()) {
             drivetrainSubsystem.setSpeedFactor(1);
         } else if (RobotContainer.joystick.getYButtonPressed()) {
             drivetrainSubsystem.setSpeedFactor(0.5f);
         }


         double shootState = RobotContainer.joystick.getRightTriggerAxis();
         shooterSubsystem.setRamp(shootState > 0.1 /* debounce */);
         if (shootState > 0.9) {
           shooterSubsystem.trigger();
         }

          double shootState2 = RobotContainer.joystick.getLeftTriggerAxis();
          if (shootState2 > 0.1) {
              shooterSubsystem.load(-shootState2);
          } else {
              shooterSubsystem.load(0);
          }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
