;; This file is autogenerated -- probably shouldn't modify it by hand
(clojure.core/ns
 bindings.sdl-ns
 (:require [clojure.java.io])
 (:import
  org.graalvm.polyglot.Context
  org.graalvm.polyglot.Source
  org.graalvm.polyglot.Value)
 (:gen-class))

(def ^{:private true} empty-array (clojure.core/object-array 0))

(clojure.core/defn
 context-f538
 []
 (clojure.core/->
  (org.graalvm.polyglot.Context/newBuilder
   (clojure.core/into-array ["llvm"]))
  (.allowAllAccess true)
  (.build)))

(clojure.core/defn
 ^{:private true}
 source-f539
 []
 (clojure.core/->
  (org.graalvm.polyglot.Source/newBuilder
   "llvm"
   (if
    (clojure.core/string? "libs/libbindings$sdl.so")
    (clojure.java.io/file "libs/libbindings$sdl.so")
    "libs/libbindings$sdl.so"))
  (.build)))

(def polyglot-context (context-f538))

(def polyglot-lib (.eval polyglot-context (source-f539)))

(clojure.core/gen-interface
 :name
 ^{org.graalvm.polyglot.HostAccess$Implementable true}
 bindings.sdl_structs.ISDL_Event
 :methods
 [[type [] int]
  [set_type [int] void]
  [key [] bindings.sdl_structs.ISDL_KeyboardEvent]
  [set_key [bindings.sdl_structs.ISDL_KeyboardEvent] void]])

(clojure.core/gen-interface
 :name
 ^{org.graalvm.polyglot.HostAccess$Implementable true}
 bindings.sdl_structs.ISDL_KeyboardEvent
 :methods
 [[keysym [] bindings.sdl_structs.ISDL_Keysym]
  [set_keysym [bindings.sdl_structs.ISDL_Keysym] void]])

(clojure.core/gen-interface
 :name
 ^{org.graalvm.polyglot.HostAccess$Implementable true}
 bindings.sdl_structs.ISDL_Keysym
 :methods
 [[sym [] int] [set_sym [int] void]])

(clojure.core/gen-interface
 :name
 ^{org.graalvm.polyglot.HostAccess$Implementable true}
 bindings.sdl_structs.ISDL_Surface
 :methods
 [[format [] bindings.sdl_structs.ISDL_PixelFormat]
  [set_format [bindings.sdl_structs.ISDL_PixelFormat] void]])

(clojure.core/gen-interface
 :name
 ^{org.graalvm.polyglot.HostAccess$Implementable true}
 bindings.sdl_structs.ISDL_PixelFormat
 :methods
 [[palette [] clobits.all_targets.IVoidPointerYE]
  [set_palette [clobits.all_targets.IVoidPointerYE] void]])

(clojure.core/gen-interface
 :name
 ^{org.graalvm.polyglot.HostAccess$Implementable true}
 bindings.sdl_structs.ISDL_Rect
 :methods
 [[x [] int]
  [set_x [int] void]
  [y [] int]
  [set_y [int] void]
  [w [] int]
  [set_w [int] void]
  [h [] int]
  [set_h [int] void]])

(clojure.core/declare
 wrap-sdl-event
 wrap-sdl-rect
 wrap-pointer
 wrap-sdl-pixel-format
 wrap-sdl-surface
 wrap-sdl-keysym
 wrap-sdl-keyboard-event)

(clojure.core/defn
 wrap-sdl-event
 [value]
 (clojure.core/reify
  bindings.sdl_structs.ISDL_Event
  (type [_] (clojure.core/-> (.getMember value "type") .asInt))
  (set_type [_ v] (.putMember value "type" v))
  (key [_] (wrap-sdl-keyboard-event (.getMember value "key")))
  (set_key [_ v] (.putMember value "key" (.unwrap v)))
  clobits.all_targets.IWrapper
  (unwrap [_] (.as value bindings.sdl_structs.ISDL_Event))))

(clojure.core/defn
 wrap-sdl-keyboard-event
 [value]
 (clojure.core/reify
  bindings.sdl_structs.ISDL_KeyboardEvent
  (keysym [_] (wrap-sdl-keysym (.getMember value "keysym")))
  (set_keysym [_ v] (.putMember value "keysym" (.unwrap v)))
  clobits.all_targets.IWrapper
  (unwrap [_] (.as value bindings.sdl_structs.ISDL_KeyboardEvent))))

(clojure.core/defn
 wrap-sdl-keysym
 [value]
 (clojure.core/reify
  bindings.sdl_structs.ISDL_Keysym
  (sym [_] (clojure.core/-> (.getMember value "sym") .asInt))
  (set_sym [_ v] (.putMember value "sym" v))
  clobits.all_targets.IWrapper
  (unwrap [_] (.as value bindings.sdl_structs.ISDL_Keysym))))

(clojure.core/defn
 wrap-sdl-surface
 [value]
 (clojure.core/reify
  bindings.sdl_structs.ISDL_Surface
  (format [_] (wrap-sdl-pixel-format (.getMember value "format")))
  (set_format [_ v] (.putMember value "format" (.unwrap v)))
  clobits.all_targets.IWrapper
  (unwrap [_] (.as value bindings.sdl_structs.ISDL_Surface))))

(clojure.core/defn
 wrap-sdl-pixel-format
 [value]
 (clojure.core/reify
  bindings.sdl_structs.ISDL_PixelFormat
  (palette [_] (wrap-pointer (.getMember value "palette")))
  (set_palette [_ v] (.putMember value "palette" (.unwrap v)))
  clobits.all_targets.IWrapper
  (unwrap [_] (.as value bindings.sdl_structs.ISDL_PixelFormat))))

(clojure.core/defn
 wrap-sdl-rect
 [value]
 (clojure.core/reify
  bindings.sdl_structs.ISDL_Rect
  (x [_] (clojure.core/-> (.getMember value "x") .asInt))
  (set_x [_ v] (.putMember value "x" v))
  (y [_] (clojure.core/-> (.getMember value "y") .asInt))
  (set_y [_ v] (.putMember value "y" v))
  (w [_] (clojure.core/-> (.getMember value "w") .asInt))
  (set_w [_ v] (.putMember value "w" v))
  (h [_] (clojure.core/-> (.getMember value "h") .asInt))
  (set_h [_ v] (.putMember value "h" v))
  clobits.all_targets.IWrapper
  (unwrap [_] (.as value bindings.sdl_structs.ISDL_Rect))))

(clojure.core/defn
 wrap-pointer
 [value]
 (clojure.core/reify clobits.all_targets.IWrapper (unwrap [_] value)))

(def
 ^{:private true}
 get-sdl-init-video540
 (.getMember polyglot-lib "_SHADOWING_GET_SDL_INIT_VIDEO"))

(clojure.core/defn
 get-sdl-init-video
 "Ret: {:wrapper nil, :annotation long}"
 ^long
 []
 (clojure.core/->
  (.execute get-sdl-init-video540 (clojure.core/object-array []))
  .asInt))

(def
 ^{:private true}
 get-sdl-window-shown541
 (.getMember polyglot-lib "_SHADOWING_GET_SDL_WINDOW_SHOWN"))

(clojure.core/defn
 get-sdl-window-shown
 "Ret: {:wrapper nil, :annotation long}"
 ^long
 []
 (clojure.core/->
  (.execute get-sdl-window-shown541 (clojure.core/object-array []))
  .asInt))

(def
 ^{:private true}
 get-null542
 (.getMember polyglot-lib "_SHADOWING_get_null"))

(clojure.core/defn
 get-null
 "Ret: {:wrapper wrap-pointer, :annotation nil}"
 
 []
 (wrap-pointer
  (.executeVoid get-null542 (clojure.core/object-array []))))

(def
 ^{:private true}
 gen-title543
 (.getMember polyglot-lib "_SHADOWING_gen_title"))

(clojure.core/defn
 gen-title
 "Ret: {:wrapper wrap-pointer, :annotation nil}"
 
 []
 (wrap-pointer (.execute gen-title543 (clojure.core/object-array []))))

(def
 ^{:private true}
 create-rect544
 (.getMember polyglot-lib "_SHADOWING_create_rect"))

(clojure.core/defn
 create-rect
 "Ret: {:wrapper wrap-sdl-rect, :annotation nil}"
 
 [^long x ^long y ^long w ^long h]
 (wrap-sdl-rect
  (.execute
   create-rect544
   (clojure.core/object-array [(int x) (int y) (int w) (int h)]))))

(def
 ^{:private true}
 get-e545
 (.getMember polyglot-lib "_SHADOWING_get_e"))

(clojure.core/defn
 get-e
 "Ret: {:wrapper wrap-sdl-event, :annotation nil}"
 
 []
 (wrap-sdl-event (.execute get-e545 (clojure.core/object-array []))))

(def
 ^{:private true}
 init546
 (.getMember polyglot-lib "_SHADOWING_SDL_Init"))

(clojure.core/defn
 init
 "Ret: {:wrapper nil, :annotation long}"
 ^long
 [^long flags]
 (clojure.core/->
  (.execute init546 (clojure.core/object-array [(int flags)]))
  .asInt))

(def
 ^{:private true}
 poll-event547
 (.getMember polyglot-lib "_SHADOWING_SDL_PollEvent"))

(clojure.core/defn
 poll-event
 "Ret: {:wrapper nil, :annotation long}"
 ^long
 [^clobits.all_targets.IWrapper event]
 (clojure.core/->
  (.execute
   poll-event547
   (clojure.core/object-array [(.unwrap event)]))
  .asInt))

(def
 ^{:private true}
 delay548
 (.getMember polyglot-lib "_SHADOWING_SDL_Delay"))

(clojure.core/defn
 delay
 "Ret: {:wrapper nil, :annotation nil}"
 
 [^long ms]
 (.executeVoid delay548 (clojure.core/object-array [(int ms)])))

(def
 ^{:private true}
 update-window-surface549
 (.getMember polyglot-lib "_SHADOWING_SDL_UpdateWindowSurface"))

(clojure.core/defn
 update-window-surface
 "Ret: {:wrapper nil, :annotation long}"
 ^long
 [^clobits.all_targets.IWrapper window]
 (clojure.core/->
  (.execute
   update-window-surface549
   (clojure.core/object-array [(.unwrap window)]))
  .asInt))

(def
 ^{:private true}
 get-window-surface550
 (.getMember polyglot-lib "_SHADOWING_SDL_GetWindowSurface"))

(clojure.core/defn
 get-window-surface
 "Ret: {:wrapper wrap-sdl-surface, :annotation nil}"
 
 [^clobits.all_targets.IWrapper window]
 (wrap-sdl-surface
  (.execute
   get-window-surface550
   (clojure.core/object-array [(.unwrap window)]))))

(def
 ^{:private true}
 map-rgb551
 (.getMember polyglot-lib "_SHADOWING_SDL_MapRGB"))

(clojure.core/defn
 map-rgb
 "Ret: {:wrapper nil, :annotation long}"
 ^long
 [^clobits.all_targets.IWrapper format ^long r ^long g ^long b]
 (clojure.core/->
  (.execute
   map-rgb551
   (clojure.core/object-array
    [(.unwrap format) (int r) (int g) (int b)]))
  .asInt))

(def
 ^{:private true}
 create-window552
 (.getMember polyglot-lib "_SHADOWING_SDL_CreateWindow"))

(clojure.core/defn
 create-window
 "Ret: {:wrapper wrap-pointer, :annotation nil}"
 
 [^clobits.all_targets.IWrapper
  title
  ^Long
  x
  ^Long
  y
  ^Long
  w
  ^Long
  h
  ^Long
  flags]
 (wrap-pointer
  (.execute
   create-window552
   (clojure.core/object-array
    [(.unwrap title) (int x) (int y) (int w) (int h) (int flags)]))))

(def
 ^{:private true}
 fill-rect553
 (.getMember polyglot-lib "_SHADOWING_SDL_FillRect"))

(clojure.core/defn
 fill-rect
 "Ret: {:wrapper nil, :annotation long}"
 ^long
 [^clobits.all_targets.IWrapper
  dst
  ^clobits.all_targets.IWrapper
  rect
  ^long
  color]
 (clojure.core/->
  (.execute
   fill-rect553
   (clojure.core/object-array
    [(.unwrap dst) (.unwrap rect) (int color)]))
  .asInt))

(def
 ^{:private true}
 quit554
 (.getMember polyglot-lib "_SHADOWING_SDL_Quit"))

(clojure.core/defn
 quit
 "Ret: {:wrapper nil, :annotation nil}"
 
 []
 (.executeVoid quit554 (clojure.core/object-array [])))

