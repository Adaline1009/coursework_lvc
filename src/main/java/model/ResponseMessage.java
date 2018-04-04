package model;

public class ResponseMessage extends Message
{
    private String deviceAddress;
    private String reserve;
    private boolean errorInMessageBit;
    private boolean responseSignBit;
    private boolean serviceRequestBit;
    private boolean groupCommandBit;
    private boolean busySubBit;
    private boolean defectiveSubBit;
    private boolean controlAcceptBit;
    private boolean defectiveDeviceBit;

    public ResponseMessage(String clockSignal,
                           String deviceAddress,
                           String reserve,
                           boolean parityBit,
                           boolean errorInMessageBit,
                           boolean responseSignBit,
                           boolean serviceRequestBit,
                           boolean groupCommandBit,
                           boolean busySubBit,
                           boolean defectiveSubBit,
                           boolean controlAcceptBit,
                           boolean defectiveDeviceBit)
    {
        if (checkValid(clockSignal) && checkValid(deviceAddress) && checkValid(reserve))
        {
            if (clockSignal.length() == 3 && deviceAddress.length() == 5 && reserve.length() == 3)
            {
                this.clockSignal = clockSignal;
                this.deviceAddress = deviceAddress;
                this.reserve = reserve;
                this.errorInMessageBit = errorInMessageBit;
                this.responseSignBit = responseSignBit;
                this.serviceRequestBit = serviceRequestBit;
                this.groupCommandBit = groupCommandBit;
                this.busySubBit = busySubBit;
                this.defectiveSubBit = defectiveSubBit;
                this.controlAcceptBit = controlAcceptBit;
                this.defectiveDeviceBit = defectiveDeviceBit;
                this.parityBit = parityBit;
            }
            else
            {
                throw new IllegalArgumentException("Length of clock signal must be 3\n" +
                        "Length of device address must be 5\n" +
                        "Length of reserve must be 3");
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
                + ((this.errorInMessageBit) ? "1" : "0")
                + ((this.responseSignBit) ? "1" : "0")
                + ((this.serviceRequestBit) ? "1" : "0")
                + this.reserve
                + ((this.groupCommandBit) ? "1" : "0")
                + ((this.busySubBit) ? "1" : "0")
                + ((this.defectiveSubBit) ? "1" : "0")
                + ((this.controlAcceptBit) ? "1" : "0")
                + ((this.defectiveDeviceBit) ? "1" : "0")
                + ((this.parityBit) ? "1" : "0");
    }
}
