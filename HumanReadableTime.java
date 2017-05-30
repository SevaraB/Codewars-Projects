/*
 * Human Readable Time
 * @author James McDonald
 *
 * Time-waster; can convert seconds to HH:MM:SS notation
 * (seconds being common output from APIs)
 */
public class HumanReadableTime {
	
  public static String makeReadable(int seconds) {
	      
    int hrs = seconds / 3600;
    seconds -= hrs * 3600;
    String hh = String.format("%02d:", hrs);
    
    int mins = seconds / 60;
    seconds -= mins * 60;
    String mm = String.format("%02d:", mins);
    
    String ss = String.format("%02d", seconds);
    return hh + mm + ss;
  }
}
