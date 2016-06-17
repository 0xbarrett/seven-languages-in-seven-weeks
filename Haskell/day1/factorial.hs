module Main where
  main :: IO()
  main = return ()

  factorial :: Integer -> Integer
  factorial 0 = 1
  factorial x = x * factorial (x - 1)
