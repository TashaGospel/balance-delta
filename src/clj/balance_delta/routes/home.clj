(ns balance-delta.routes.home
  (:require [balance-delta.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [compojure.coercions :refer [as-int]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [balance-delta.functions.core :as c]))

(defroutes home-routes
  (GET "/" []
    (response/ok (c/report-for-client!)))
  (GET "/:balance" [balance :<< as-int]
    (response/ok (c/report-for-client! balance))))

