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

public class Pivoter extends SubsystemBase {
    private static Pivoter armInstance = null;
    private CANSparkMax pivotMotor1;
    private CANSparkMax pivotMotor2;
    private SparkMaxConfig motorConfig;

    public Pivoter() {
        pivotMotor1 = new CANSparkMax(9, MotorType.kBrushless);

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
            20,
            20,
            false,
            true,
            4096,
            false,
            // kP is currentlt too low
            new PIDConfig(5, 0, 0, 0)
        );

        SparkMaxSetup.setup(pivotMotor1, motorConfig);



        pivotMotor2 = new CANSparkMax(13, MotorType.kBrushless);

        motorConfig = new SparkMaxConfig(new SparkMaxStatusFrames(
            20,
            20,
            20,
            500,
            500,
            500,
            500),
            1000,
            true,
            IdleMode.kCoast,
            20,
            20,
            true,
            pivotMotor1
        );

        SparkMaxSetup.setup(pivotMotor2, motorConfig);
    }

    public static Pivoter getInstance() {
        if (armInstance == null) {
            armInstance = new Pivoter();
        }
        return armInstance;
    }
    /**
     * @param position Meters
     */
    public void rotate(double position) {
        pivotMotor1.getPIDController().setReference(position, ControlType.kPosition);
    }
}
