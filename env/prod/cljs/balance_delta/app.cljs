(ns balance-delta.app
  (:require [balance-delta.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
