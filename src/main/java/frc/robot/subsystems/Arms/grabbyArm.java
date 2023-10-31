package frc.robot.subsystems.Arms;

import com.revrobotics.CANSparkMax;

import frc.robot.Libraries.Util.SparkMax.SparkMaxConfig;

public class grabbyArm {
    private static grabbyArm armInstance = null;
    private CANSparkMax mainRotationMotor;
    private CANSparkMax extensionMotor;
    private CANSparkMax wristMotor;
    private CANSparkMax grabbingMotor;
    private SparkMaxConfig rollerConfig;

    public grabbyArm() {

    }

    public static grabbyArm getInstance() {
        if (armInstance == null) {
            armInstance = new grabbyArm();
        }
        return armInstance;
    }
}
