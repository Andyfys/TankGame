package com.andyfys.draw.tankgame2;

/**
 * @author Andyfys
 * @version 1.0
 */
public class Tank {
    private int x;
    private int y;
    private int direction;
    private int type;
    private int speed = 2;
    private boolean state = true;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    public Tank(){}
    public Tank(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.type = 0;
    }

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
//    public void isBoraded
public void moveUp() {
    y -= speed;
}

    public void moveRight() {
        x += speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }
//    public void move(int patten) {
//        switch (patten) {
//            case 0:
//                y -= speed;
//                break;
//            case 1:
//                x += speed;
//                break;
//            case 2:
//                y += speed;
//                break;
//            case 3:
//                x -= speed;
//                break;
//            default:
//                System.out.println("不合法");
//        }
//    }

}
