package Leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class RepeatDNA {
	
	public static List<String> findRepeatedDnaSequences(String s) {
        List<String> rst = new ArrayList<String>();
        int length = 10;
        if (s == null || s.length() < length){
            return rst;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int size = map.size();
        Set<Integer> visited = new HashSet<Integer>();
        Set<String> dup = new HashSet<String>();
        int curr = getFirst(s, size, length, map), left = 1;
        System.out.println("curr: " + curr);
        visited.add(curr);
        while (left < s.length() - length + 1){
            curr = (curr - ((int)Math.pow(size, length - 1)) * map.get(s.charAt(left - 1))) * size + map.get(s.charAt(left + length - 1));
            System.out.println("curr: " + curr);
            if (visited.contains(curr)){
                dup.add(s.substring(left, left + length));
            }
            visited.add(curr);
            left += 1;
        }
        for (String string: dup){
            rst.add(string);
        }
        return rst;
    }
    
    private static int getFirst(String s, int base, int length, Map<Character, Integer> map){
        int result = 0;
        for (int i = 0; i < length; i++){
            result = base * result + map.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args){
    	String s = "GAGAGAGAGAGAG";
    	List<String> result = findRepeatedDnaSequences(s);
    	for (String string: result){
    		System.out.println(string);
    	}
    }
}
