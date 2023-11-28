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

public class Wrist extends SubsystemBase {
    private static Wrist armInstance = null;
    private CANSparkMax wristMotor1;
    private SparkMaxConfig motorConfig;

    public Wrist() {
        wristMotor1 = new CANSparkMax(12, MotorType.kBrushless);

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
            SparkMaxEncoderType.Absolute,
            IdleMode.kCoast,
            35,
            35,
            false,
            true,
            4096,
            false,
            // kP is currentlt too low
            new PIDConfig(0.67, 0, 0, 0)
        );

        SparkMaxSetup.setup(wristMotor1, motorConfig);

    }

    public static Wrist getInstance() {
        if (armInstance == null) {
            armInstance = new Wrist();
        }
        return armInstance;
    }
    /**
     * @param position Meters
     */
    public void rotate(double position) {
        wristMotor1.getPIDController().setReference(position, ControlType.kPosition);
    }


}

