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

public class Extender extends SubsystemBase {
    private static Extender armInstance = null;
    private CANSparkMax extensionMotor;
    private SparkMaxConfig motorConfig;
    private double gearRatio = 5;
    private int teethNum = 10;
    private double toothHoleSpacing = 0.01329941; // meters

    public Extender() {
        extensionMotor = new CANSparkMax(10, MotorType.kBrushless);

        motorConfig = new SparkMaxConfig(new SparkMaxStatusFrames(
            500,
            20,
            500,
            500,
            500,
            500,
            500),
            1000,
            true,
            SparkMaxEncoderType.Relative,
            IdleMode.kBrake,
            30,
            30,
            true,
            false,
            42,
            false,
            new PIDConfig(0.6, 0, 0, 0)
        );

        SparkMaxSetup.setup(extensionMotor, motorConfig);

        extensionMotor.getEncoder().setPosition(0);
    }

    public static Extender getInstance() {
        if (armInstance == null) {
            armInstance = new Extender();
        }
        return armInstance;
    }
    /**
     * @param position Meters
     */

     double MIN_POS = 0;
    double MAX_POS = 0.2;
    public void extend(double position) {
        double temp_pos = position;
        if(temp_pos<MIN_POS){
            temp_pos = MIN_POS;
        } else if(temp_pos>MAX_POS){
            temp_pos = MAX_POS;
        }
        double convertedPosition = ((position/toothHoleSpacing)/teethNum)*gearRatio;
        extensionMotor.getPIDController().setReference(convertedPosition, ControlType.kPosition);
    }
}
