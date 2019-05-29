package org.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {
	
	public static void main(String args[]) {
		
		
		int node = 4;
		
		List<Integer> adjacencyList[] = new LinkedList[node];
		
		for(int i = 0; i < node; i++) {
			adjacencyList[i] = new LinkedList();
		}
		
		for(int i = 1; i < 3; i++) {
			adjacencyList[i].add(i+1);
		}
		
		for(int i =0 ; i < node; i++) {
			for(int j = 0; j < adjacencyList[i].size();j++) {
				if(j == adjacencyList[i].size()-1) {
					System.out.print(adjacencyList[i].get(j));
				}else {
					System.out.print(adjacencyList[i].get(j)+"-->");
				}
			}
			System.out.println();
		}
		//for(int i = 0;)
	}

}
