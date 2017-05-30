/*
 * Self Scoring Dartboard
 * @author James McDonald
 *
 * Known issue: precision when dart is on
 * very edge of scoring region.
 *
 * To-do: replace int bounding with degrees
 * in double
 */
 
public class Dartboard {

    public String getScore(double x, double y)
    {
        // short circuit so don't div/0
        if (x == 0 && y == 0) return "DB";
        
        // converting x, y to distance, angle
        double radDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        Double angle = Math.toDegrees(Math.atan2(y, x));
        
        // move atan2 results from -180<=x<=180 to 0<x<=360
        // could use negative case values, but this is easier to read
        if (angle < 0) angle += 360;
        
        // generalize angle range to a value so
        // can use switch case instead of if-then
        int scoringRegion = (angle.intValue() + 9) / 18;
        
        if (radDistance <= 6.35)
          return "DB";  // bullseye
        if (radDistance <= 15.9)
          return "SB";  // bull
        if (radDistance <= 170) {
          String modifier = "";
          if (radDistance > 89 && radDistance <= 107) modifier = "T";
          if (radDistance > 162) modifier = "D";  // Outer diameter is board size
          
          // passing cases to variables wouldn't be much shorter
          // thanks to required break statements
          switch (scoringRegion) {
            case 0: return modifier + "6";
            case 1: return modifier + "13";
            case 2: return modifier + "4";
            case 3: return modifier + "18";
            case 4: return modifier + "1";
            case 5: return modifier + "20";
            case 6: return modifier + "5";
            case 7: return modifier + "12";
            case 8: return modifier + "9";
            case 9: return modifier + "14";
            case 10: return modifier + "11";
            case 11: return modifier + "8";
            case 12: return modifier + "16";
            case 13: return modifier + "7";
            case 14: return modifier + "19";
            case 15: return modifier + "3";
            case 16: return modifier + "17";
            case 17: return modifier + "2";
            case 18: return modifier + "15";
            case 19: return modifier + "10";
            default: break;
          }
        }
        
        // when you're out of valid values, return
        // an invalid one
        return "X";
    }
}
