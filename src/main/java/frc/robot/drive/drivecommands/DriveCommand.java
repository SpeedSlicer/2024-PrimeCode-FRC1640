package frc.robot.drive.drivecommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.drive.DriveSubsystem;

public class DriveCommand extends Command{
    DriveSubsystem driveSubsystem;
    XboxController controller;
    
    public DriveCommand(DriveSubsystem driveSubsystemi, XboxController xboxC){
        driveSubsystem = driveSubsystemi;
        controller = xboxC;
        addRequirements(driveSubsystem);
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public void execute() {
        driveSubsystem.drive(controller.getLeftY(), controller.getRightY());

    }

    @Override
    public void initialize() {
        driveSubsystem.drive(0,0);

    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}
