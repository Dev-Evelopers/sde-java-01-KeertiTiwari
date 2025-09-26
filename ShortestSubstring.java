import java.util.*;

public class ShortestSubstring{
    public static void main(String[] args) {
        String s = "dabbcabcd";
        System.out.println(SubstringLength(s));
    }

    public static int SubstringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        int need = set.size();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, count = 0, minLen = s.length();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) count++;
            while (count == need) {
                minLen = Math.min(minLen, right - left + 1);
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) count--;
                left++;
            }
        }
        return minLen;
    }
}
