package frc.robot.subsystems.Arms;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Libraries.Util.PIDConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxConfig;
import frc.robot.Libraries.Util.SparkMax.SparkMaxEncoderType;
import frc.robot.Libraries.Util.SparkMax.SparkMaxSetup;
import frc.robot.Libraries.Util.SparkMax.SparkMaxStatusFrames;

public class MainRoller extends SubsystemBase {
    private static MainRoller rollerInstance = null;
    private CANSparkMax rollerMotor;
    private SparkMaxConfig rollerConfig;

    public MainRoller() {
        rollerMotor = new CANSparkMax(11, MotorType.kBrushless);

        rollerConfig = new SparkMaxConfig(new SparkMaxStatusFrames(
            500,
            100,
            500,
            500,
            500,
            500,
            500),
            1000,
            true,
            SparkMaxEncoderType.Relative,
            IdleMode.kBrake,
            10,
            30,
            false,
            false,
            2048,
            false,
            new PIDConfig(0, 0, 0, 0)
        );

        SparkMaxSetup.setup(rollerMotor, rollerConfig);
    }

    public static MainRoller getInstance() {
        if (rollerInstance == null) {
            rollerInstance = new MainRoller();
        }
        return rollerInstance;
    }

    public void rotate(double speed) {
        rollerMotor.set(speed);
    }
}
