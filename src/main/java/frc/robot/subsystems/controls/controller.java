package frc.robot.subsystems.controls;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.robot.ControlMap;
import frc.robot.subsystems.Arms.RollerIntake;

public class controller {
    public static void initTeleop() {
        new JoystickButton(ControlMap.DRIVER_BUTTONS, 1).onTrue(new RollerIntake(0.2));
        new JoystickButton(ControlMap.DRIVER_BUTTONS, 1).onFalse(new RollerIntake(0));

    }
}