/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gyroscope;

/**
 * COMPETITION READY
 */
public class GyroscopeCommand extends CommandBase {


  private Gyroscope gyroscope;
  private double[] ypr;
  public double yaw;

  /**
   * Creates a new ShootCommand.
   */
  public GyroscopeCommand(Gyroscope gyroscope) {
    addRequirements(gyroscope);
    this.gyroscope = gyroscope;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gyroscope.resetValues();
    gyroscope.calibrateGyro();
    gyroscope.getState();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    

    System.out.println ("Yaw: " + gyroscope.getYaw(ypr));
    yaw = (gyroscope.getYaw(ypr) % 360);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    gyroscope.resetValues();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
