package model;

public class DataMessage extends Message
{
    private String data;

    public DataMessage(String clockSignal, String data, boolean parityBit)
    {
        if (checkValid(clockSignal) && checkValid(data))
        {
            if (clockSignal.length() == 3 && data.length() == 16)
            {
                this.clockSignal = clockSignal;
                this.data = data;
                this.parityBit = parityBit;
            }
            else
            {
                throw new IllegalArgumentException("Length of clock signal must be 3\n" +
                        "Length of data must be 16\n");
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
                + this.data
                + ((this.parityBit) ? "1" : "0");
    }
}
