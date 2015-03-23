package com.mark.rebecca

class Kill (length: Int, start: Int, skip: Int){
  // this returns a single head node, but it's a circular linked list
  var circularList = new CircularList( length ).makeList

  // the start function should do cycle detection and return the node whose value is = to integer
  def startPoint(circularList : Node, start : Int, depth : Int ) : Node = {
    if (depth > length) {
      throw new IllegalArgumentException("Hey that start point is not in the list.")
    }
    if (circularList.value == start) {
      return circularList
    } else {
      startPoint(circularList.next, start, depth + 1)
    }
  }

  // still need to reassign last node's next to itself... and remove things from circle?
  // maybe a way to treat startingNode as a var in signature?
  def skipUntilLast( startingNode : Node, skip : Int) : Node = {
   // startingNode needs to be mutatable, so reassign to var
    var variableNode = startingNode

    // advance through list and return the node to kill off.
    for (i <- 1 to skip) {
      variableNode = variableNode.next
    } yield variableNode

    // remove the person by resetting the next pointer to skip them.
    // reassign startingNode to the person after the removal.
    variableNode.next = variableNode.next.next

    // basecase, but I still need to reassign last node to itself...
    if (variableNode.next == variableNode) {
      variableNode
    } else {
      skipUntilLast(variableNode , skip)
    }
  }
}
