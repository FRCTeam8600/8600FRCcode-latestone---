package frc.robot.subsystems

import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.robot.Constants

class ShooterSubsystem : SubsystemBase() {
    private val rampMotor = WPI_TalonSRX(Constants.rampMotorId)
    private val triggerMotor = WPI_TalonSRX(Constants.triggerMotorId)
    private var rampingSince: Long = 0L // ms
    private var triggerQueued = false

    init {
        rampMotor.configFactoryDefault()
        triggerMotor.configFactoryDefault()

        rampMotor.setNeutralMode(NeutralMode.Brake)
        triggerMotor.setNeutralMode(NeutralMode.Brake)
    }

    fun setRamp(ramp: Boolean) {
        if (triggerQueued)
            return
        if (!ramp) {
            rampingSince = 0L
            rampMotor.set(0.0)
        } else {
            rampingSince = System.currentTimeMillis()
            rampMotor.set(1.0)
        }
    }

    // this better be called
    override fun periodic() {
        // This method will be called once per scheduler run
    }

    private fun schedule(fn: () -> Unit, ms: Long) {
        Timer.delay(ms.toDouble()/1000.0)
        fn()
    }

    fun load(amount: Double) {
        rampMotor.set(amount);
        triggerMotor.set(amount);
    }

    fun trigger() {
        if (triggerQueued)
            return
        triggerQueued = true
        val rampingFor = System.currentTimeMillis() - rampingSince
        if (rampingFor < Constants.RAMP_MS) {
            schedule({ trigger() }, Constants.RAMP_MS - rampingFor + 1)
            return
        }
        triggerMotor.set(1.0)
        schedule({
            triggerMotor.set(0.0)
            triggerQueued = false
        }, Constants.TRIGGER_MS)
    }

}