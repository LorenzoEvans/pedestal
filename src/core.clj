(ns core
  (:require [io.pedestal.http :as http]
            ; Lets you connect to servers, handle requests, and send responses.
            [io.pedestal.http.route :as route]
            ; Handles routing for urls.
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route.definition :refer [defroutes]]))

(defn hello-world
  [req]
  (let [name (get-in req [:params :name] "World!")]
    {:status 200 :body (str "Hello" name "!\n")}))

(defroutes routes
           [[["/"
              ["/hello" {:get hello-world}]]]])

(def service {:env :dev
              ::http/routes routes
              ::http/resource-path "/public"
              ::http/type :jetty
              ::http/port 4224})
