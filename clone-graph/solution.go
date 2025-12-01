/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Neighbors []*Node
 * }
 */

func cloneGraph(node *Node) *Node {
    if node == nil {
        return nil
    }
    start := node.Val
    adjList := make(map[int][]int)
    queue := make([]*Node, 0)
    queue = append(queue, node)

    for len(queue) > 0 {
        node = queue[0]
        queue = queue[1:]

        neighborList := make([]int, len(node.Neighbors))
        for i, n := range node.Neighbors {
            neighborList[i] = n.Val        
            if _, ok := adjList[n.Val]; !ok {
                queue = append(queue, n)
            }
        }
        adjList[node.Val] = neighborList
    }

    nodes := make(map[int]*Node)
    for k, _ := range adjList {
        node := Node{
            Val: k,
            Neighbors: make([]*Node, 0),
        }
        nodes[k] = &node
    }

    for k, v := range adjList {
        node := nodes[k]
        for _, adj := range v {
            node.Neighbors = append(node.Neighbors, nodes[adj])
        }
    }

    return nodes[start]
}

