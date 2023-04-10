package leetcode.others;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegrees = new int[numCourses+1];
        Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int preCourse = prerequisite[1];
            int curCourse = prerequisite[0];

            inDegrees[preCourse]++;
            if (!prerequisitesMap.containsKey(curCourse)) {
                prerequisitesMap.put(curCourse, new ArrayList<>());
            }
            prerequisitesMap.get(curCourse).add(preCourse);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            int qz = queue.size();
            for (int i = 0; i < qz; i++) {
                int inDegreeCourse = queue.pollFirst();
                if (!prerequisitesMap.containsKey(inDegreeCourse)) {
                    continue;
                }

                List<Integer> inList = prerequisitesMap.get(inDegreeCourse);
                for (int j = 0; j < inList.size(); j++) {
                    inDegrees[inList.get(j)]--;
                    if (inDegrees[inList.get(j)] == 0) {
                        queue.addLast(inList.get(j));
                    }
                }
            }
        }

        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] != 0 ) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        prerequisites = new int[][]{{1,0}};
        prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        boolean canFinish = courseSchedule.canFinish(4, prerequisites);
        System.out.println(canFinish);
    }

}
