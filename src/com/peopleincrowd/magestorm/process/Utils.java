package com.peopleincrowd.magestorm.process;

/**
 *
 * @author vanthiepnguyen
 */
public class Utils {
    public static String capitalize(String inputString) {

        String cap = inputString.toLowerCase().substring(0, 1).toUpperCase();
        cap += inputString.toLowerCase().substring(1);
        return cap;
    }

    public static String getResourceFile (String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return classLoader.getResource(fileName).getFile();
    }
}
