module Main where
  main :: IO()
  main = return ()

  allEven :: [Integer] -> [Integer]
  allEven [] = []
  allEven (h:t) = if even h then h:allEven t else allEven t

  allEvenUsingListComp :: [Integer] -> [Integer]
  allEvenUsingListComp [] = []
  allEvenUsingListComp l = [x | x <- l, even x]

  allEvenUsingFilter l = filter even l
