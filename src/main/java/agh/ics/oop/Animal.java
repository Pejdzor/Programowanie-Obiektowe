package agh.ics.oop;

public class Animal {
    private Vector2d position=new Vector2d(2,2);
    private MapDirection orientation=MapDirection.NORTH;
    public String toString(){
        return "Pozycja: "+position+" kierunek: "+orientation;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection dir){
        if (dir != null){
            switch(dir){
                case LEFT:
                    this.orientation=this.orientation.previous();
                    break;
                case RIGHT:
                    this.orientation=this.orientation.next();
                    break;
                case FORWARD:
                    if (this.position.add(this.orientation.toUnitVector()).precedes(new Vector2d(4,4))&&this.position.add(this.orientation.toUnitVector()).follows(new Vector2d(0,0))){
                        this.position=this.position.add(this.orientation.toUnitVector());
                    }
                    break;
                case BACKWARD:
                    if (this.position.add(this.orientation.toUnitVector().opposite()).precedes(new Vector2d(4,4))&&this.position.add(this.orientation.toUnitVector().opposite()).follows(new Vector2d(0,0))){
                        this.position=this.position.add(this.orientation.toUnitVector().opposite());}
                    break;
                default:
                    break;
            }
        }
    }
}
