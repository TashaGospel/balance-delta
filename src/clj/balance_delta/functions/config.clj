(ns balance-delta.functions.config
  (:require [clj-time.core :as t]))

(def data-file "data.edn")

(def default-data {:delta     0
                   :balance   2126
                   :last-date (t/date-time 2017 5 23)})

(def end-date (t/date-time 2018 5 23))

