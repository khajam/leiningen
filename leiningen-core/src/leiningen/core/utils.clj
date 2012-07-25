(ns leiningen.core.utils
  (:require [clojure.java.io :as io]))

(defn read-file
  "Read the contents of file if it exists."
  [file]
  (when (.exists file)
    (read-string (slurp file))))

(defn ns-exists? [namespace]
  (some (fn [suffix]
          (-> (#'clojure.core/root-resource namespace)
              (subs 1)
              (str suffix)
              io/resource))
        [".clj" (str clojure.lang.RT/LOADER_SUFFIX ".class")]))
