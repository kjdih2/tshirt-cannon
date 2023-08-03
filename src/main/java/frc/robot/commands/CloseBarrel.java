// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CannonSolenoid;

public class CloseBarrel extends CommandBase {

  private final CannonSolenoid cannon;

  /** Creates a new CloseBarrel. */
  public CloseBarrel(CannonSolenoid cannon) {
    this.cannon = cannon;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(cannon);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    cannon.closeCurrent();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    cannon.closeCurrent();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !cannon.isOpen();
  }
}
