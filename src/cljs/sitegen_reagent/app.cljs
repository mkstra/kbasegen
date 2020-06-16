(ns sitegen-reagent.app
  (:require
    [reagent.core :as reagent :refer [atom]]
    [reagent.dom :as rdom]
    [reagent.session :as session]
    [sitegen-reagent.util :refer [lister nav divme parsenode]]
    [json-html.core :refer [json->hiccup]]
    [instaparse.core :as insta]

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

;(defn )

(defn app []
  [:div
    [:div {:class "with-sidebar"}
     [:div

      [:div (map (partial parsenode 0 ) (get-in @app-state [:json :children]) ) ]
      [:div {:class "main"} (map (fn [x] [:p (:string x)]) (get-in @app-state [:json :children] ))]
      [:div {:class "sidebar"} "Sidebar"]
      ]
       ]
   [:div {:class "yell"} "YOOOOOZOOO"]
   ]
  )

