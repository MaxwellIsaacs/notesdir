;; -*- lexical-binding: t; -*-

(TeX-add-style-hook
 "practice-ass1"
 (lambda ()
   (TeX-add-to-alist 'LaTeX-provided-class-options
                     '(("article" "a4paper" "12pt")))
   (TeX-add-to-alist 'LaTeX-provided-package-options
                     '(("amsmath" "") ("amssymb" "") ("amsfonts" "") ("geometry" "")))
   (TeX-run-style-hooks
    "latex2e"
    "article"
    "art12"
    "amsmath"
    "amssymb"
    "amsfonts"
    "geometry"))
 :latex)

