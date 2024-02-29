package frc.robot.subsystems.light;

import com.ctre.phoenix.CANifier.LEDChannel;
import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.StrobeAnimation;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Light extends SubsystemBase{
    private CANdle candle;
    private static Light light;
    public static Light getInstance() {
        if (light == null) {
            light = new Light();
        }
        return light;
    }
    private RainbowAnimation rainbowAnimation = new RainbowAnimation(0.9 , 0.99, 272);
    private StrobeAnimation strobeAnimation = new StrobeAnimation(0, 0, 0, 0, 0.9, 272);
    
    public Light() {
        this.candle = new CANdle(12);
    }

    public void test(int a, int b, int c) {
        candle.setLEDs(a,b,c);
    }

    public void setStrobeAnimationPurple() {
        strobeAnimation.setR(255);
        strobeAnimation.setG(0);
        strobeAnimation.setB(255);
        animation = (strobeAnimation);
    }
    public void setAnimationRainbow     () {
        animation = (rainbowAnimation);
    }

    public void setStrobeAnimationYellow() {
        strobeAnimation.setR(255);
        strobeAnimation.setG(255);
        strobeAnimation.setB(0);
        animation = (strobeAnimation);
    }

    public void setStrobeAnimationRed() {
       strobeAnimation.setR(255);
        strobeAnimation.setG(0);
        strobeAnimation.setB(0);
        animation = (strobeAnimation);
    }

    public void setImageDisplay(int[][] pixels){
        for (int i = 0; i < pixels.length; i++) {
            candle.setLEDs(pixels[i][0], pixels[i][1], pixels[i][2], 255, i, 1);
        }
    }

    private Animation animation = strobeAnimation;
    @Override
    public void periodic() {
        candle.animate(animation);
        
    }


}
