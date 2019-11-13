(ns circlecli.main
  (:require [clj-http.lite.client :as client]
            [cheshire.core :as json])
  (:gen-class))

(defn -main
  [& args]
  (System/setProperty "java.library.path"
                      (str (System/getenv "GRAALVM_HOME") "/jre/lib"))
  (println (client/get "https://google.com")))
