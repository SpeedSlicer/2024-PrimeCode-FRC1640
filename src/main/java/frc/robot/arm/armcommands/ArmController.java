package frc.robot.arm.armcommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.arm.ArmSubsystem;

public class ArmController extends Command{
    ArmSubsystem armSubsystem;
    double rotationSpeed = 1;
    XboxController controller;
    public ArmController(ArmSubsystem armSubsystem, XboxController controller){
        this.armSubsystem = armSubsystem;
        this.controller = controller;
        addRequirements(this.armSubsystem);
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
        if(controller.getXButton()){
            rotationSpeed = 0.5;
        }
        else{
            rotationSpeed = 1;
        }
       
        
          
        if(controller.getPOV() == 0){
            System.out.println("UP");
            armSubsystem.setPosition(-1000);    
        }
        else if (controller.getPOV() == 90){
            System.out.println("RIGHT");
            armSubsystem.setPosition(-500);
        }
        else if (controller.getPOV() == 180){
            System.out.println("DOWN");
            armSubsystem.setPosition(-750);
        }
        else if (controller.getPOV() == 270){
            System.out.println("LEFT");
            armSubsystem.setPosition(-150);
        }
        else{
            armSubsystem.rotateArm((controller.getLeftTriggerAxis() - controller.getRightTriggerAxis()) * rotationSpeed, -50, -2000);
        }
        
    }

    @Override
    public void initialize() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
