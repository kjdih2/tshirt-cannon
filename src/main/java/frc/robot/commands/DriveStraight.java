// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Utils;
import frc.robot.subsystems.DriveTrain;

public class DriveStraight extends CommandBase {

  private final DriveTrain driveTrain;
  private final DoubleSupplier right;
  private final DoubleSupplier left;

  /** Creates a new DriveStraight. */
  public DriveStraight(DriveTrain driveTrain, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.left = leftSupplier;
    this.right = rightSupplier;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.tankDrive(
      Utils.deadzone(left.getAsDouble(), 0.05),
      Utils.deadzone(-left.getAsDouble(), 0.05),
      0.1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
