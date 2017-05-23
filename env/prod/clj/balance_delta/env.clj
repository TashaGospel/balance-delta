(ns balance-delta.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[balance-delta started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[balance-delta has shut down successfully]=-"))
   :middleware identity})
