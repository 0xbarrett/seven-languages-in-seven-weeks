-module(keyword).
-export([get/2]).

get(List, Key) ->
  case [Value || {MyKey, Value} <- List, MyKey == Key] of
    [Head|_] -> Head;
  _ -> "Nope"
end.
