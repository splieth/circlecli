(defproject circlecli "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.martinklepsch/clj-http-lite "0.4.1"]
                 [cheshire "5.9.0"]]
  :plugins [[io.taylorwood/lein-native-image "0.3.1"]]
  :native-image {:name "circlecli"
                 :opts ["--initialize-at-build-time"
                        "--report-unsupported-elements-at-runtime"
                        "--enable-url-protocols=http"]}
  :main circlecli.main
  :global-vars {*warn-on-reflection* true}
  :repl-options {:init-ns circlecli.main}
  :profiles {:uberjar
             {:aot          :all
              :native-image {:jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}})
