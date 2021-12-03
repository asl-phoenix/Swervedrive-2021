package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.PistonReel;
    
public class PistonReelCommand extends CommandBase {
    private PistonReel REEL;

    /**
     * Creates a new command.
     */
    public IntakeCommand(PistonReel piston_reel) {
        addRequirements(piston_reel);
        this.REEL = piston_reel;
        // Use addRequirements() here to declare subsystem dependencies.
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        REEl.PistonReel(0.1);
        REEL.pistonExtend();

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        REEL.PistonReel(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
