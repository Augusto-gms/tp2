#!/bin/bash
javac -d bin src/modelos/*.java src/colecoes/*.java src/ordenacao/*.java src/pesquisa/*.java src/MainMerge.java &&
  java -cp bin MainMerge <src/assets/pub.in
