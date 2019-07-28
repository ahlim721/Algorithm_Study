package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main1753 {
	
	static final int m = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int v = Integer.parseInt(input.split(" ")[0]);
		int e = Integer.parseInt(input.split(" ")[1]);
		int st = Integer.parseInt(br.readLine());
		int[] minV = new int[v+1];
		
		List<Map<Integer, Integer>> graph = new ArrayList<>();
		for(int i=0; i<=v; i++) {
			graph.add(new HashMap<>());
			if(i != st)
				minV[i] = m;
		}
		
		for(int i=0; i<e; i++) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			int val = Integer.parseInt(tmp[2]);
			if(graph.get(x).containsKey(y)) {
				if(graph.get(x).get(y) < val) continue;
				else {
					graph.get(x).put(y, val);
				}
			} else {
				graph.get(x).put(y, val);
			}
		}
		
		
		boolean[] visit = new boolean[v+1];
		int now = st;
		while(true) {
			visit[now] = true;
			for(int key : graph.get(now).keySet()) {
				int val =  graph.get(now).get(key);
				if(!visit[key] && minV[key] > minV[now] + val) {
					minV[key] = minV[now] + val;
				}
			}
			int min = m;
			int minIdx = 0;
			for(int i=1; i<minV.length; i++) {
				if(!visit[i] && min > minV[i]) {
					minIdx = i;
					min = minV[i];
				}
			}
			if(minIdx == 0) break;
			now = minIdx;
		}
		
		for(int i=1; i<minV.length; i++) {
			if(minV[i] == m) System.out.println("INF");
			else System.out.println(minV[i]);
		}
		
	}

}
