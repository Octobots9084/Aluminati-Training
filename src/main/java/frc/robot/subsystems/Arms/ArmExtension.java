package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ArmExtension extends InstantCommand {
    private Extender extender;
    private double speed;

    public ArmExtension(double position) {
        extender = Extender.getInstance();
        this.speed = position;
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("test","test1");
        extender.extend(this.speed);
    }
}
