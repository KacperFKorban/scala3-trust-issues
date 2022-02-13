module InvertTree where

open import Relation.Binary.PropositionalEquality

-- BUILTINS
data Nat : Set where
  zero : Nat
  suc  : Nat → Nat
{-# BUILTIN NATURAL Nat #-}

data Int : Set where
  pos    : Nat → Int
  negsuc : Nat → Int
{-# BUILTIN INTEGER       Int    #-}
{-# BUILTIN INTEGERPOS    pos    #-}
{-# BUILTIN INTEGERNEGSUC negsuc #-}
-- END BUILTINS

data Tree : Set where
  Leaf : Tree
  Node : Tree → Int → Tree → Tree

invertTree : Tree → Tree
invertTree Leaf = Leaf
invertTree (Node l e r) = Node (invertTree r) e (invertTree l)

doubleInvert : (t : Tree) → invertTree (invertTree t) ≡ t
doubleInvert Leaf = refl
doubleInvert (Node l e r) = cong₂ (λ a b → Node a e b) (doubleInvert l) (doubleInvert r)

addNodeInvert :
  (t : Tree) →
  invertTree (Node Leaf (pos 0) t) ≡ Node (invertTree t) (pos 0) Leaf
addNodeInvert _ = refl

invertTreeTest1 :
  invertTree Leaf ≡ Leaf
invertTreeTest1 = refl

invertTreeTest2 :
  invertTree (Node Leaf (pos 1) (Node Leaf (pos 2) Leaf)) ≡
    Node (Node Leaf (pos 2) Leaf) (pos 1) Leaf
invertTreeTest2 = refl
