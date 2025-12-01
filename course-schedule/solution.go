func canFinish(numCourses int, prerequisites [][]int) bool {
    if len(prerequisites) == 0 {
        return true
    }

    adjList := make(map[int][]int)

    for _, pair := range prerequisites {
        if pair[0] == pair[1] {
            return false
        }

        node, ok := adjList[pair[0]]

        if !ok {
            node = make([]int, 0)
        }
        node = append(node, pair[1])
        adjList[pair[0]] = node
    }

    for k, _ := range adjList {
        if hasLoop(k, make(map[int]bool), adjList) {
            return false
        }
    }

    return true
}

func hasLoop(node int, visit map[int]bool, adjList map[int][]int) bool {
    if _, ok := visit[node]; ok {
        return true
    }

    visit[node] = true;
    for _, e := range adjList[node] {
        doneDid := hasLoop(e, visit, adjList)
        if doneDid {
            return true
        }
    }

    delete(visit, node)
    return false;
}

