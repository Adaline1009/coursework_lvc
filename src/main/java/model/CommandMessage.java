package model;

public class CommandMessage extends Message
{
    private String deviceAddress;
    private String poddressOrControlMode;
    private String commandCode;

    public CommandMessage(String clockSignal, String deviceAddress, String poddressOrControlMode, String commandCode, boolean parityBit)
    {
        if (checkValid(clockSignal)
                && checkValid(deviceAddress)
                && checkValid(poddressOrControlMode)
                && checkValid(commandCode))
        {
            if (clockSignal.length() == 3
                    && deviceAddress.length() == 5
                    && poddressOrControlMode.length() == 6
                    && commandCode.length() == 5)
            {
                this.clockSignal = clockSignal;
                this.deviceAddress = deviceAddress;
                this.poddressOrControlMode = poddressOrControlMode;
                this.commandCode = commandCode;
                this.parityBit = parityBit;
            }
            else
            {
                throw new IllegalArgumentException("Length of clock signal must be 3\n" +
                        "Length of device address must be 5\n" +
                        "Length of control mode must be 6\n" +
                        "Length of command code must be 5");
            }
        }
        else
        {
            throw new IllegalArgumentException("Parameters must consist only of 1 and 0");
        }
    }

    protected boolean checkValid(String parameter)
    {
        return parameter.replace("0","").
                replace("1","").
                length() == 0;
    }

    public String toStr()
    {
        return this.clockSignal
                + this.deviceAddress
                + this.poddressOrControlMode
                + this.commandCode
                + ((this.parityBit) ? "1" : "0");
    }
}
