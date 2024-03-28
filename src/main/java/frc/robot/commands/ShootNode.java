// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

public class ShootNode extends Command {

  private final Shooter shooter;
  private final XboxController controller;
  private final Timer timer = new Timer();
  private boolean isPositiveSpeed = true;

  /** Creates a new ShootNode. */
  public ShootNode(Shooter shooter, XboxController controller) {
    this.shooter = shooter;
    this.controller = controller;
    addRequirements(shooter);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //shooter.spinMotor();
   // timer.reset();
   // timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (controller.getAButton()) {
      isPositiveSpeed = true;
      shooter.spinMotor(); // Set motor speed to positive
  } else if (controller.getBButton()) {
      isPositiveSpeed = false;
      shooter.setMotorSpeedToNegativeOne(); // Set motor speed to -1
  }
    
    
    
    
    //if (timer.get()>= 3.0){
     // shooter.stopMotor();
      //timer.stop();
    //}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
    //return timer.get() >= 3.0;
  }
}
