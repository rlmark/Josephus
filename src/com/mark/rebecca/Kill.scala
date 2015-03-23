package com.mark.rebecca

class Kill (length: Int, start: Int, skip: Int){
  // this returns a single head node, but it's a circular linked list
  var circularList = new CircularList( length ).makeList

  // the start function should do cycle detection and return the node whose value is = to integer
  def startPoint(circularList : Node, start : Int, depth : Int = 0) : Node = {
    if (depth > length) {
      throw new IllegalArgumentException("Hey that start point is not in the list.")
    }
    if (circularList.value == start) {
      return circularList
    } else {
      startPoint(circularList.next, start, depth + 1)
    }
  }
  // maybe move the startPoint function to another class?

  // still need to reassign last node's next to itself... and remove things from circle?
  def skipUntilLast(startingNode : Node, skip : Int) : Node = {
    for (i <- 1 to skip) {
      startingNode.next = 
    }
    if (startingNode.next == startingNode) {
      startingNode
    } else {
      skipUntilLast(startingNode.next , skip)
    }
  }
}
