// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CannonSolenoid extends SubsystemBase {


  private final ArrayList<Solenoid> solenoids;
  private int activeBarrel = 0;


  /** Creates a new CannonSolenoid. */
  public CannonSolenoid() {

    solenoids = new ArrayList<>();

    solenoids.add(new Solenoid(12, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_1));
    solenoids.add(new Solenoid(12, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_2));
    solenoids.add(new Solenoid(12, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_3));
    solenoids.add(new Solenoid(12, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_4));
    solenoids.add(new Solenoid(12, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_5));
    solenoids.add(new Solenoid(12, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_6));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Active Barrel", activeBarrel);
  }


  public void openCurrent() {

    solenoids.get(activeBarrel).set(true);
    
  }

  public void closeCurrent() {

    solenoids.get(activeBarrel).set(false);

  }

  public void rotateBarrel() {

    if (activeBarrel == 5) {
      activeBarrel = 0;
    } else {
      activeBarrel = activeBarrel + 1;
    }

    SmartDashboard.putNumber("Active Barrel", activeBarrel);

  }

  public boolean isOpen() {
    return solenoids.get(activeBarrel).get();
  }

}
