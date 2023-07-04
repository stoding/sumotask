package utility;

public class SystemPropertyUtils {
    public static String getSystemPropertyValue(String propertyName) {
        return System.getProperty(propertyName);
    }
}
