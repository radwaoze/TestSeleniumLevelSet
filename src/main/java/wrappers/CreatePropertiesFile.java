package wrappers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CreatePropertiesFile {

    public String readPropertiesFile(String variable) throws IOException
    {
        FileInputStream fileObj = new FileInputStream("G:\\ITI\\Automation\\Automtion Practices\\src\\main\\resources\\values.properties");

        Properties proOji = new Properties();
        proOji.load(fileObj);

        String choiceValue = (String)proOji.getProperty(variable);
        System.out.println(choiceValue);
        return choiceValue;
    }
}
