(defproject com.github.macielti/datomic-component "1.0.0"
  :description "Datomic Component"
  :url "https://github.com/macielti/datomic-component"

  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}

  :plugins [[com.github.clojure-lsp/lein-clojure-lsp "1.4.9"]
            [com.github.liquidz/antq "RELEASE"]]

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [com.taoensso/timbre "6.6.1"]
                 [diehard "0.11.12"]
                 [hashp "0.2.2"]
                 [prismatic/schema "1.4.1"]
                 [nubank/matcher-combinators "3.9.1"]
                 [com.datomic/peer "1.0.7187"]
                 [integrant "0.11.0"]]

  :profiles {:dev {:resource-paths ^:replace ["test/resources"]

                   :test-paths     ^:replace ["test/unit" "test/integration" "test/helpers"]

                   :injections     [(require 'hashp.core)]

                   :aliases        {"clean-ns"     ["clojure-lsp" "clean-ns" "--dry"] ;; check if namespaces are clean
                                    "format"       ["clojure-lsp" "format" "--dry"] ;; check if namespaces are formatted
                                    "diagnostics"  ["clojure-lsp" "diagnostics"]
                                    "lint"         ["do" ["clean-ns"] ["format"] ["diagnostics"]]
                                    "clean-ns-fix" ["clojure-lsp" "clean-ns"]
                                    "format-fix"   ["clojure-lsp" "format"]
                                    "lint-fix"     ["do" ["clean-ns-fix"] ["format-fix"]]
                                    "outdated"     ["with-profile" "antq" "run" "-m" "antq.core"]}
                   :repl-options   {:init-ns common-clj.schema.core}}}

  :repl-options {:init-ns datomic-component.core}

  :resource-paths ["resources"])
