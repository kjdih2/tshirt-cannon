// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticCompressor;

public class StartCompressor extends CommandBase {

  private final PneumaticCompressor compressor;

  /** Creates a new StartCompressor. */
  public StartCompressor(PneumaticCompressor compressor) {

    this.compressor = compressor;
    addRequirements(compressor);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    compressor.startCompressor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    compressor.startCompressor();
    return true;
  }
}
