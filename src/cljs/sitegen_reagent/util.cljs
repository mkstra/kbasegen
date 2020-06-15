(ns sitegen-reagent.util
  (:require
    [reagent.core :as reagent :refer [atom]]
    [reagent.dom :as rdom]
    [reagent.session :as session]
    ))


(defn divme [text] [:div text])
;
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