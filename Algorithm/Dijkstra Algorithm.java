An example of Diskstra Algorithm is illustrated with example.
  
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
  
  
  
Solution : 

class Solution {
    private class Dijkstra{
        private int[][] graph;
        public Dijkstra(int[][] graph){
            this.graph=graph;
        }
        private int findMinDistance(int[] distance,Set<Integer> seen){
            int minVal=Integer.MAX_VALUE;
            int minIdx=-1;
            for(int i=0;i<distance.length;i++){
                if(!seen.contains(i)&&distance[i]<minVal){
                    minVal=distance[i];
                    minIdx=i;
                }
            }//~~
            return minIdx;
        }//~
        public List<Integer> apply(int source) {
            int count=graph.length;
            //Array for output with init
            int[] distance=new int[count];
            Arrays.fill(distance,Integer.MAX_VALUE);
            //Set visited node
            Set<Integer> seen=new HashSet<Integer>();
            
            distance[source]=0;
            for(int i=0;i<count-1;i++) {
                //r is the row and c is the column
                int r=findMinDistance(distance,seen);
                //Variant when node is in isolation
                if (r<0) continue;
                seen.add(r);
                for(int c=0;c<count;c++) {
                    //graph[r][c] != 0 -> there should be a direct edge
                    if(!seen.contains(c)&&graph[r][c]!=-1&&distance[r]+
                       graph[r][c]<distance[c])
                       distance[c]=distance[r]+graph[r][c]; 
                    
                }//~~~             
            }//~~
            return IntStream.of(distance).boxed().collect(Collectors.toCollection(ArrayList<Integer>::new));            
        }//~
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph=IntStream.range(0,N).mapToObj(
            i->IntStream.range(0,N).map(j->-1).toArray()).toArray(int[][]::new);
            
        for(int[] row:times){
            graph[row[0]-1][row[1]-1]=row[2];
        }//~
        Dijkstra dijkstra=new Dijkstra(graph);
        List<Integer> list=dijkstra.apply(K-1);
        
        int max=list.stream().mapToInt(i->i).max().getAsInt();
        return max==Integer.MAX_VALUE?-1:max;
    }
}
