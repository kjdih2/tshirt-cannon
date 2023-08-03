// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticCompressor extends SubsystemBase {

  private final Compressor compressor;

  /** Creates a new PneumaticCompressor. */
  public PneumaticCompressor() {
    // compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    compressor = new Compressor(12, PneumaticsModuleType.CTREPCM);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void startCompressor() {

    compressor.enableDigital();

  }

  public void stopCompressor() {

    compressor.disable();

  }

}
