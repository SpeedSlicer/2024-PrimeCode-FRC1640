package frc.robot.arm.armcommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.arm.ArmSubsystem;

public class ArmController extends Command{
    ArmSubsystem armSubsystem;
    XboxController controller;
    public ArmController(ArmSubsystem armSubsystemi, XboxController xboxC){
        armSubsystem = armSubsystemi;
        controller = xboxC;
        addRequirements(armSubsystem);
    }
    
    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public void execute() {
        /*int limitMode = armSubsystem.rotateArm(controller.getLeftTriggerAxis() - controller.getRightTriggerAxis());
        if(limitMode != 0){
            if(limitMode == 1){
                limitMode = armSubsystem.rotateArm(controller.getLeftTriggerAxis());
            }
            else if(limitMode == 2){
                limitMode = armSubsystem.rotateArm(-controller.getRightTriggerAxis());
            }
        }
        */
        armSubsystem.rotateArm(controller.getLeftTriggerAxis() - controller.getRightTriggerAxis(), -50, -2135);
        
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
