package agh.ics.oop;

public enum MoveDirection {

    FORWARD,
    BACKWARD,
    LEFT,
    RIGHT;

    public static MoveDirection[] strArrtoDir(String[] args){
        MoveDirection[] DirArr= new MoveDirection[args.length];
        for (int i=0;i<args.length;i++){
            DirArr[i]=translate(args[i]);
        }
        return DirArr;
    }

    public static MoveDirection translate(String arg){
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
