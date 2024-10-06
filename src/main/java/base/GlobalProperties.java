package base;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
public class GlobalProperties {

    private static GlobalProperties instance;

    private final String baseUrl;

    public GlobalProperties() throws IOException {

        Properties prop=new Properties();

        try (FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/"+ "mobilebg.properties")) {

            prop.load(fis);
        }

        // read Test resources folder
        baseUrl=prop.getProperty("base.url");
    }

    public static GlobalProperties getInstance() {

        if (instance == null) {
            try {
                instance = new GlobalProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

}
