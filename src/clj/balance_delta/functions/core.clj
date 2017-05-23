(ns balance-delta.functions.core
  (require [balance-delta.functions.storage :as st]
           [balance-delta.functions.config :as c]
           [clj-time.core :as t]))

(defn days-between [t1 t2]
  (t/in-days (t/interval t1 t2)))

(def daily-allowance (let [{:keys [balance last-date]} c/default-data]
                       (float
                         (/ balance
                            (days-between last-date c/end-date)))))

(defn update-delta [{:keys [last-date] :as data}]
  (let [now (t/now)]
    (-> data
        (update :delta #(+ % (* daily-allowance (days-between last-date now))))
        (assoc :last-date now))))


(defn new-balance [{:keys [balance delta] :as data} new-balance]
  (assoc data :balance new-balance
              :delta (- delta (- balance new-balance))))

(defn report
  ([] (update-delta (st/get-data)))
  ([balance] (update-delta (new-balance (st/get-data) balance))))

(defn report! [& args]
  (let [new-data (apply report args)]
    (st/save-data new-data)
    new-data))

(defn report-for-client! [& args]
  (dissoc (apply report! args) :last-date))