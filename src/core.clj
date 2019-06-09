(ns core
  (:require [io.pedestal.http :as http]
            ; Lets you connect to servers, handle requests, and send responses.
            [io.pedestal.http.route :as route]))
            ; Handles routing for urls.

(defn respond-hello [req]
  {:status 200 :body "Hello World!"})
