(ns circlecli.main
  (:require [clj-http.lite.client :as client]
            [cheshire.core :as json])
  (:gen-class))

(def url "http://dev.markitondemand.com/MODApis/Api/v2/Quote/json?symbol=%s")

(defn get-stock-value-of
  [symbol]
  (let [response (-> (format url symbol)
                     (client/get)
                     (:body)
                     (json/parse-string true))]
    {:name (response :Name) :price (response :LastPrice)}))

(defn -main
  [& args]
  (println "Joscha hat gute Ideen aber nein")
  )
