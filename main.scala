//> using scala "3.1.1"
import Tree.*

@main
def main =
  val tree =
    Node(
      Node(
        Node(Leaf, 1, Leaf),
        2, 
        Node(Leaf, 3, Leaf)
      ),
      4,
      Node(Leaf, 5, Leaf)
    )

  println(invertTree(tree))
