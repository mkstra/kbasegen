(ns sitegen-reagent.app
  (:require
    [reagent.core :as reagent :refer [atom]]
    [reagent.dom :as rdom]
    [reagent.session :as session]
    [sitegen-reagent.util :refer [lister nav divme]]
    [json-html.core :refer [json->hiccup]]

))
    (defonce app-state (atom {:title "WhichWeather"                          ;; <1>
                          :postal-code ""
                          :json "assa"
                          :data-received? false }))


;; -------------------------
;; Page mounting component
(-> (.fetch js/window "http://localhost:8080")
    #_=>   (.then #(.json %))  ; Get JSON from the Response.body ReadableStream
    #_=>   (.then #((swap! app-state
                           assoc-in [:json] (js->clj % :keywordize-keys true )) %)))


(def pages
  {:about "/about"
   :contact "/contact"
   }
  )
(defn app []
  ;(let [children (get-in @app-state [:json :children] )]
  ;(fn []
    ;[:h1 "WWEW" ]
    [:div "Hello"
     ;[:div "Goodbye"]
      [divme "text"]
     [:div (map (fn [x] [:div (:string x)]) (get-in @app-state [:json :children] ))]
     ;(get-in @app-state [:json :children]))
     (lister (range 3))
     [nav pages]
     (json->hiccup (get-in @app-state [:json]) )
     ]
    ;)
  )

