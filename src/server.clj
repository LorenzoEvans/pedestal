(ns server
  (:gen-class)
  (:require [io.pedestal.http :as http]
            [core.service :as service]))

(defonce runnable-service (http/create-server core/service))

(defn run-dev
  [& args]
  (println "\n Starting up server.")
  (-> core/service
      (merge {:env :dev
              ::http/join? false
              ::http/routes #(deref #'core/routes)
              ::http/allowed-origins {:creds true :allowed-origins (constantly true)}})
      http/default-interceptors
      http/dev-interceptors
      http/create-server
      http/start))

(defn -main
  [& args]
  (http/start runnable-service))
