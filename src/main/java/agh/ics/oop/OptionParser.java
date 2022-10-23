package agh.ics.oop;

public class OptionParser {
    public static MoveDirection[] parse(String[] moves){
        MoveDirection[] dirArr=new MoveDirection[moves.length];
        int i=0;
        for (String arg:moves){
            switch(arg){
                case "f","foward":
                    dirArr[i]=MoveDirection.FORWARD;
                    i++;
                    break;
                case "b","backward":
                    dirArr[i]=MoveDirection.BACKWARD;
                    i++;
                    break;
                case "l","left":
                    dirArr[i]=MoveDirection.LEFT;
                    i++;
                    break;
                case "r","right":
                    dirArr[i]=MoveDirection.RIGHT;
                    i++;
                    break;
                default:
                    break;
            }

        }
        return dirArr;
    }
}
