-module(number_of_words).
-export([get/1]).

aux([]) -> 0;
aux(" ") -> 0;
aux([$ , $ |Tail]) -> aux(" " ++ Tail);
aux([$ |Tail]) -> 1 + aux(Tail);
aux([_|Tail]) -> aux(Tail).

get(S) -> aux(" " ++ S).
