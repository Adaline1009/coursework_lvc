import model.CommandMessage;
import model.DataMessage;
import model.ResponseMessage;

import javax.xml.crypto.Data;

/**
 * Created by Adelya on 20.03.2018.
 */
public class TestFile {

    public static void main(String[] args)
    {
        CommandMessage newcommandmessage = new CommandMessage("101","10101","101110","10101",true);
        System.out.println(newcommandmessage.toStr());
        DataMessage newmes = new DataMessage("111","1111111111111111",false);
        System.out.println(newmes.toStr());
        ResponseMessage kekmes = new ResponseMessage("111",
                "10101",
                "111",
                true,
                false,
                true,
                true,
                true,
                true,
                false,
                false,
                true);
        System.out.println(kekmes.toStr());
    }

    //CommandMessage newcommandmessage = new CommandMessage("1010","1010","1010","10101",true);
}
