package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionParser {
    public static List<MoveDirection> parse(List<String> moves)throws IllegalArgumentException{
        List<MoveDirection> dirArr=new ArrayList<>();
        for (String arg:moves){
            switch(arg){
                case "f","foward":
                    dirArr.add(MoveDirection.FORWARD);

                    break;
                case "b","backward":
                    dirArr.add(MoveDirection.BACKWARD);

                    break;
                case "l","left":
                    dirArr.add(MoveDirection.LEFT);

                    break;
                case "r","right":
                    dirArr.add(MoveDirection.RIGHT);
                    break;
                default:
                    throw new IllegalArgumentException(arg + " is not a legal move");
            }
            }
        return dirArr;
    }
}
