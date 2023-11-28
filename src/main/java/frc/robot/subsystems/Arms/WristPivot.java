package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class WristPivot extends InstantCommand {
    private Wrist wrist;
    private double position;

    public WristPivot(double Position) {
        wrist = Wrist.getInstance();
        this.position = Position;
    }

    @Override
    public void initialize() {
        wrist.rotate(this.position);
    }
}
