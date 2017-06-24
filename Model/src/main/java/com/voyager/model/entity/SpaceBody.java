package com.voyager.model.entity;

/**
 * Created by volodymyr.bodnar on 6/18/2017.
 */
public class SpaceBody extends AbstractDescribtable{
    private int x,y;
    private int height, width;
    private String model;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SpaceBody spaceBody = (SpaceBody) o;

        if (x != spaceBody.x) return false;
        if (y != spaceBody.y) return false;
        if (height != spaceBody.height) return false;
        if (width != spaceBody.width) return false;
        return model != null ? model.equals(spaceBody.model) : spaceBody.model == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + height;
        result = 31 * result + width;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
