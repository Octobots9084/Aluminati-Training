package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ArmPivot extends InstantCommand {
    private Pivoter pivoter;
    private double position;

    public ArmPivot(double position) {
        pivoter = Pivoter.getInstance();
        this.position = position;
    }

    @Override
    public void initialize() {
        pivoter.rotate(this.position);
    }
}
