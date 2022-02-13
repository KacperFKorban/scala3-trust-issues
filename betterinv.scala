//> using scala "3.1.1"

import Tree.*

def betterInvertTree(tree: Tree): Tree =
  tree match
    case Leaf =>
      Leaf
    case Node(Leaf, 1, Leaf) =>
      Node(Leaf, 1, Leaf)
    case Node(Node(Leaf, 1, Leaf), 2, Node(Leaf, 3, Leaf)) =>
      Node(Node(Leaf, 3, Leaf), 2, Node(Leaf, 1, Leaf))
    case Node(Leaf, 1, Node(Leaf, 2, Leaf)) =>
      Node(Node(Leaf, 2, Leaf), 1, Leaf)
    case Node(Node(Node(Leaf, 1, Leaf), 2, Leaf), 3, Node(Node(Leaf, 4, Leaf), 5, Leaf)) =>
      Node(Node(Leaf, 5, Node(Leaf, 4, Leaf)), 3, Node(Leaf, 2, Node(Leaf, 1, Leaf)))
    case t => t