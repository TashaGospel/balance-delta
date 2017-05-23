(ns user
  (:require [mount.core :as mount]
            [balance-delta.figwheel :refer [start-fw stop-fw cljs]]
            balance-delta.core))

(defn start []
  (mount/start-without #'balance-delta.core/repl-server))

(defn stop []
  (mount/stop-except #'balance-delta.core/repl-server))

(defn restart []
  (stop)
  (start))


