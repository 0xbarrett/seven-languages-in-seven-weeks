my_reverse([], []).

my_reverse([Head|Tail], Reverse) :-
   my_reverse(Tail, ReverseTail), append(ReverseTail, [Head], Reverse).
