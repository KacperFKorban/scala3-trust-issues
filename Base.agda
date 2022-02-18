module Base where

data _≡_ {A : Set}(x : A) : A -> Set where
  refl : x ≡ x

open import Data.Bool.Base

cond1 : not false ∧ true ≡ true
cond1 = refl

cond2 : (b : Bool) -> (true ∨ b) ≡ true
cond2 _ = refl

cond3 : (b : Bool) -> (b ∨ true) ≡ true
cond3 true = refl
cond3 false = refl
