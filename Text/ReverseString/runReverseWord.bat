FOR /L %%A IN (1,1,200) DO (
  @echo off
  javac *.java
  java ReverseString
  pause
)
