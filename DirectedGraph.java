/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodriguez
 *
 * Programming Assignment #3
 *
 * In this program, we will deal with a Directed Graph which is
 * a graph that has directed edges, some of them being two-way or just
 * one-way. We implemented this directed graph using an adjacency list
 * due to the fact that the adjacency matrix for the application was
 * sparse and it is more practical to utilize the adjacency list.
 * 
 * 
 * 
 *
 * Kevin Grossi
 */
package edu.csupomona.cs.cs241.prog_assgmnt_3;
import java.util.*;

/**
 * The Directed Graph class utilizes the subclass Edge in order
 * to create the weighted edges needed in order to perfectly
 * visualize the graph.
 * 
 * @author Kevin
 *
 */
public class DirectedGraph {
	
	private int size; // Number of vertices
	private ArrayList<LinkedList<Edge>> neighbors; // Adjacency lists
	private ArrayList<String> labels; // Vertex labels

	/**
	 * Edge class used by the Directed Graph Class. 
	 * 
	 * @author Kevin
	 *
	 */
	public static class Edge {
	private int v1;
	private int v2;
	private String direction;
	private int weight;

	/**
	 * Creates an edge between two passed in vertices with an associated
	 * weight and direction.
	 * 
	 * @param v1 start vertex
	 * @param v2 end vertex
	 * @param weight weight of edge
	 * @param direction direction of edge
	 */
	public Edge(int v1, int v2, int weight, String direction) {
		this.v1 = v1;
		this.v2 = v2;
		this.direction = direction;
		this.weight = weight;
		}
	}

	
	/**
	 * This constructor makes a graph with the passed in number of
	 * vertices and has no current edges. 
	 * 
	 * @param s s would be the size or number of vertices. 
	 */
	public DirectedGraph(int s) {
		size = s;
		neighbors = new ArrayList<LinkedList<Edge>>(size);
		for (int i=0; i<size; i++)
			neighbors.add(new LinkedList<Edge>());
		
		labels = new ArrayList<String>(size);
		for (int i=0; i<size; i++)
			labels.add(Integer.toString(i));
	}
	
	
		/**
		 * Creates an edge between two passed in vertexes of the Graph.
		 * This only adds the edge one way. 
		 * 
		 * @param v1 starting vertex
		 * @param v2 ending vertex
		 * @param weight weight of edge between vertex
		 * @param direction direction of edge
		 */
		public void addEdge(int v1, int v2, int weight, String direction) {
			Edge edge1 = new Edge(v1, v2, weight, direction);
			neighbors(v1).add(edge1);
			
		}
		
		
		/**
		 * Sets the name/label of the passed in vertex index.
		 * 
		 * @param v index of the vertex in the list
		 * @param label name of the vertex
		 */
		public void setLabel(int v, String label) {
			labels.set(v, label);
		}
		
		
		/**
		 * Given the label of the vertex in the graph, return the index.
		 * 
		 * @param label name of vertex
		 * @return returns the index of the labeled vertex
		 */
		public int getVertexNumber(String label) {
			for (int i=0; i<size; i++)
				if (labels.get(i).equals(label))
					return i;
			return -1;
		}

		
		/**
		 * Given the index of the vertex, return the edges associated
		 * with said vertex
		 * 
		 * @param v passed in index to reference vertex list
		 * @return list of edges associated with the vertex
		 */
		public LinkedList<Edge> neighbors(int v) {
			return neighbors.get(v);
		}

		
		/**
		 * Returns the number of vertices in the associated graph.
		 * 
		 * @return number of vertices
		 */
		public int size() {
			return size;
		}

		
		/**
		 * This displays the graph in a manner of showing each vertex
		 * and their associated edges akin to the adjacency list
		 * representation. 
		 */
		public void print() {
			for (int i=0; i<size; i++) {
				System.out.print(labels.get(i)+" -> ");
				for (Edge edge : neighbors(i))
					System.out.print(labels.get(edge.v2)+"("+edge.weight+") ");
						System.out.println();
			}
		}
	
		
		/**
		 * Finds the closest node with the least cost of the given source
		 * vertex. Populates the parent array. 
		 * 
		 * @param s source vertex of the graph
		 * @param length number of vertices in the graph
		 * @param parent parent array that will be populated for use in other methods
		 */
		public void bfs(int s, int[] length, int[] parent) {

			for (int i=0; i<size; i++) {
				length[i] = Integer.MAX_VALUE;
				parent[i] = -1;
			}

			length[s] = 0;
			parent[s] = s;

			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.addLast(s);

			while (!queue.isEmpty()) {
				s = queue.pollFirst();
				
				for (Edge edge : neighbors(s)) {
					if (parent[edge.v2] == -1) {
						
						length[edge.v2] = length[s] + 1;
						parent[edge.v2] = s;
						queue.addLast(edge.v2);
					}
				}
			}
		}

		
		/**
		 * Given a source vertex, will populate the given array with the 
		 * distances between the source vertex and the other vertices. Finds the 
		 * shortest path between all vertices given a source. 
		 * 
		 * @param s source vertex
		 * @param distance array that will contain the distance between vertices
		 * @param parent parent array that will be populated
		 */
		public void dijkstra(int s, double[] distance, int[] parent) {

			for (int i=0; i<size; i++) {
				distance[i] = Double.MAX_VALUE;
				parent[i] = -1;
			}

			distance[s] = 0;
			parent[s] = s;

			PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
			for (int i=0; i<size; i++) {
				queue.offer(new Vertex(i, distance[i]));
			}

			while (!queue.isEmpty()) {
				Vertex v1 = queue.poll();
				
				for (Edge edge : neighbors(v1.v)) {
					if (distance[edge.v2] > distance[edge.v1]+edge.weight) {
						
						Vertex neighbor = new Vertex(edge.v2, distance[edge.v2]);
						queue.remove(neighbor);
						
						distance[edge.v2] = distance[edge.v1]+edge.weight;
						parent[edge.v2] = edge.v1;
						
						neighbor.priority = distance[edge.v2];
						queue.offer(neighbor);
					}
				}
			}
		}
		
		
		/**
		 * 
		 * Private Class for use in Dijkstra
		 * @author Kevin
		 *
		 */
		private class Vertex implements Comparable<Object> {
			int v;
			double priority;
			
			public Vertex(int v, double p) {
				this.v = v;
				priority = p;
			}

			
			
			/* (non-Javadoc)
			 * @see java.lang.Comparable#compareTo(java.lang.Object)
			 */
			public int compareTo(Object obj) {
				assert(obj instanceof Vertex);
				
				Vertex other = (Vertex)obj;
				if (this.priority < other.priority)
					return -1;
				else if (this.priority > other.priority)
					return 1;
				else
					return 0;
			}
		}

		
		/**
		 * Given a source and destination and a populated parent array
		 * find the shortest path between these two vertexes. Prints out the 
		 * mentioned shortest path. 
		 * 
		 * @param s source vertex
		 * @param d destination vertex
		 * @param parent parent array
		 */
		public void printPath(int s, int d, int[] parent) {
			
			
			if (parent[d] == -1)
				System.out.println("no path from "+labels.get(s)+" to "+labels.get(d));

			else {
				
				String path = "\nDrive " + edgeWeight(d-1, d) + " miles" + " to arrive at "+labels.get(d);
				System.out.print(d);
				while (parent[d] != s) {
					d = parent[d];
					path = "\nDrive " + edgeWeight(parent[d],d) + " miles" + " to "+labels.get(d)+path;
					
				}

				path = "Starting from " + labels.get(s)+path;
				System.out.println(path);
			}
		}
		
		/**
		 * Same as printPath but attempted to create a separate method for the 
		 * navigation portion of the Los Santos application. Incomplete. Attempted
		 * to add in a scanner to read in the 'Next' prompt. 
		 * 
		 * @param s source vertex
		 * @param d destination vertex
		 * @param parent paret array
		 */
		public void printPathSteps(int s, int d, int[] parent) {
			
			Scanner sc = new Scanner(System.in);
			String prompt;
			
			if (parent[d] == -1)
				System.out.println("no path from "+labels.get(s)+" to "+labels.get(d));

			else {
				String path = "\nDrive " + edgeWeight(d+1, d) + " mile(s) to arrive at "+labels.get(d);
				
				while (parent[d] != s) {
					d = parent[d];
					path = "\nDrive " + edgeWeight(parent[d],d) + " miles(s) to "+labels.get(d)+path;
					
				}

				path = "Starting from " + labels.get(s)+path;
				System.out.println(path);
			}
			sc.close();
		}
		
		
		/**
		 * Given two vertexes, return the weight of the edge between them. 
		 * 
		 * @param v1 start vertex
		 * @param v2 end vertex
		 * @return weight of the edge
		 */
		public int edgeWeight(int v1, int v2) {
			for (Edge edge : neighbors(v1)) {
				if (edge.v2 == v2)
					return edge.weight;
			}
			return Integer.MAX_VALUE;
		}
		
		
		/**
		 * Given the index of the vertex, return the associated label. 
		 * 
		 * @param v index of vertex
		 * @return name of vertex
		 */
		public String getLabel(int v) {
			return labels.get(v);
		}

		
}
