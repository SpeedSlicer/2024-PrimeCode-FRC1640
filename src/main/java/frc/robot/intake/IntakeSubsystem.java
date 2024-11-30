package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    TalonSRX intakeMotor = new TalonSRX(1);
    public IntakeSubsystem(){
        
    }
    public void rotateIntake(double rotateSpeed){
        intakeMotor.set(ControlMode.PercentOutput, rotateSpeed);
    }
}
