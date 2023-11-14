package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ArmPivot extends InstantCommand {
    private Pivoter pivoter;
    private double speed;

    public ArmPivot(double position) {
        pivoter = Pivoter.getInstance();
        this.speed = position;
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("test","test1");
        pivoter.rotate(this.speed);
    }
}
