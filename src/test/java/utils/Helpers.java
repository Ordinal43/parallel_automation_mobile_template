package utils;

import io.github.cdimascio.dotenv.Dotenv;

import static utils.Constants.SRC_TEST_RESOURCES;
import static utils.Constants.TEST_DATA_FILENAME;

public class Helpers {
    private static Dotenv dotenv;
    private static Dotenv testData;

    public static String ENV(String key) {
        if (dotenv == null) {
            dotenv = Dotenv.configure().ignoreIfMissing().load();
        }
        return dotenv.get(key);
    }

    public static String TEST_DATA(String key) {
        if (testData == null) {
            testData = Dotenv.configure().ignoreIfMissing()
                    .directory(SRC_TEST_RESOURCES).filename(TEST_DATA_FILENAME)
                    .load();
        }
        System.out.println(key + " : " + testData.get(key));
        return testData.get(key);
    }
}
