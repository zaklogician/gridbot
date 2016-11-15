#!/bin/sh

# compile bots
sbt compile

# clean game directory
if [ -d "games" ]; then 
  rm -r games
fi
mkdir games

# copy bots to game directory
cp -r target/scala-2.10/classes/* games/
cp halite games/

# run game
cd games
./halite -d "30 30" "scala GridBot" "scala GridBot"
cd ..