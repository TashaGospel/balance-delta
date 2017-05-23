(ns balance-delta.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [balance-delta.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[balance-delta started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[balance-delta has shut down successfully]=-"))
   :middleware wrap-dev})
