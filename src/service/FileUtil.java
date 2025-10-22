package service;

import java.io.*;

public class FileUtil {

    public static BufferedReader openReader(String filePath) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
    }

    public static BufferedWriter openWriter(String filePath) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
    }
}