-module(count).
-export([to_ten/0]).

next_number(10) -> 10;
next_number(N) -> next_number(N + 1).

to_ten() -> next_number(0).
