class Deque:
    
    def __init__(self):
        self.head = None
        self.tail = None

    def isEmpty(self) -> bool:
        return self.head is None

    def append(self, value: int) -> None:
        node = Node(value)
        if self.head is not None:
            node.pre = self.head
            self.head.nex = node
            
        if self.tail is None:
            self.tail = node

        self.head = node

    def appendleft(self, value: int) -> None:
        node = Node(value)

        if self.tail is not None:
            node.nex = self.tail
            self.tail.pre = node

        if self.head is None:
            self.head = node

        self.tail = node

    def pop(self) -> int:
        if self.head is None:
            return -1

        tmp = self.head

        self.head = self.head.pre
        if self.head is None:
            self.tail = None
        else:
            self.head.nex = None

        return tmp.value

    def popleft(self) -> int:
        if self.tail is None:
            return -1

        tmp = self.tail
        self.tail = self.tail.nex
        if self.tail is None:
            self.head = None
        else:
            self.tail.pre = None

        return tmp.value
        

class Node:
    def __init__(self, val):
        self.value = val
        self.nex = None
        self.pre = None
