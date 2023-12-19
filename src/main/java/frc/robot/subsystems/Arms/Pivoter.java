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
            IdleMode.kBrake,
            20,
            20,
            false,
            true,
            4096,
            false,
            // kP is currentlt too low
            new PIDConfig(16, 0, 1.6, 0)
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
    // these numbers *might* be wrong
    double MIN_ANGLE = 0.535;
    double MAX_ANGLE = 0.7;
    public void rotate(double angle) {
        if(angle < MIN_ANGLE){
            angle = MIN_ANGLE;
        } else if(angle > MAX_ANGLE){
            angle = MAX_ANGLE;
        }

        pivotMotor1.getPIDController().setReference(angle, ControlType.kPosition);
    }
}
