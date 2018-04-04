package model;

import java.io.Serializable;

/**
 * Created by Adelya on 27.03.2018.
 */
public abstract class Message implements Serializable
{

    protected String clockSignal;
    protected boolean parityBit;

    public abstract String toStr();
    protected abstract boolean checkValid(String parameter);

}
