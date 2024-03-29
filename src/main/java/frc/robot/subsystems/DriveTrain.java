// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonSRXSimCollection;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;



public class DriveTrain extends SubsystemBase {
WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(Constants.leftFrontMotorId);
WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(Constants.leftBackMotorId);
WPI_TalonSRX rightFrontMotor =  new WPI_TalonSRX(Constants.rightFrontMotorId);
WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(Constants.rightBackMotorId);

MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

private float speedFactor = 1;


    /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
  
  leftFrontMotor.configFactoryDefault();
  leftBackMotor.configFactoryDefault();
  rightFrontMotor.configFactoryDefault();
  rightBackMotor.configFactoryDefault();
    
  leftFrontMotor.setNeutralMode(NeutralMode.Brake);
  leftBackMotor.setNeutralMode(NeutralMode.Brake);
  rightFrontMotor.setNeutralMode(NeutralMode.Brake);
  rightBackMotor.setNeutralMode(NeutralMode.Brake);

  leftBackMotor.follow(leftFrontMotor);
  rightBackMotor.follow(rightFrontMotor);

  rightControllerGroup.setInverted(true);
  leftControllerGroup.setInverted(false); 
      //motor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 13, 13, 0.1));
  }
     /** tell motors */

     public void setSpeedFactor(float factor) {
       speedFactor = factor;
     }
  
   public void arcadeDrive(double fwd, double rot) {
    differentialDrive.arcadeDrive(fwd * speedFactor, rot * speedFactor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

/*
  @Override
  public void teleopPeriodic(){

    DriveTrain.arcadeDrive(-driveStick.getY(), driveStick.getX());

  }
*/
}