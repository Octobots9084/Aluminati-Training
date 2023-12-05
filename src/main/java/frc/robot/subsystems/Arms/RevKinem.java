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

        
        calculateReverseKinematics.setVariables(absWristAngle, targetX, targetY);
        Pivoter.getInstance().rotate(calculateReverseKinematics.calcPivotAngle());
        Wrist.getInstance().rotate(absWristAngle);
        Extender.getInstance().extend(calculateReverseKinematics.calcExtensionDistance());
        
    }

    public static void main(String[] args)
    {
        calculateReverseKinematics.setVariables(0.82, 3, 1);
        System.out.println(calculateReverseKinematics.calcPivotAngle());
        System.out.println(calculateReverseKinematics.calcExtensionDistance());
    }
}
