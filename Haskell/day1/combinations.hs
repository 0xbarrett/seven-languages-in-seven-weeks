module Main where
  main :: IO()
  main = return ()

  combinations [] = []
  combinations l = [(a, b) | a <- l, b <- l, a < b]
