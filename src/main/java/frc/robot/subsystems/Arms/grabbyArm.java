package frc.robot.subsystems.Arms;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Libraries.Util.PIDConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxEncoderType;
import frc.robot.Libraries.Util.SparkMax.SparkMaxSetup;
import frc.robot.Libraries.Util.SparkMax.SparkMaxStatusFrames;

public class grabbyArm {
    private static grabbyArm armInstance = null;
    private CANSparkMax mainRotationMotor1;
    private CANSparkMax mainRotationMotor2;
    private CANSparkMax extensionMotor;
    private CANSparkMax wristMotor;
    private CANSparkMax grabbingMotor;
    private SparkMaxConfig motorConfig;

    public grabbyArm() {
        mainRotationMotor1 = new CANSparkMax(9, MotorType.kBrushless);
        mainRotationMotor2 = new CANSparkMax(13, MotorType.kBrushless);
        extensionMotor = new CANSparkMax(10, MotorType.kBrushless);
        wristMotor = new CANSparkMax(12, MotorType.kBrushless);
        grabbingMotor = new CANSparkMax(11, MotorType.kBrushless);

        motorConfig = new SparkMaxConfig(new SparkMaxStatusFrames(
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
            true,
            2048,
            false,
            new PIDConfig(0, 0, 0, 0)
        );

        SparkMaxSetup.setup(mainRotationMotor1, motorConfig);
        SparkMaxSetup.setup(extensionMotor, motorConfig);
        SparkMaxSetup.setup(wristMotor, motorConfig);
        SparkMaxSetup.setup(grabbingMotor, motorConfig);

        motorConfig = new SparkMaxConfig(new SparkMaxStatusFrames(
            500,
            20,
            500,
            500,
            500,
            20,
            500),
            1000,
            true,
            IdleMode.kBrake,
            20,
            35,
            true,
            mainRotationMotor1
        );

        SparkMaxSetup.setup(mainRotationMotor2, motorConfig);
    }

    public static grabbyArm getInstance() {
        if (armInstance == null) {
            armInstance = new grabbyArm();
        }
        return armInstance;
    }
}
