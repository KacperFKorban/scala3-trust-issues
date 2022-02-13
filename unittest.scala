//> using lib "org.scalameta::munit:0.7.29"

import Tree.*

class TreeInvertUnitSuite extends munit.FunSuite {
  test("invert a Leaf") {
    assertEquals(invertTree(Leaf), Leaf)
  }

  test("invert a Node") {
    val tree = Node(Leaf, 1, Leaf)
    val expected = Node(Leaf, 1, Leaf)
    assertEquals(invertTree(tree), expected)
  }

  test("invert a 2-layered tree") {
    val tree = Node(Node(Leaf, 1, Leaf), 2, Node(Leaf, 3, Leaf))
    val expected = Node(Node(Leaf, 3, Leaf), 2, Node(Leaf, 1, Leaf))
    assertEquals(invertTree(tree), expected)
  }

  test("invert a asymmetric tree") {
    val tree = Node(Leaf, 1, Node(Leaf, 2, Leaf))
    val expected = Node(Node(Leaf, 2, Leaf), 1, Leaf)
    assertEquals(invertTree(tree), expected)
  }

  test("invert a 3-layered tree") {
    val tree = Node(Node(Node(Leaf, 1, Leaf), 2, Leaf), 3, Node(Node(Leaf, 4, Leaf), 5, Leaf))
    val expected = Node(Node(Leaf, 5, Node(Leaf, 4, Leaf)), 3, Node(Leaf, 2, Node(Leaf, 1, Leaf)))
    assertEquals(invertTree(tree), expected)
  }
}
