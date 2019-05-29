package org.ds.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Checks whether the graph is Cyclic.
 * @author Roshan
 *
 */
public class CyclicChecker {
	
	int totalNode;
	List<Integer> adjList[];
	
	public CyclicChecker(int totalNode) {
		this.totalNode = totalNode;
		adjList = new LinkedList[totalNode];
		
		for(int i = 0; i < totalNode; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	/**
	 * If during dfs traversal of node, one node is already 
	 * visited, that implies there exist a cycle.
	 * 
	 * @param node
	 * @param visit
	 * @return
	 */
	
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
	
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
		// As we are dealing with undirected Graph
		adjList[dest].add(src);
	}
	
	public boolean isCyclic() {
		//Create boolean to check if node is already visited
		
		
		
		for(int i = 0; i < totalNode; i++) {
			boolean[] visit = new boolean[totalNode];
			if(cyclicDfs(i, visit)) {
				return true;
			}
				
		}
		
		return false;
		
	}
	public static void main(String args[]) {
		// Create a graph given in the above diagram 
        CyclicChecker g1 = new CyclicChecker(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 0); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        if (g1.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
  
        CyclicChecker g2 = new CyclicChecker(3); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        if (g2.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
    } 
	}


