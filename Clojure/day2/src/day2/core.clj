(ns day2.core
  (:gen-class))

  (defn -main
    "I don't do a whole lot ... yet."
    [& args]
    (println "Hello, World!"))

  (defn fib-pair [[a b]] [b (+ a b)])

  (defn factorial [n] (apply * (take n (iterate inc 1))))

  (defprotocol Compass
    (direction [c])
    (left [c])
    (right [c]))

  (def directions [:north :east :south :west])

  (defn turn
    [base amount]
    (rem (+ base amount) (count directions)))

  (defrecord SimpleCompass [bearing]
    Compass
    (direction [_] (directions bearing))
    (left [_] (SimpleCompass. (turn bearing 3)))
    (right [_] (SimpleCompass. (turn bearing 1)))

    Object
    (toString [this] (str "[" (direction this) "]")))

  (defmacro unless [test body]
    (list 'if (list 'not test) body))
