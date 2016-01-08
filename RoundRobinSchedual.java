package oatwo;

import java.util.LinkedList;
import java.util.Queue;

class Process{
	int aTime, eTime;
	public Process(int x, int y) {
		this.aTime = x;
		this.eTime = y;
	}
}

public class RoundRobinSchedual {
	/*
	 * Solution is to count the average wait time of job sequences.
	 * Return a float which is the average wait time.
	 * 
	 * 
	 * @Param {int[]} arrTime - the sequence of arrive time of each job.
	 * @Param {int[]} exeTime - the sequence of execution time of each job.
	 * @Param {int} q - quantum.
	 */
	public static float Solution(int[] arrTime, int[] exeTime, int q) {
		
		// Handle illegal case.
		if (arrTime == null || arrTime.length == 0 || exeTime == null || exeTime.length == 0 || arrTime.length != exeTime.length) return 0;

		int len = arrTime.length;
		
		// Use queue data structure to recored every process.
		Queue<Process> queue = new LinkedList<Process>();
		
		// curTime is total time from beginning till now
		// waitTime is total waiting time
		int curTime = arrTime[0];
		int waitTime = 0;
		queue.add(new Process(arrTime[0], exeTime[0]));
		
		// Index of all original process
		int index = 1;
		while (!queue.isEmpty()) {
			Process curProcess = queue.poll();
			
			// Add current process waiting time into total wait time.
			waitTime += curTime - curProcess.aTime;
			
			// Move current time towards to the end of current process
			curTime += curProcess.eTime < q ? curProcess.eTime : q;
			
			// Add all process into queue which arrive time is before current time 
			for (; index < len && arrTime[index] <= curTime; index++) {
				queue.add(new Process(arrTime[index], exeTime[index]));
			}
			
			// If current process execute time is larger than quantum, then
			// divide current process to a new process and add at the end of queue.
			if (curProcess.eTime > q) {
				queue.add(new Process(curTime, curProcess.eTime - q));
			}
		}
		
		return (float) waitTime / len;
	}
	
	public static void main(String[] args) {
		int[] atime = {0, 1, 3, 9};
		int[] btime = {2, 1,7, 5};
		System.out.println(Solution(atime, btime, 2));
	}
}
