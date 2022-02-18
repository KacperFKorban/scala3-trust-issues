module Booleans where

open import Data.Bool.Base

data False : Set where
data True : Set where
  Truth : True

isTrue : Bool -> Set
isTrue true = True
isTrue false = False

trivial : isTrue(true)
trivial = Truth

cond1 : isTrue ( not false ∧ true )
cond1 = Truth

cond2 : (b : Bool) -> isTrue ( true ∨ b )
cond2 _ = Truth

cond3 : (b : Bool) -> isTrue ( b ∨ true )
cond3 true = Truth
cond3 false = Truth

cond4 : (b1 : Bool) -> (b2 : Bool) -> isTrue ( b1 ∨ b2 ∨ true )
cond4 true _ = Truth
cond4 false true = Truth
cond4 false false = Truth
