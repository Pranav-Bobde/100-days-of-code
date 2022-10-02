//Link: https://www.codingninjas.com/codestudio/problems/1062626?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

//BFS
//Time & Space: O(N) O(N)
import java.util.*;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
      int[] vis = new int[n+1];
      int[] currVis = new int[n+1];
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i=0; i<n+1; i++){
          adj.add(new ArrayList<>());
      }
      for(ArrayList<Integer> al : edges){
          adj.get(al.get(0)).add(al.get(1));
      }
      Set<Integer> s=new HashSet<>();
      for(int i=1; i<=n; i++){
          if(vis[i]==0){
              Queue<Integer> q = new LinkedList<>();
              q.add(i);
              vis[i] = 1;
              s.add(i);
              while(!q.isEmpty()){
                  int node = q.poll();
                  for(int it : adj.get(node)){
                      if(vis[it]==0){
                          q.add(it);
                          vis[it]=1;
                      }else if(s.contains(it)){
                          return true;
                      }
                  }
              }
          }
          s.clear();
      }
      return false;
  }
}

//DFS
//Time & Space: O(N) O(N)
import java.util.ArrayList;
public class Solution {
    static boolean dfs(int node, int[] vis, int[] currVis, ArrayList < ArrayList < Integer >> adj){
        vis[node] = currVis[node] = 1;
        for(int n : adj.get(node)){
            if(vis[n]==0){
                if(dfs(n, vis, currVis, adj)==true){
                    return true;
                }
            }else if(currVis[n]==1){
              return true;
          }
        }
        currVis[node] = 0;
        return false;
    }
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
      int[] vis = new int[n+1];
      int[] currVis = new int[n+1];
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i=0; i<n+1; i++){
          adj.add(new ArrayList<>());
      }
      for(ArrayList<Integer> al : edges){
          adj.get(al.get(0)).add(al.get(1));
      }
      for(int i=1; i<=n; i++){
          if(vis[i]==0){
              if(dfs(i, vis, currVis, adj)==true){
                  return true;
              }
          }
      }
      return false;
  }
}
