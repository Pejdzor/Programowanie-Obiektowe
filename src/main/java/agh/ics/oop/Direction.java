package agh.ics.oop;

public enum Direction {
    FORWARD,
    BACKWARD,
    LEFT,
    RIGHT;

    public static Direction[] strArrtoDir(String[] args){
        Direction[] DirArr= new Direction[args.length];
        for (int i=0;i<args.length;i++){
            DirArr[i]=translate(args[i]);
        }
        return DirArr;
    }

    public static Direction translate(String arg){
        switch(arg){
            case "f":
                return FORWARD;
            case "b":
                return BACKWARD;
            case "r":
                return RIGHT;
            case "l":
                return LEFT;
            default:
                return null;
        }

    }

}