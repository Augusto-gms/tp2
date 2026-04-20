#!/bin/bash
javac -d bin src/modelos/*.java src/colecoes/*.java src/ordenacao/*.java src/pesquisa/*.java src/Main.java &&
  java -cp bin Main <src/assets/pub.in
