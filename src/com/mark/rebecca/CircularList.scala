package com.mark.rebecca

class CircularList (val length : Int){

  def makeList : Node = {

    val unlinkedNodes = (1 to length) collect {case n => new Node (n)}

    for (n <- 0 to unlinkedNodes.length - 1) {
      if (n == unlinkedNodes.length - 1) {
        unlinkedNodes(n).next = unlinkedNodes.head
      } else {
        unlinkedNodes(n).next = unlinkedNodes(n + 1)
      }
    }
    unlinkedNodes.head
  }
}
