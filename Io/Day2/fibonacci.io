fib := method(n,
   j := 1
   k := 1
   result := 1
   for(i, 3, n,
      result = j + k
      j = k
      k = result
   )
   return result
)

fibrecur := method(n,
   if(n < 3) then(
   return 1
   ) else(
   return fibrecur(n - 1) + fibrecur(n - 2)
   )
)

fibrecur(7) println
