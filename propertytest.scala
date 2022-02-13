//> using lib "org.scalacheck::scalacheck:1.15.4"

import org.scalacheck.Prop.*
import org.scalacheck.*
import Gen.*
import Arbitrary.*

import Tree.*

object TreeInvertPropertySuite extends Properties("TreeInvert") {
  import TreeArbitrary.given

  property("double invert") = forAll { (t: Tree) =>
    invertTree(invertTree(t)) == t
  }

  property("add node invert") = forAll { (t: Tree) =>
    invertTree(Node(Leaf, 0, t)) == Node(invertTree(t), 0, Leaf)
  }

}

object TreeArbitrary {
  given arbitraryTree: Arbitrary[Tree] = Arbitrary {
    def genLeaf: Gen[Leaf.type] = const(Leaf)

    def genNode(maxDepth: Int): Gen[Node] =
      for
        v <- arbitrary[Int]
        maxDepthL <- Gen.choose(0, maxDepth - 1)
        maxDepthR <- Gen.choose(0, maxDepth - 1)
        l <- genTreeSized(maxDepthL)
        r <- genTreeSized(maxDepthR)
      yield Node(l, v, r)

    def genTreeSized(maxDepth: Int): Gen[Tree] =
      if maxDepth == 0 then genLeaf else Gen.oneOf(genLeaf, genNode(maxDepth)) 
    
    Gen.sized { size => genTreeSized(size) }
  }
}
