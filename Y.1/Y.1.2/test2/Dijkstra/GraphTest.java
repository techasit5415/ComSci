package Dijkstra;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
public class GraphTest {

  // @Test
  // public void testShortestPath1() {
  //   Graph graph = this.constructGraph();
  //   List<String> result = graph.shortestPath("A", "F");
  //   System.out.println("shortest path between A and F: " + result);
  //   assertEquals(result.size(), 5);
  //   assertEquals(result.get(0), "A");
  //   assertEquals(result.get(1), "C");
  //   assertEquals(result.get(2), "B");
  //   assertEquals(result.get(3), "D");
  //   assertEquals(result.get(4), "F");
  // }

  // @Test
  // public void testShortestPath2() {
  //   Graph graph = this.constructGraph();
  //   List<String> result = graph.shortestPath("D", "A");
  //   System.out.println("shortest path between D and A: " + result);
  //   assertEquals(result.size(), 4);
  //   assertEquals(result.get(0), "D");
  //   assertEquals(result.get(1), "B");
  //   assertEquals(result.get(2), "C");
  //   assertEquals(result.get(3), "A");
  // }

  // @Test
  // public void testShortestPath3() {
  //   Graph graph = this.constructGraph();
  //   List<String> result = graph.shortestPath("C", "Z");
  //   System.out.println("shortest path between C and Z: " + result);
  //   assertEquals(result.size(), 4);
  //   assertEquals(result.get(0), "C");
  //   assertEquals(result.get(1), "E");
  //   assertEquals(result.get(2), "D");
  //   assertEquals(result.get(3), "Z");
  // }


  /**
   * Create a graph for testing
   *
   *
   *         B    6     D   7
   *    3  .-+---------------------Z
   *    .-'   '.        |        .'
   * A.'        '.5     |      .'
   *   `.         '.    |2   .'12
   *    4`-.        '.  |  .'
   *        `+--------'.+.'
   *         C     6    E
   *
   *
   */
  private Graph constructGraph() {
    Graph graph = new Graph();
    graph.addEdge("A", "B", 3);
    graph.addEdge("A", "C", 4);
    graph.addEdge("B", "D", 6);
    graph.addEdge("B", "E", 5);
    graph.addEdge("C", "E", 6);
    graph.addEdge("D", "E", 2);
    graph.addEdge("D", "Z", 7);
    graph.addEdge("E", "Z", 12);
    return graph;
  }
}