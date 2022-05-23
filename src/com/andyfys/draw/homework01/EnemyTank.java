package com.andyfys.draw.homework01;

/**
 * @author Andyfys
 * @version 1.0
 */
public class EnemyTank extends Tank{


    public EnemyTank(int x, int y, int speed) {
        super(x, y, speed);
        setType(0);
        setDirection(2);
    }


}
