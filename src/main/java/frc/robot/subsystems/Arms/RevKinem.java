package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RevKinem extends InstantCommand {
    private double absWristAngle;
    private double targetX;
    private double targetY;

    public RevKinem (double wristAngle, double targetX, double targetY) {
        wristAngle = absWristAngle;
        this.targetX = targetX;
        this.targetY = targetY; 
    }

    public static void main(String[] args)
    {
        CalcRevKinem.setVariables(0.82, 3, 1);
        System.out.println(CalcRevKinem.calcPivotAngle());
        System.out.println(CalcRevKinem.calcExtensionDistance());
    }
}
