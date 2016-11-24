from collections import deque

class Node:
  def __init__(self, location,value):
    self.location = location
    self.value = value
    self.next = []
  def addNext(self, node):
    self.next.append(node)

def findShortestPath( maze , start, end ):
   def bfs( maze, start, end ):
       queue = deque()
       level_map = [] 
       node_map = {} # key : location, value : node
       for row in len(maze):
           for col in len(row):
               node = Node( (row,col), maze[row][col] )
               node_map[(row,col)] = node
       for row in len(maze)-1:
           for col in len(row)-1:
               node = node_map[(row,col)]
               if node.value == 'O':
                   next_node = node_map[(row+1,col+1)]
                   if next_node.value == 'O':
                       node.addNext(next_node)
                       next_node.addNext(node)
       level_map = [] 

def test1():
   maze = [ 'OOXOO',
            'OOOXO',
            'OXOOO',
            'XOOOO' ]
   assert findShortestPath( maze, (0,0), (2,3) ) == 6

if __name__ == '__main__':
    test1()
