(ns balance-delta.functions.config
  (:require [clj-time.core :as t]))

(def data-file "data.edn")

(defn from-auckland-time [t]
  (t/from-time-zone t (t/time-zone-for-id "Pacific/Auckland")))

(def default-data {:delta     0
                   :balance   2126
                   :last-date (from-auckland-time (t/date-time 2017 5 23))})

(def end-date (from-auckland-time (t/date-time 2018 5 23)))