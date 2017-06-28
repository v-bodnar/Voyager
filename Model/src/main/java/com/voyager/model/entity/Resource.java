package com.voyager.model.entity;

/**
 * Created by volodymyr.bodnar on 6/18/2017.
 */
public class Resource extends AbstractDescribtable{
    private Type type;
    private int ammount;
    private int spreading;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public int getSpreading() {
        return spreading;
    }

    public void setSpreading(int spreading) {
        this.spreading = spreading;
    }

    public enum Type{
        MINERAL, METAL, ORGANIC, LIQUID, GAS;
    }
}
