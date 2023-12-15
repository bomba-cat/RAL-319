# Dokumentation LB Projekt
## Aufgabe 1
### [Wir entwerfen einen Computer](project/Fibonacci.java)

## Aufgabe 2
### [Arimethische Operationen](project/Operation.java)

## Aufgabe 3
### [Die Fibonacci Folge](project/Fibonacci.java)
-   Der Goldene Schnitt

## Aufgabe 4
### [RAL-Programm Subtraktion](RLE.Sub.txt)

## Aufgabe 5
### [RAL-Programm Multiplikation](RLE.Mul.txt)

## Aufgabe 6
### [RAL-Programm Fibonacci](RLE.Fibonacci.txt)

## Mein eigener Intepreter
### [RAL-Intepreter](project/Intepreter.java)
#### Die neuen Befehle
1. WMR, Write Memory, Schreibt einen Wert am schluss der Memory
2. SMV, Show Memory Value, zeigt den Wert einer Memory Allocation an
#### Was ist speziell bei diesem Intepreter
1. Dieser Intepreter unterstützt Kommentare OHNE spezielle zeichen. Sie können einfach neben der Zahl jedigliches schreiben und es wird Ignoriert.
2. Der Intepreter Ignoriert leere Zeilen, wobei diese nicht von der Array gelöscht werden.
3. Leere Linien sind keine Instruktionen, man kann dort nicht mit JMP drauf springen!

## Meine Advanced Array Library
###  Die Funktionen
#### ArrayTypes
1. IntArray
2. BoolArray
3. ByteArray
4. ShortArray
5. LongArray
6. StringArray
#### Methoden
1. add(Array, Value)
2. addAt(Array, Value, Location)
3. remove(Array, Value)
4. removeAt(Array, Value, Location)
5. replaceItem(Array, Value, Location)
#### Der Gebrauch bei meinem Intepreter
Ich habe meine Library gebraucht um verschiedene Werte auf dem Memory zu speichern, einfugen und ersetzen.

## Weiteres
### Der Code und restliche Infos sind auf [diesem Link]("https://github.com/xk-rl/AdvArray") zu finden!