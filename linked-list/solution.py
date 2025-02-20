class LinkedList:
    def __init__(self):
        self.head = None
    
    def get(self, index: int) -> int:
        node = self.head

        for p in range(index):
            if node is not None:
                node = node.link
        
        return node.value if node is not None else -1

    def insertHead(self, val: int) -> None:
        new_head = ListNode(val)
        if self.head is not None:
            new_head.link = self.head
        self.head = new_head

    def insertTail(self, val: int) -> None:
        if self.head is None:
            self.head = ListNode(val)
            return

        node = self.head
        prev = self.head

        while node is not None:
            prev = node
            node = node.link
        
        prev.link = ListNode(val)

    def remove(self, index: int) -> bool:
        if index == 0:
            if self.head is None:
                return False
            self.head = self.head.link
            return True

        node = self.head
        prev = self.head
        for p in range(index):
            if node is None:
                return False
            
            prev = node
            node = node.link
        
        if node is None:
            return False

        prev.link = node.link
        return True

    def getValues(self) -> List[int]:
        values = []
        node = self.head
        while node is not None:
            values.append(node.value)
            node = node.link
        return values
        

class ListNode:
    def __init__(self, val):
        self.link = None
        self.value = val
