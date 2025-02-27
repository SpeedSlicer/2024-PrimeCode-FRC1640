package frc.robot.drive.drivecommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.drive.DriveSubsystem;

public class DriveArcade extends Command {
    DriveSubsystem driveSubsystem;
    XboxController controller;
    Boolean tankDrive = false;

    public DriveArcade(DriveSubsystem driveSubsystemi, XboxController xboxC) {
        driveSubsystem = driveSubsystemi;
        controller = xboxC;
        addRequirements(driveSubsystem);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public void execute() {
        if(controller.getYButtonPressed()){
            if(tankDrive == false){
                tankDrive = true;
            }
            else{
                tankDrive = false;
            }
        }
        double baseSpeed = 0.7;
        double rotateSpeed = 0.3;
        double rotateNum = 0;
        if (tankDrive == false) {
            if (controller.getRightBumper()) {
                baseSpeed = 0.8;
                rotateSpeed = 0.2;
            } else if (controller.getLeftBumper()) {
                baseSpeed = 0.4;
                rotateSpeed = 0.6;
            } else if (controller.getRightStickButton()) {
                baseSpeed = 0;
                rotateSpeed = 1;
            } else {
                baseSpeed = 0.7;
                rotateSpeed = 0.3;
            }
            if (Math.abs(controller.getRightX()) <= 0.05) {
                rotateNum = 0;
            } else {
                rotateNum = controller.getRightX();
            }
            if (baseSpeed + rotateSpeed <= 1 && baseSpeed >= -1) {

            } else {
                System.out.println("Something is VERY wrong. BaseSpeed and RotateSpeed greater than 1");
            }
            driveSubsystem.drive((baseSpeed * controller.getLeftY()) - (rotateSpeed * rotateNum),
                    (baseSpeed * controller.getLeftY()) + (rotateSpeed * rotateNum));
        } 
        else if(tankDrive) {
            driveSubsystem.drive(controller.getLeftY(), controller.getRightY());
        }
        else{
            System.out.println("WHAT THE- HOW DID YOU EVEN");
        }
             
    }

    @Override
    public void initialize() {
        driveSubsystem.drive(0, 0);
        driveSubsystem.modifySpeed(0.8);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
