// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Shooter extends SubsystemBase {

  private TalonSRX ShooterMotor1;
  private TalonSRX ShooterMotor2;
  
  public void spinMotor (){
    ShooterMotor2.set(ControlMode.PercentOutput, -1);
    ShooterMotor1.set(ControlMode.PercentOutput, -1);
  }


  public void stopMotor(){
    ShooterMotor2.set(ControlMode.PercentOutput, 0);
    ShooterMotor1.set(ControlMode.PercentOutput, 0);
  }

  public void setMotorSpeedToNegativeOne (){
    ShooterMotor2.set(ControlMode.PercentOutput, 1);
    ShooterMotor1.set(ControlMode.PercentOutput, 1);
  }
  



  /** Creates a new Shooter. */
  public Shooter() {
    ShooterMotor2 = new TalonSRX(Constants.SHOOTER_MOTOR_2_ID);
    ShooterMotor1 = new TalonSRX(Constants.SHOOTER_MOTOR_1_ID);
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
