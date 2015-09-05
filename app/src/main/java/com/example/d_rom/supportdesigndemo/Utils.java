package com.example.d_rom.supportdesigndemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergbek on 05.09.2015.
 */
public class Utils {

    public static List<String> getDummyData() {
        final List<String> list = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            list.add("List Item " + i);
        }
        return list;
    }
}
