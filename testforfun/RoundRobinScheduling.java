package testforfun;

import java.util.LinkedList;
import java.util.Queue;

class Process {
	int aTime;
	int eTime;
	public Process(int x, int y) {
		aTime = x;
		eTime = y;
	}
}

public class RoundRobinScheduling {
	public static float Solution(int[] Atime, int[] Etime, int q) {
		if (Atime == null || Etime == null || Atime.length <= 1 || Etime.length <= 1 || Atime.length != Etime.length) return 0;
		int len = Atime.length;
		// use queue data structure to recored every process
		Queue<Process> queue = new LinkedList<Process>();
		// cutTime is total time from 0 till now, waitTime is total waiting time
		int curTime = Atime[0];
		int waitTime = 0;
		queue.add(new Process(Atime[0], Etime[0]));
		// index of all original process	
		int index = 1;
		while (!queue.isEmpty()) {
			Process curProcess = queue.poll();
			// add current process waiting time into total wait time
			waitTime += curTime - curProcess.aTime;
			// move current time towards to the end of current process
			curTime += curProcess.eTime < q ? curProcess.eTime : q;
			// add all process into queue which arrival time is before current time
			for (; index < len && Atime[index] <= curTime; ++index) {
				queue.add(new Process(Atime[index],Etime[index]));
			}
			// if current process execute time is larger than quantum, then
			// divide current process to a new process and add at the end of queue
			if (curProcess.eTime > q) {
				queue.add(new Process(curTime, curProcess.eTime - q));
			}
		}
		return (float)waitTime / len;
	}
	
	
	public static void main(String[] args) {
		int[] atime = {0, 1, 3, 9};
		int[] btime = {2, 1,7, 5};
		System.out.println(Solution(atime, btime, 2));
	}
}
