
//RandomStuffTrait trait 
trait RandomStuffTrait {
  def transform(list: List[Int], op: (Int) => Int): List[Int];
  def allValid(list: List[Int], op: (Int) => Boolean): Boolean;
  def executeWithRetry(retryCount: Int, op: => Int): Option[Int];
}

//RandomStuff object 

object RandomStuff extends RandomStuffTrait {
    
 //generate a new list with the results in currentList
  def transform(list: List[Int], op: (Int) => Int): List[Int] = {
    var generatedList: List[Int] = List();
     list.foreach(currentNum => {
      generatedList = generatedList :+ op(currentNum);
    })
   generatedList;
  }
     
  //returns true if all these functions return true 
  def allValid(list: List[Int], op: (Int) => Boolean): Boolean = {
    for(currentNum <- list;
    if(!op(currentNum)))  {
      return false; }
    return true;
  }

   //Execute “op”, if it succeeds return its value as Option
  def executeWithRetry(retryCount: Int, op: => Int): Option[Int] = {
    for (i <- 1 to retryCount) {
    try {
        return Option(op)
      }
      catch {
        case e: Exception => {
              println(i+ ". succededs return");
        }
      }
    }
    None;
  }

}

