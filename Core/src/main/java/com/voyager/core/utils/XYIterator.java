package com.voyager.core.utils;

import com.voyager.core.services.SectorsService;

/**
 * Created by Vova on 6/23/2017.
 */
public class XYIterator {
    public static void iterateXY(int startX, int startY, ActionInSquare action){
        for (int y = startY; y < y + SectorsService.SECTOR_SIDE_SIZE; y++){
            iterateX(startX, y, action);
        }
    }

    public static void iterateX(int startX,int y, ActionInSquare action){
        for (int x = startX; x < x + SectorsService.SECTOR_SIDE_SIZE; x++){

        }
    }
}
