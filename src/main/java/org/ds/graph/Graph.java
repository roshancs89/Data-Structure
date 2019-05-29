package org.ds.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	
	int totalNode;
	List<Integer> adjList[];
	
	public Graph(int totalNode) {
		this.totalNode = totalNode;
		adjList = new LinkedList[totalNode];
		
		for(int i = 0; i < totalNode; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
		// As we are dealing with undirected Graph
		adjList[dest].add(src);
	}
	
	public int connectedComponents() {
		//Create boolean to check if node is already visited
		boolean[] visit = new boolean[totalNode];
		int components = 0;
		
		for(int i = 0; i < totalNode; i++) {
			
			if(!visit[i]) {
				components++;
				dfsUtil(i, visit);
				//System.out.println();
			}
		}
		
		return components;
		
	}
	
	//DFS traversal 
	private void dfsUtil(int node, boolean[] visit) {
		
		visit[node] = true;
		//System.out.print(node+"->");
		
		for(int i = 0; i < adjList[node].size();i++) {
			if(!visit[adjList[node].get(i)])
				dfsUtil(adjList[node].get(i), visit);
		}
		
		
	}
	
	private boolean cyclicDfs(int node, boolean[] visit) {
		visit[node] = true;
		
		for(int i = 0; i < adjList[node].size();i++) {
			if(!visit[adjList[node].get(i)]) {
				cyclicDfs(adjList[node].get(i),visit);
			}else {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) throws Exception{ 
        // Create a graph given in the above diagram
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		String st = inp.readLine();
		String[] str = st.split(" ");
		int totalNode = Integer.parseInt(str[0]);
		int totalEdge = Integer.parseInt(str[1]);
		int component = Integer.parseInt(str[2]);
		
		Graph g = new Graph(totalNode); // 5 vertices numbered from 0 to 4
		
		int cnt = 0;
		while(cnt++ < totalEdge) {
			String[] edgeStr = inp.readLine().split(" ");
			int src = Integer.parseInt(edgeStr[0]);
			int dest = Integer.parseInt(edgeStr[1]);
			g.addEdge(src-1, dest-1);
		} 
		
        //System.out.println("Following are connected components"); 
        int totalComponents = g.connectedComponents();
        System.out.println(totalComponents);
        if(totalComponents > component)
        	System.out.println("-1");
        else
        	System.out.println(totalEdge - (totalNode - component));
    } 

}
