package com.voyager.model.entity;

import java.util.List;

/**
 * Created by volodymyr.bodnar on 6/21/2017.
 */
public class SpaceShip extends AbstractDescribtable {
    private int level;
    private int maxMaxCrewSize;
    private int maxEquipmentCount;
    private int maxCargoHold;

    private int hull;
    private int shields;

    private List<Resource> cargoHold;
    private List<Character> crew;
    private List<Equipment> installedEquipment;


}
