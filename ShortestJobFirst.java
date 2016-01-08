package oatwo;

import java.util.Comparator;
import java.util.PriorityQueue;








public class ShortestJobFirst {
	
	static class Process2 {
		int aTime, eTime;
		public Process2(int x, int y){
			this.aTime = x;
			this.eTime = y;
		}
	}
	/*
	 * Solution is to get the average waiting time of jobs in SJF rule.
	 * Return average wait time.
	 * 
	 * @Param {int[]} arrTime - the array of job's arrive time sequence.
	 * @Param {int[]} exeTime - the array of job's executive time sequence.
	 */
	public static float Solution(int[] arrTime, int[] exeTime) {
		
		// Hande illegal input
		if (arrTime == null || arrTime.length == 0 || exeTime == null || exeTime.length == 0 || exeTime.length != arrTime.length) return 0;
		int len = arrTime.length;
		
		// curTime is total time from beginning till now
		// waitTime is total waiting time
		int curTime = arrTime[0];
		int waitTime = 0;
		
		// Use a PriorityQueue to recored every process
		PriorityQueue<Process2> queue = new PriorityQueue<Process2>(arrTime.length, new Comparator<Process2>() {
			@Override
			public int compare(Process2 p1, Process2 p2) {
				if (p1.eTime == p2.eTime) {
					return p1.aTime - p2.aTime;
				}
				return p1.eTime - p2.eTime;
			}
		});
		
		// Index of all original process
		int index = 1;
		queue.add(new Process2(arrTime[0], exeTime[0]));
		while (!queue.isEmpty()) {
			Process2 curProcess = queue.poll();
			
			// Add current process waiting time into total wait time.
			waitTime += curTime - curProcess.aTime;
			
			// Move current time towards to the end of current process
			curTime += curProcess.eTime;
			
			// Add all process into queue which arrive time is before current time 
			for (; index < len && arrTime[index] <= curTime; index++) {
				queue.add(new Process2(arrTime[index], exeTime[index]));
			}
		}
		return (float) waitTime / len;
	}
	
	public static void main(String[] args) {
		int[] a = {0, 0, 3, 9};
		int[] b = {2, 1, 7, 5};
		System.out.println(Solution(a, b));
	}
}
