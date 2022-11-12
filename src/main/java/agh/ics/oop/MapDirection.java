package agh.ics.oop;

public enum MapDirection{
    NORTH("^"),
    EAST(">"),
    SOUTH("v"),
    WEST("<");

    private String name;
    private MapDirection(String name){
        this.name=name;
    }

    public String toString() {
        return this.name;
    }

    public MapDirection next(){
        MapDirection[] a=this.values();
        return a[(this.ordinal()+1)%a.length];
    }
    public MapDirection previous() {
        MapDirection[] a = this.values();
        if (this.ordinal() == 2) {
            return EAST;
        }
        return a[(a.length - Math.abs(this.ordinal() - 1) % a.length) % a.length];
    }
    public Vector2d toUnitVector(){
            switch(this){
                case NORTH:
                    return new Vector2d(0,1);
                case EAST:
                    return new Vector2d(1,0);
                case SOUTH:
                    return new Vector2d(0,-1);
                case WEST:
                    return new Vector2d(-1,0);
                default:
                    return new Vector2d(0,0);



            }
        }


}
