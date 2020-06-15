(ns sitegen-reagent.prod
  (:require [sitegen-reagent.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
