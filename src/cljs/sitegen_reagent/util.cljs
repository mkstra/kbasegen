(ns sitegen-reagent.util
  (:require
    [reagent.core :as reagent :refer [atom]]
    [reagent.dom :as rdom]
    [reagent.session :as session]
    ))


(defn parsenode [cnt m]
  (if (nil? (m :children))
    [:p (:string m)]
    [:details {:style {:margin-left (str cnt "rem")}} [:summary (:string m)] (map (partial parsenode (inc cnt)) (:children m))]
  ))
;(defn parse-n [m] (parsenode m 0))

(defn divme [text] [:div text])
;
(defn has-value [key value]
  "Returns a predicate that tests whether a map contains a specific value"
  (fn [m]
    (= value (m key))))

(defn nav [links]
  [:ul "AAAWWWW"
   (for [item links]
     [:li (key item) "AA" (val item )])
   ]
  )

(defn lister [items]
  [:ul "asasas"
   (for [item items]
     ^{:key item} [:li "Item " item])]
  )                     ;; ^{:key item} is for react indexing

;
;(defn get-tags)
;
;;get all vals given key of collection
;(defn get-text [coll]
;  (map :string coll)
;  )
;(defn get-attribute)