-module(count).
-export([to_ten/0]).

next_number(10) -> io:fwrite("~w ~n", [10]);
next_number(N) -> io:fwrite("~w ~n", [N]), next_number(N + 1).

to_ten() -> next_number(0).
