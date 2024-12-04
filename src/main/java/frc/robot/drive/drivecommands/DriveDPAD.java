package frc.robot.drive.drivecommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.drive.DriveSubsystem;

public class DriveDPAD extends Command{
    //if you want this just click Y
    DriveSubsystem driveSubsystem;
    XboxController controller;
    
    public DriveDPAD(DriveSubsystem driveSubsystemi, XboxController xboxC){
        driveSubsystem = driveSubsystemi;
        controller = xboxC;
        addRequirements(driveSubsystem);
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public void execute() {

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
