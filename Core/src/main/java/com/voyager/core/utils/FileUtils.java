package com.voyager.core.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vova on 6/24/2017.
 */
public class FileUtils {
    public static List<String> readLinesFromFile(String filePath){
        Scanner s = null;

        try {
            s = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> list = new LinkedList<>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();

        return list;
    }
}
