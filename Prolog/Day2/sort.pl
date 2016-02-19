sort_ascending(List, NewList) :- permutation(List, NewList), is_sorted(NewList).

is_sorted([]).
is_sorted([_]).
is_sorted([X,Y|Tail]) :-
   X =< Y, is_sorted([Y|Tail]).
