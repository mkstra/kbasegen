(ns sitegen-reagent.app
  (:require
    [reagent.core :as reagent :refer [atom]]
    [reagent.dom :as rdom]
    [reagent.session :as session]
    [sitegen-reagent.util :refer [lister nav divme parsenode roamdata parse-block]]
    [json-html.core :refer [json->hiccup]]
    ;[instaparse.core :as insta]

))
(defonce app-state (atom {:title "WhichWeather"                          ;; <1>
                          :postal-code ""
                          :json roamdata
                          :data-received? false }))
;; -------------------------
;; Page mounting component

(defn to-json [v] (.stringify js/JSON v))

(defn download-object-as-json [value export-name]
  (let [data-blob (js/Blob. #js [(to-json value)] #js {:type "application/json"})
        link (.createElement js/document "a")]
    (set! (.-href link) (.createObjectURL js/URL data-blob))
    (.setAttribute link "download" export-name)
    (.appendChild (.-body js/document) link)
    (.click link)
    (.removeChild (.-body js/document) link)))

(-> (.fetch js/window "http://localhost:8080")
    #_=>   (.then #(.json %))  ; Get JSON from the Response.body ReadableStream
    #_=>   (.then #((swap! app-state
                           assoc-in [:json] (js->clj % :keywordize-keys true )) %))
            ;(.then (download-object-as-json (clj->js {:hello "world"}) "myfile.json"))
    )




;filter ROAM JSON: get node + children with tag "X" and all the referenced nodes + their references


(def pages
  {:about "/about"
   :contact "/contact"
   }
  )



(defn app []
  [:div
   ;(map parse-block (map :string roamdata))
   [:div {:class "with-sidebar"}
    [:div
     [:div {:class "main"} (map (partial parsenode 0) (filter :title (get-in @app-state [:json])))]
      ;[:div {:class "main"} (map (fn [x] [:p (:string x)]) (get-in @app-state [:json :children] ))]
     [:div {:class "sidebar"} "Sidebar"]]]
   [:div {:class "yell"} "YOOOOOZOOO"]]
  )

