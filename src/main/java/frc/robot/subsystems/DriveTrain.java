// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

   private TalonSRX motorLeft1;
   private TalonSRX motorLeft2;
   private TalonSRX motorRight1;
   private TalonSRX motorRight2;
    
  public void setLeftMotors (double speed){
//invert o
    motorLeft1.setInverted(true);
    motorLeft2.setInverted(true);
    
    motorLeft1.set(ControlMode.PercentOutput, speed);
    motorLeft2.set(ControlMode.PercentOutput, speed);
  }

  public void setRightMotors (double speed){
    motorRight1.set(ControlMode.PercentOutput, speed);
    motorRight2.set(ControlMode.PercentOutput, speed);
  }

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    motorLeft1 = new TalonSRX(Constants.MOTOR_LEFT_1_ID);
    motorLeft2 = new TalonSRX(Constants.MOTOR_LEFT_2_ID);
    motorRight1 = new TalonSRX(Constants.MOTOR_RIGHT_1_ID);
    motorRight2 = new TalonSRX(Constants.MOTOR_RIGHT_2_ID);
  }





  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
