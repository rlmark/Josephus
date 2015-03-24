package com.mark.rebecca

class Kill (length: Int, start: Int, skip: Int){
  // this returns a single head node, but it's a circular linked list
  var circularList = new CircularList( length ).makeList

  // the start function should do cycle detection and return the node whose value is = to integer
  def startPoint(circularList : Node, depth : Int ) : Node = {
    if (depth > length) {
      throw new IllegalArgumentException("Hey that start point is not in the list.")
    }
    if (circularList.value == start) {
      return circularList
    } else {
      startPoint(circularList.next, depth + 1)
    }
  }

  // The skip function
  def lastManStanding( startingNode : Node) : Node = {

   // startingNode needs to be mutable, so reassign to var
    var variableNode = startingNode
    println(variableNode.value + " initial val for funct")

    // advance through list and return the node to kill off.
    for (i <- 1 to skip) {
      println(variableNode.value + " at start of for loop")
      variableNode = variableNode.next
      println(variableNode.value + " at end of for loop")
    }

    // remove the person by resetting the next pointer to skip them.
    println(variableNode.next.value + " SKIPPED")
    variableNode.next = variableNode.next.next

    // base case
    if (variableNode.next == variableNode) {
      println(variableNode.value + " final")
      variableNode
    } else {
      lastManStanding(variableNode)
    }
  }
}

