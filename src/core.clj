(ns core
  (:require [io.pedestal.http :as http]
            ; Lets you connect to servers, handle requests, and send responses.
            [io.pedestal.http.route :as route]))
            ; Handles routing for urls.

(defn put-route [req]
  {:status 200 :body "This was a put request"})

(defn respond-hello [req]
  {:status 200 :body {:greeting "Hello World"
                      :greeter "Pedestal"}})
(def routes
  (route/expand-routes
   #{["/greet" :get respond-hello :route-name :greet]
     ["/putrequest" :put put-route :route-name :put-route]}))
