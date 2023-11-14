package frc.robot.subsystems.Arms;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Libraries.Util.PIDConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxEncoderType;
import frc.robot.Libraries.Util.SparkMax.SparkMaxSetup;
import frc.robot.Libraries.Util.SparkMax.SparkMaxStatusFrames;


public class FlySwatter extends SubsystemBase {
    private static FlySwatter FlySwatterInstance;
    private static CANSparkMax FlySwatterMotor;
    private static SparkMaxConfig FlySwatterConfig;

    public static FlySwatter getInstance() {
        if (FlySwatterInstance == null) {
            FlySwatterInstance = new FlySwatter();
        }
        return FlySwatterInstance;
    } 

    public FlySwatter () {
        FlySwatterMotor = new CANSparkMax(15, MotorType.kBrushless);
        FlySwatterConfig = new SparkMaxConfig(new SparkMaxStatusFrames(
            500,
            20,
            500,
            500,
            500,
            20,
            500),
        1000,
        true,
        SparkMaxEncoderType.Absolute,
        IdleMode.kCoast,
        15, 
        15, 
        true, 
        false,
        4096,
        false,
        new PIDConfig(1.7, 0, 0, 0));
        /*FlySwatter FlySwatterInstance = null;*/
        SparkMaxSetup.setup(FlySwatterMotor, FlySwatterConfig);
    }
    public void setSpeed(double speed){
        FlySwatterMotor.set(speed);
    }
    public void setAngle(double angle){
        FlySwatterMotor.getPIDController().setReference(angle, ControlType.kPosition);
    }
}