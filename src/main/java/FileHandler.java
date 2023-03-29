import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileHandler {

    public static Properties loadFile(String path){
        InputStream file;
        Properties properties = null;

        try {
            file = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
            try {
                properties = new Properties();
                properties.load(file);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (file != null) {
                    try {
                        file.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}