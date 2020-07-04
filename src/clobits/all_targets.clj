(ns clobits.all-targets
  "Functions that are used by both native-image and polyglot namespaces."
  (:require [clobits.util :refer [remove-prefixes snake->kebab]]))

(definterface IWrapper
  (^org.graalvm.word.PointerBase unwrap []))

(defn gen-clojure-mapping
  "Takes proto data and creates a pair.
  The key is a symbol looking like a clojure function name.
  The value is the proto data.
  
  ```  
  (gen-clojure-mapping {:ret \"int\", :sym \"SDL_Init\", :args [{:type \"Uint32\", :sym \"flags\"}]}
                       {:prefixes [\"SDL\"]})
  ;;=> [init {:ret \"int\", :sym \"SDL_Init\", :args [{:type \"Uint32\", :sym \"flags\"}]}]
  ```
  "  
  
  [{:keys [sym] :as f} & [{:keys [prefixes kebab] :or {kebab true}}]]
  [(symbol (cond-> sym
             prefixes (remove-prefixes prefixes)
             kebab snake->kebab))
   f])

(comment
  (gen-clojure-mapping {:ret "int", :sym "SDL_Init", :args [{:type "Uint32", :sym "flags"}]}
                       {:prefixes ["SDL"]})
  ;;=> [init {:ret "int", :sym "SDL_Init", :args [{:type "Uint32", :sym "flags"}]}]
  )

(defn get-type
  [types {:keys [type pointer]}]
  (if-let [t (types type)]
    (if (symbol? t)
      t
      (get t pointer))
    nil))

(defn get-type-throw
  [types t]
  (if-let [t (get-type types t)]
    t
    (throw (Error. (str "No type defined for type: " t)))))

(defn convert-function-throw
  [poly-conversions t]
  (if-let [cf (and (some? poly-conversions) (poly-conversions t))]
    cf
    (throw (Error. (str "No poly-conversions defined for type: " t ", in list " poly-conversions)))))