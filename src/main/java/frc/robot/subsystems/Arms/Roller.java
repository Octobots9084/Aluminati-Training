package frc.robot.subsystems.Arms;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Libraries.Util.PIDConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxEncoderType;
import frc.robot.Libraries.Util.SparkMax.SparkMaxSetup;
import frc.robot.Libraries.Util.SparkMax.SparkMaxStatusFrames;

public class Roller {
    private static Roller rollerInstance = null;
    private CANSparkMax rollerMotor;
    private SparkMaxConfig rollerConfig;

    public Roller() {
        rollerMotor = new CANSparkMax(16, MotorType.kBrushless);

        rollerConfig = new SparkMaxConfig(new SparkMaxStatusFrames(
            500,
            20,
            500,
            500,
            500,
            20,
            500),
            1000,
            true,
            SparkMaxEncoderType.Relative,
            IdleMode.kBrake,
            20,
            35,
            false,
            false,
            2048,
            false,
            new PIDConfig(5, 0, 0, 0)
        );

        SparkMaxSetup.setup(rollerMotor, rollerConfig);
    }

    public static Roller getInstance() {
        if (rollerInstance == null) {
            rollerInstance = new Roller();
        }
        return rollerInstance;
    }

    public void rotate(double speed) {
        rollerMotor.set(speed);
    }
}
