(ns sitegen-reagent.parsing)


(def code-suffix "::")
(def delimiters ["(())" "[[]]"])

(defn split-by-whitespace [s]
  (clojure.string/split s #"\s+"))



(defn get-public-node [root]
  ;extract public nodes for ((UID)) references 2) extract ((uid))s 3) filter
  []
  )

;(defn resolve-block [uid] :string (get-public-node uid))
; rawroamtext -> intermediate -> parsedHiccup ->
(defn hastag? [tag]
  ;checks if a child has a #tag like #public ... to be able to link it
  )

;Footnote -> sup sub
;* Bla <1> ioapd
; *<1>
;    *Ladida
;(defn links)
;(defn find-backlinks [uid] [])
;(defn get-node [uid] [])
;(def attributes {
;                 :url
;                 :title
;                 :def
;                 :essay
;                 :formula
;                 :iframe-src
;                 :certainty
; :prediction
;                 :src
;                 :tweet-src
;                 :similar
;            :claim
;            :is-a
;            :synonym
;                 :footnote
;
;            })


