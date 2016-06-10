(ns day2.core
  (:gen-class))

  (defprotocol Compass
    (direction [c])
    (left [c])
    (right [c]))
