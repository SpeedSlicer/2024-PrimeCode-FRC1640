/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package frc.robot.arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 *
 * @author mathk
 */
public class ArmSubsystem extends SubsystemBase{
    TalonSRX armMotor = new TalonSRX(10);
    double rotateSpeed = 0.6;
    PIDController armPid = new PIDController(0.001, 0, 0);

    double baseValue = 0;
    
    public ArmSubsystem(){
        baseValue = armMotor.getSelectedSensorPosition();
        armPid.reset();
    }
    public void rotateArm(double armRotation, double highPoint, double lowPoint){
        if(armMotor.getSelectedSensorPosition() >= highPoint){
            armMotor.set(ControlMode.PercentOutput, Math.min(0, armRotation * rotateSpeed));
         }
        else if(armMotor.getSelectedSensorPosition() <= lowPoint){
            armMotor.set(ControlMode.PercentOutput, Math.max(0, armRotation * rotateSpeed));

        }
        else{
            armMotor.set(ControlMode.PercentOutput, rotateSpeed * armRotation);

        }
    }
    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }

    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }
    public void setArmRotationSpeed(double rotation){
        rotateSpeed = rotation;
    }
    public void setPosition(double position){
        double speed = armPid.calculate(armMotor.getSelectedSensorPosition(), position);
        System.out.println(speed);
        armMotor.set(ControlMode.PercentOutput, clamp(speed, -1, 1));

        
        
    }
    @Override
    public void periodic(){
        //high -43
        //low -2145 -2139
    }
}


