package testforfun;

import java.util.Comparator;
import java.util.PriorityQueue;

class Process2 {
	public int arrTime;
	public int exeTime;
	public Process2(int _arr, int _exe) {
		arrTime = _arr;
		exeTime = _exe;
	}
}

public class ShortestJobFirst {
	public static float Solution(int[] req, int[] dur) {
		if (req == null || req.length == 0 || dur == null || dur.length == 0 || req.length != dur.length) return 0;
		int len = req.length;
		int curTime = req[0];
		int waitTime = 0;
		PriorityQueue<Process2> queue = new PriorityQueue<Process2>(new Comparator<Process2>(){
			@Override
			public int compare(Process2 p1, Process2 p2) {
				if (p1.exeTime == p2.exeTime) {
					return p1.arrTime - p2.arrTime;
				}
				return p1.exeTime - p2.exeTime;
			}
		});
		
		int index = 1;
		queue.add(new Process2(req[0], dur[0]));
		while (!queue.isEmpty()) {
			Process2 curProcess = queue.poll();
			waitTime += curTime - curProcess.arrTime;
			curTime += curProcess.exeTime;
			for (; index < len && req[index] <= curTime; index++) {
				queue.add(new Process2(req[index], dur[index]));
			} 
		}
		return (float)waitTime / len;
	}
	
	
	
	
	
	public static float SJFaverage2(int[] request, int[] duration) {
		if (request == null || duration == null || request.length != duration.length) {
			return 0;
		}
		int index = 0;
		int len = request.length;
		int waitTime = 0;
		int curTime = 0;
		PriorityQueue<Process2> heap = new PriorityQueue<Process2>(new Comparator<Process2>() {
			public int compare(Process2 p1, Process2 p2) {
				if (p1.exeTime == p2.exeTime) {
					return p1.arrTime - p2.arrTime;
				}
				return p1.exeTime - p2.exeTime;
			}
		});
		while (!heap.isEmpty() || index < len) {
			if (!heap.isEmpty()) {
				Process2 cur = heap.poll();
				waitTime += curTime - cur.arrTime;
				curTime += cur.exeTime;
				while (index < len && curTime >= request[index]) {
					heap.offer(new Process2(request[index], duration[index++]));
				}
			} else {
				heap.offer(new Process2(request[index], duration[index]));
				curTime = request[index++];
			}
		}
		return (float) waitTime / len;
	}
	
	
	
	public static float SJFaverage3(int[] request, int[] duration) {
		int len = request.length;
		int[] end = new int[len];
		int curTime = 0;
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				curTime = duration[0];
				end[0] = duration[0];
			} else {
				int minDuration = Integer.MAX_VALUE;
				int curProcess = 0;
				for (int j = 0; j < len; j++) {
					if (end[j] != 0) {
						continue;
					}
					if (request[j] <= curTime) {
						if (duration[j] < minDuration) {
							minDuration = duration[j];
							curProcess = j;
						}
					} else {
						break;
					}
				}
				if (curProcess == 0) {
					curProcess = i;
					curTime = request[curProcess];
				}
				curTime = curTime + duration[curProcess];
				end[curProcess] = curTime;
			}
		}
		int waitSum = 0;
		for (int i = 0; i < len; i++) {
			waitSum += end[i] - request[i] - duration[i];
		}
		return (float) waitSum / (float) len;

	}
	
	
	
	
	public static void main(String[] args) {
		int[] a = {0, 1, 3, 9};
		int[] b = {2, 1, 7, 5};
		System.out.println(Solution(a, b));
	}
}
