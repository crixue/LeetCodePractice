package leetcode.string;

import java.util.*;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }

        Deque<Character> stk = new ArrayDeque<>();
        Set<Character> existsSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (counter.get(c) <= 0) {
                continue;
            }
            if(existsSet.contains(c)) {
                counter.put(c, counter.get(c) - 1);
                continue;
            }
            while (!stk.isEmpty() && counter.get(stk.peek()) > 0 && c < stk.peek()) {
                existsSet.remove(stk.peek());
                stk.removeFirst();
            }
            stk.addFirst(c);
            counter.put(c, counter.get(c) - 1);
            existsSet.add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stk.isEmpty()) {
            stringBuilder.append(stk.pollLast());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String s = removeDuplicateLetters.removeDuplicateLetters("ecbacba");
        System.out.println(s);
    }

}
