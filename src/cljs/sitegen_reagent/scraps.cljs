(def with-sidebar {:display "flex"
                   :flex-wrap "wrap"
                   :margin "-0.5rem"
                   :border "green"
                   :min-width "95vw"
                   })


(def sidebar {
              :flex-basis "10rem";
              ;:margin-left "3rem"
              :flex-grow 1;
              :background "red";
              })

(def main {
           :flex-basis 0;
           :flex-grow 999;
           :min-width "calc(50% - 1rem)"
           :background "blue"; /* enable grow, disable shrink */
           })
;(get-in @app-state [:json :children]))
;(lister (range 3))
;[nav pages]
;
;
;(json->hiccup (get-in @app-state [:json]))
;
;