import java.util.List;

public class GraphMatrix {
    List<Vertex> V;
    List<List<Edge>> E;
    
}
enum VStatus{UNDISCOVERED, DISCOVERED, VISITED}
class Vertex{
    public int data;
    public int inDegree, outDegree;
    public VStatus status;
    public int dTime, fTime;
    public int parent;
    public int priority;
    public Vertex(int data){
        this.data = data;
        inDegree = 0;
        outDegree = 0;
         status = VStatus.UNDISCOVERED;
         dTime = -1;
         fTime = -1;
         priority = Integer.MAX_VALUE;
    }
}
enum EStatus{UNDETERMINED, TREE, CROSS, FORWARD, BACKWARD}
class Edge{
    public int data;
    public int weight;
    public EStatus status;
    public Edge(int d, int w){
        this.data = d;
        this.weight = w;
    }


}