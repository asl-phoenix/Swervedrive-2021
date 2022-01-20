/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;

/**
 * COMPETITION READY
 * 
 * Two motors in a gearbox (winch) to lift us, and one motor to initally raise
 * the arm.
 */
public class Gyroscope extends SubsystemBase {

    // Initialize fields
    private PigeonIMU gyro;
    private double[] ypr = new double[3];

    public enum PigeonState {
        NoComm, Initializing, Ready, UserCalibration,
    };

    public Gyroscope() {
        PigeonIMU gyro = new PigeonIMU(0);
        PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();

    }

    public ErrorCode getStatus(PigeonIMU.GeneralStatus genStatus)
    {
        return gyro.getGeneralStatus(genStatus);
    }

    public double getYaw(double[] ypr)
    {
        gyro.getYawPitchRoll(ypr);
        return ypr[0];
    }

    public void calibrateGyro()
    {
        gyro.enterCalibrationMode(CalibrationMode.BootTareGyroAccel);
    }

    public void resetValues()
    {
        gyro.configFactoryDefault();
    }

    public void getState()
    {
        if (gyro.getState() == PigeonIMU.PigeonState.Ready)
        {
            System.out.println ("Ready");
        }
        else if (gyro.getState() == PigeonIMU.PigeonState.UserCalibration)
        {
            System.out.println ("Calibrating");
        }
        else if (gyro.getState() == PigeonIMU.PigeonState.Initializing)
        {
            System.out.println ("Initializing");
        }
        else if (gyro.getState() == PigeonIMU.PigeonState.NoComm)
        {
            System.out.println ("No communication with pigeon gyro");
        }

    }

    


    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

}
