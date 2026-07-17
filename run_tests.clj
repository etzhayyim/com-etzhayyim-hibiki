(require '[clojure.test :as t])

(def suites
  '[hibiki.methods.test-charter-gates
    hibiki.methods.test-present-plan])

(apply require suites)
(let [{:keys [fail error] :as result} (apply t/run-tests suites)]
  (println (select-keys result [:test :pass :fail :error]))
  (when (pos? (+ fail error))
    (System/exit 1)))
