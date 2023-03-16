package leetcode.others;

import java.util.*;

public class CycleDetection {

    private List<Integer> cycleDetection(int[][] nums) {
        Map<Integer /*compileNum*/, Integer /*inDegree*/> inDegreeMap = new HashMap<>();
        Map<Integer /*compileNum*/, List<int[]>> inDegreeMappings = new HashMap<>();
        for (int[] numsItem :
                nums) {
            int fst = numsItem[0];
            if (!inDegreeMap.containsKey(fst)) {
                inDegreeMap.put(fst, 0);
            }
            int snd = numsItem[1];
            inDegreeMap.put(snd, inDegreeMap.getOrDefault(snd, 0)+1);

            inDegreeMappings.put(fst, inDegreeMappings.getOrDefault(fst, new ArrayList<>()));
            inDegreeMappings.get(fst).add(numsItem);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry :
                inDegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                Integer key = entry.getKey();
                for (int[] mappings : inDegreeMappings.get(key)) {
                    queue.add(mappings);
                }
                res.addLast(key);
            }
        }

        while (!queue.isEmpty()) {
            int qz = queue.size();
            for (int i = 0; i < qz; i++) {
                int[] item = queue.poll();
                int compileNum = item[1];
                int indegree = inDegreeMap.get(compileNum) - 1;
                if (indegree == 0) {
                    res.addLast(compileNum);
                    for (int[] mappings : inDegreeMappings.getOrDefault(compileNum, new ArrayList<>())) {
                        queue.add(mappings);
                    }
                }
                inDegreeMap.put(compileNum, indegree);
            }
        }

        if(res.size() != inDegreeMap.size()) {
            return new ArrayList<>();
        }
        return res;
    }

    public static void main(String[] args) {
        CycleDetection cycleDetection = new CycleDetection();
        int[][] nums = new int[][]{{0,1},{1,2},{2,3},{3,4},{4,2}};
        for (Integer integer : cycleDetection.cycleDetection(nums)) {
            System.out.println(integer);
        }

    }

}
