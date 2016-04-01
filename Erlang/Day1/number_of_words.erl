-module(number_of_words).
-export([get/1]).

count([], Count) -> Count;
count([" ", " "], Count) -> Count;
count([" ", " "| Tail], Count) -> count(Tail, Count);
count([" " | Tail], Count) -> count(Tail, Count + 1);
count([Head | Tail], Count) -> count(Tail, Count).

get(String) -> count(String, 0).
