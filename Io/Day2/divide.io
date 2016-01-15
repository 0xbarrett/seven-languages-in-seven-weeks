Number oldDiv := Number getSlot("/")

Number / = method(x,
   if(x == 0, return "I got this", return self oldDiv(x))
)

(4/0) println
(4/2) println
