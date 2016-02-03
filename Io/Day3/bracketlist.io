curlyBrackets := method(
  r := List clone
  call message arguments foreach(arg,
       r append(arg)
       )
  r
)

a := { 1 + 2, 4 + 4 }

doMessage(a at(0)) println
a size println
