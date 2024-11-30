/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package frc.robot.intake.intakecommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.intake.IntakeSubsystem;
/**
 *
 * @author mathk
 */
public class IntakeControl extends Command {
    IntakeSubsystem intakeSubsystem;
    XboxController controller;
    public double rotationSpeed = 0.8;
    public IntakeControl(IntakeSubsystem intakeSubsystem1, XboxController xboxC){
        intakeSubsystem = intakeSubsystem1;
        controller = xboxC;
        addRequirements(intakeSubsystem);
    }
    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public void execute() {
        if(controller.getAButton()){
            intakeSubsystem.rotateIntake(rotationSpeed);
        }
        else if(controller.getBButton()){
            intakeSubsystem.rotateIntake(-rotationSpeed);            
        }
        else{
            intakeSubsystem.rotateIntake(0);
        }
        
    }

    @Override
    public void initialize() {
        intakeSubsystem.rotateIntake(0);

    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}
