(set-env!
 :resource-paths #{"src"}
 :dependencies '[[io.pedestal/pedestal.service "0.5.5"]
                 [io.pedestal/pedestal.route "0.5.5"]
                 [io.pedestal/pedestal.jetty "0.5.0"]
                 [io.pww]
                 ; ^ Http server lib.
                 [org.slf4j/slf4j-simple "1.7.25"]])
