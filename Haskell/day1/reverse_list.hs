module Main where
  main :: IO()
  main = return ()

  aux [] acc = acc
  aux (h:t) acc = aux t (h:acc)

  reverseList xs = aux xs []

  reverseList2 [] = []
  reverseList2 (h:t) = (reverseList t) ++ [h]
