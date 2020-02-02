package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{

    //region Constructors
    public CollisionObject(int x, int y) {
        super(x, y);
    }
    //endregion
    //region Methods
    public boolean isCollision(GameObject gameObject, Direction direction){
        int xMove = 0;
        int yMove = 0;
        switch (direction) {
            case UP:
                yMove -= Model.FIELD_CELL_SIZE;
                break;
            case DOWN:
                yMove += Model.FIELD_CELL_SIZE;
                break;
            case LEFT:
                xMove -= Model.FIELD_CELL_SIZE;
                break;
            case RIGHT:
                xMove += Model.FIELD_CELL_SIZE;
                break;
            default:
                break;
        }
        return this.getX() + xMove == gameObject.getX() && this.getY() + yMove == gameObject.getY();


    }
    //endregion
}
