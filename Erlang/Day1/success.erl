-module(success).
-export([print/1]).

print(success) -> io:format("Success ~n)");
print({error, Message}) -> io:format("error: ~w ~n", [Message]).
