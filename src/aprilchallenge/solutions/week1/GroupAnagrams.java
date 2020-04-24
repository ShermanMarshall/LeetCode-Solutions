package aprilchallenge.solutions.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap();
        for (String s : strs) {
            char[] charMapping = new char[26];
            char[] chars = s.toUpperCase().toCharArray();
            boolean hasOffset = false;
            for (char c : chars) {
                int letterOrdinalPosition = ((int) c) - 65;
                ++charMapping[letterOrdinalPosition];
            }
            String hash = new String(charMapping);
            List<String> group = groups.get(hash);
            if (group == null) {
                group = new ArrayList();
                groups.put(hash, group);
            }
            group.add(s);
        }
        return new ArrayList(groups.values());
    }

	public static void main(String[] args) {
		
	}

}
