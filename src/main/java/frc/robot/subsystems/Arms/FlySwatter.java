package frc.robot.subsystems.Arms;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Libraries.Util.PIDConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxEncoderType;
import frc.robot.Libraries.Util.SparkMax.SparkMaxSetup;
import frc.robot.Libraries.Util.SparkMax.SparkMaxStatusFrames;


public class FlySwatter {
    public static FlySwatter getInstance() {
        if (FlySwatterInstance == null) {
            FlySwatterInstance = new FlySwatter();
        }
        return FlySwatterInstance;
    } 

    public FlySwatter () {
        FlySwatterMotor = new CANSparkMax(15, MotorType.kBrushless);
        FlySwatterConfig = new SparkMaxConfig(null, 0, false, null, 0, 0, false, FlySwatterMotor);
            private static FlySwatter FlySwatterInstance = null;
        private CANSparkMax FlySwatterMotor;
        private SparkMaxConfig FlySwatterConfig;
        SparkMaxSetup.setup(FlySwatterMotor, FlySwatterConfig);
    }
    
}
