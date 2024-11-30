package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    TalonSRX backRight = new TalonSRX(3);
    TalonSRX frontRight = new TalonSRX(4);
    TalonSRX backLeft = new TalonSRX(5);
    TalonSRX frontLeft = new TalonSRX(6);
    double speed = 0.8;
    public DriveSubsystem(){
        
    }

    public void drive(double lSpeed, double rSpeed){
        backRight.set(ControlMode.PercentOutput, rSpeed * speed);  
        frontRight.set(ControlMode.PercentOutput, rSpeed * speed);
        backLeft.set(ControlMode.PercentOutput, -lSpeed * speed);
        frontLeft.set(ControlMode.PercentOutput, -lSpeed * speed);
    }
    public void modifySpeed(double setSpeed){
        speed = setSpeed;
    }
}
