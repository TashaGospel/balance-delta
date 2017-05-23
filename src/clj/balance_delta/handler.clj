(ns balance-delta.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [balance-delta.layout :refer [error-page]]
            [balance-delta.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [balance-delta.env :refer [defaults]]
            [mount.core :as mount]
            [balance-delta.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
