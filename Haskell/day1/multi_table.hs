module Main where
  main :: IO()
  main = return ()

  buildMultiTable l = [(a, b, a * b) | a <- l, b <- l, a <= b]
