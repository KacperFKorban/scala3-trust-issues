//> using scala "3.1.1"

enum Tree:
  case Leaf
  case Node(l: Tree, e: Int, r: Tree)

import Tree.*

def invertTree(tree: Tree): Tree =
  tree match
    case Leaf =>
      Leaf
    case Node(l, e, r) =>
      Node(invertTree(r), e, invertTree(l))
