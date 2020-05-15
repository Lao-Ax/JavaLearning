package com.Alex.iostreams;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Alex on 03.01.2017 003.
 */
public class DirListWithAnonymClass {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        args = new String[]{".*iml"};
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(filter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

    static FilenameFilter filter(final String regex){ // (final) необходимо для того, чтобы внутренний класс смог получить к нему доступ даже за пределами области определения аргумента.
        // Creation of anonymous inner class:
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        }; // End of anonymous inner class
    }
}
