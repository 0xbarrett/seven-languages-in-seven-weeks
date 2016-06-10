(ns day3.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn create
  []
  (atom {}))

; (defn get
;   [cache key]
;   (@cache key))

(defn put
  ([cache value-map]
    (swap! cache merge value-map))
  ([cache key value]
    (swap! cache assoc key value)))

(defn twice [x] (* 2 x))

(defn slow-twice [x]
  (do
    (Thread/sleep 10000)
    (* 2 x)))

;-------------------------------------------
; accounts
;-------------------------------------------
(def ^:private accounts (ref []))

(defn open []
  (dosync
    (alter accounts #(conj % 0))
  )
  (dec (count @accounts))
)

(defn balance [account-number]
  (get @accounts account-number)
)

(defn credit [account-number amount]
  (dosync
    (alter accounts
      #(assoc % account-number (+ (get % account-number) amount))
    )
  )
)

(defn debit [account-number amount]
  (credit account-number (- amount))
)

;-------------------------------------------
; sleeping-barber
;-------------------------------------------
(def waiting-room (atom 0))
(def number-of-cuts (atom 0))

(defn arrival-time [] (+ 10 (rand-int 21)))

(defn start-thread [f]
  (.start (Thread. f))
)

(defn waiting-room-loop []
  (Thread/sleep (arrival-time))
  (swap! waiting-room #(min 3 (inc %)))
)

(defn start-waiting-room []
  (start-thread
    #(while true (waiting-room-loop))
  )
)

(defn barber-loop []
  (while (= 0 @waiting-room))
  (swap! waiting-room #(dec %))

  (Thread/sleep 20)
  (swap! number-of-cuts #(inc %))
)

(defn start-barber []
  (start-thread
    #(while true (barber-loop))
  )
)

(start-waiting-room)
(start-barber)
(Thread/sleep 10000)
(println @number-of-cuts)
