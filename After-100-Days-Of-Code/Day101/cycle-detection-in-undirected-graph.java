//Link: https://www.codingninjas.com/codestudio/problems/1062670?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

//DFS
//Time & Space: O(N) O(N)
import java.util.*;
public class Solution {

    static boolean dfs(int node, int par, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it]==0){
                if(dfs(it, node, vis, adj)==true){
                    return true;
                }
            }else if(it!=par){
                return true;
            }
        }
        return false;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int[] vis = new int[n+1];
        for(int i=1; i<=n; i++){
            if(vis[i]==0){
                if(dfs(i, -1, vis, adj)==true){
                    return "Yes";
                }
            }
        }
        
        return "No";
    }
}

//BFS
//Time & Space: O(N) O(N)
import java.util.*;
public class Solution {
    static class Node {
        int node, par;
        Node(int n, int p){
            node = n;
            par = p;
        }
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int[] vis = new int[n+1];
        for(int i=1; i<=n; i++){
            if(vis[i]==0){
                Queue<Node> q = new LinkedList<>();
                q.add(new Node(i, -1));
                vis[i] = 1;
                while(!q.isEmpty()){
                    Node node = q.poll();
                    for(int it : adj.get(node.node)){
                        if(vis[it]==0){
                            q.add(new Node(it, node.node));
                            vis[it]=1;
                        }else if(it!=node.par){
                            return "Yes";
                        }
                    }
                }
            }
        }
        return "No";
    }    
}
