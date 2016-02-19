smallest([], []).
smallest([Smallest], Smallest).

smallest([Head, X|Tail], Smallest) :-
   Head =< X, smallest([Head|Tail], Smallest).

smallest([Head, X|Tail], Smallest) :-
   Head > X,
   smallest([X|Tail], Smallest).
