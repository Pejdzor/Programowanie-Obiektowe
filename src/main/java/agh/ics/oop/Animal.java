package agh.ics.oop;

public class Animal {
    private Vector2d position=new Vector2d(2,2);
    private MapDirection orientation=MapDirection.NORTH;
    private IWorldMap map;
    public String toString(){
        return switch(orientation){
            case NORTH -> "^";
            case SOUTH -> "V";
            case EAST -> ">";
            case WEST -> "<";
            };

    }
    public Animal(){

    };
    public Animal(IWorldMap map){
        this.map=map;
    }
    public Animal(IWorldMap map,Vector2d initial){
        this.map=map;
        this.position=initial;
    }
    public Vector2d getPosition(){
        return this.position;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection dir){
        Vector2d moveTo = new Vector2d(-1,-1);
        if (dir != null){
            switch(dir){

                case LEFT:
                    this.orientation=this.orientation.previous();
                    break;
                case RIGHT:
                    this.orientation=this.orientation.next();
                    break;
                case FORWARD:
                        moveTo=this.position.add(this.orientation.toUnitVector());
                    break;
                case BACKWARD:
                        moveTo=this.position.add(this.orientation.toUnitVector().opposite());
                    break;
                default:
                    break;
            }
        }
        if (map.canMoveTo(moveTo)){
            position=moveTo;
        }
    }
}
