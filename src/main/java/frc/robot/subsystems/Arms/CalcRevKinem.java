package frc.robot.subsystems.Arms;

public class CalcRevKinem {
    private static final double pivotHeight = 1;
    private static final double minExtension = 1;
    private static final double wristLength = 1;
    
    private static double a;
    private static double b = minExtension;
    private static double c = pivotHeight;
    private static double d = wristLength;
    private static double g;
    private static double h;
    
    // absWristAngle should be given in radians, output will also be in radians
    public static void setVariables(double absWristAngle, double targetX, double targetY) {
        a = targetY;
        g = absWristAngle;
        h = targetX;
    }
    
    public static double calcPivotAngle() {
        
        
        return 2*Math.atan(
            (
                1 / 
                (a - c - (d*Math.sin(g)))
            ) * 
            (
                Math.sqrt(
                    (a*a) - 
                    (2*a*c) - 
                    (2*a*d*Math.sin(g)) + 
                    (c*c) + 
                    (2*c*d*Math.sin(g)) + 
                    (d*d*Math.sin(g)*Math.sin(g)) + 
                    (d*d*Math.cos(g)*Math.cos(g)) - 
                    (2*d*h*Math.cos(g)) + 
                    (h*h)
                ) + 
                (d*Math.cos(g)) - h
            )
        );
    }
    
    public static double calcExtensionDistance() {
        double pivotAngle = calcPivotAngle();
        
        return ((
            a - 
                (b * Math.sin(pivotAngle)) -
                c -
                (d * Math.sin(g))
            ) / 
            (Math.sin(pivotAngle))
        );
    }
}