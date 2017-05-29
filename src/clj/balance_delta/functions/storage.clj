(ns balance-delta.functions.storage
  (:require [clojure.edn :as edn]
            [balance-delta.functions.config :as c]
            [clj-time.format :as f]
            [clj-time.core :as t])
  (:import (java.io FileNotFoundException)))

(defn get-data []
  (try
    (-> (slurp c/data-file)
        edn/read-string
        (update :last-date
                #(c/from-auckland-time (f/parse (f/formatters :basic-date-time) %))))
    (catch FileNotFoundException e c/default-data)))

(defn save-data [data]
  (spit c/data-file
        (update data :last-date #(f/unparse (f/formatters :basic-date-time) %))))