(ns ^:figwheel-no-load balance-delta.app
  (:require [balance-delta.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
