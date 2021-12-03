package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


private DoubleSolenoid piston;
private VictorSP reel;

public class PistonReel extends SubsystemBase {
  /**
   * Constructor for PistonReel
   */
  public PistonReel(Joystick drive) {
    piston = new DoubleSolenoid(0,1);
    reel = new VictorSP(0);
    driver = drive;
  }

  //Sets motor to reel in the piston
  public void reelPiston(double speed){
    reel.set(speed);
  }
/*
  //Sets motor to unreel in the piston
  public void unreelPiston(double speed){
    reel.set(-speed);
  }
*/
  //Sets motor to stop reeling piston
  public void stopPiston(){
    reel.set(0);
  }

  //Extends piston 
  public void pistonExtend(){
    piston.set(kForward);
  }

  //Retaracts piston
  public void pistonRetract(){
    piston.set(kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}