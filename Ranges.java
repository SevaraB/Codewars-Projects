/*
 * Range Extraction
 * @author James McDonald
 *
 * This is a little esoteric, but it compresses
 * a sequential series of numbers by replacing
 * individual consecutive numbers with a hyphenated
 * range.
 *
 * Example: -1,0,1,2,3,4,5 is compressed to "-1-5."
 */

class Ranges {
	
	public static String rangeExtraction(int[] arr) {
    
		// convert int array to string array for easier modification
		String[] sr = new String[arr.length];
		
		for (int i = 0; i < sr.length; i++)
			sr[i] = Integer.toString(arr[i]);
		
		// replace median in consecutive triplets with hyphen
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i+1] - arr[i] == 1 && arr[i] - arr[i-1] == 1) sr[i] = "-";
		}

		String result = sr[0];

		for (int i = 1; i < sr.length; i++)
			result += "," + sr[i];
		
		// truncate consecutive hyphens
		return result.replaceAll("(,-)+,", "-");
    }
}