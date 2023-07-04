package utility.data;

import java.io.File;

public class FilePath {

    public static final String PATH_TO_RESOURCES_PACKAGE = System.getProperty("user.dir") + File.separator+"src"+ File.separator+"test"+ File.separator+"resources"+ File.separator;


    public static final String BRAND_LOGO_FILE = PATH_TO_RESOURCES_PACKAGE + "%s";
    public static final String BROWSER_PROPERTIES = PATH_TO_RESOURCES_PACKAGE + "%s";
}
