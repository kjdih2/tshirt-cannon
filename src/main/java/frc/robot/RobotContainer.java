package frc.robot;

import frc.robot.commands.DriveStraight;
import frc.robot.commands.FireShirt;
import frc.robot.commands.StartCompressor;
import frc.robot.commands.StopCompressor;
import frc.robot.commands.TankDriveFast;
import frc.robot.commands.TankDriveMedium;
import frc.robot.commands.TankDriveSlow;
import frc.robot.commands.TankDriveSmooth;
import frc.robot.subsystems.CannonSolenoid;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PneumaticCompressor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

    // Subsystems
    private final DriveTrain driveTrain = new DriveTrain();
    private final PneumaticCompressor compressor = new PneumaticCompressor();
    private final CannonSolenoid cannon = new CannonSolenoid();

    // Controllers
    private final XboxController driver = new XboxController(0);
    private final CommandXboxController commandDriver = new CommandXboxController(0);


    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the trigger bindings
        configureBindings();
    }


    private void configureBindings() {

        driveTrain.setDefaultCommand(new TankDriveSlow(driveTrain, () -> -driver.getLeftY(), () -> driver.getRightY()));
        commandDriver.povUp().onTrue(new DriveStraight(driveTrain, () -> -driver.getLeftY(), () -> driver.getRightY()));
        commandDriver.povDown().onTrue(new TankDriveSlow(driveTrain, () -> -driver.getLeftY(), () -> driver.getRightY()));
        commandDriver.povLeft().onTrue(new TankDriveMedium(driveTrain, () -> -driver.getLeftY(), () -> driver.getRightY()));
        commandDriver.povRight().onTrue(new TankDriveSlow(driveTrain, () -> -driver.getLeftY(), () -> -driver.getLeftY()));


        commandDriver.x().onTrue(new StartCompressor(compressor));
        commandDriver.y().onTrue(new StopCompressor(compressor));
        commandDriver.a().onTrue(new FireShirt(cannon));

    }

    public Command getAutonomousCommand() {
        // An example command will be run in autonomous
        return Commands.none();
    }
}
