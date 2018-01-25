package framework.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    /**
     * Reads file into a string. <b><font color='red'>pay attention - you need JDK 1.8 to compile this code</font><b/>
     * @param filePath path to file
     * @return content of file as string
     * @throws IOException in case of file interactions problem
     */
    public static String readFileContent(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.lines(Paths.get(filePath)).forEach(sb::append);
        return sb.toString();
    }
}
