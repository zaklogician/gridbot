/**
  * Created by snoe on 7/23/16.
  */
class GridBot(id: Int, gameMap:GameMap) extends HaliteBot(id, gameMap) {

  override def takeTurn(turn:BigInt, gameMap:GameMap): MoveList = {
    val moves = new MoveList()
    for( x <- 0 to gameMap.width  - 1
       ; y <- 0 to gameMap.height - 1
       ) {
      val loc = new Location(x,y)
      val site: Site = gameMap.getSite(new Location(x, y))
      
      if (site.owner == id) {
        if ((x + y) % 2 == 0) {
          if (turn % 3 == 0) moves.add(new Move(loc, Direction.STILL))
          if (turn % 3 == 1) moves.add(new Move(loc, Direction.NORTH))
          if (turn % 3 == 2) moves.add(new Move(loc, Direction.WEST))
        }
        if ((x + y) % 2 == 1) {
          if (turn % 4 == 0) moves.add(new Move(loc, Direction.STILL))
          if (turn % 4 == 1) moves.add(new Move(loc, Direction.STILL))
          if (turn % 4 == 2) moves.add(new Move(loc, Direction.NORTH))
          if (turn % 4 == 3) moves.add(new Move(loc, Direction.WEST))
        }
      }
    }
    moves
  }

}

object GridBot {

  def main(args:Array[String]):Unit = {

    val maker = new HaliteBotMaker() {
      override def makeBot(id:Int, gameMap:GameMap):HaliteBot = new GridBot(id, gameMap)
    }

    HaliteBot.run(args, maker)
  }
}
