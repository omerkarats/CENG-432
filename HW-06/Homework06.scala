import scala.collection.mutable.TreeSet


case class User(name: String, email: String, grade: Int)

trait UserManagerTrait {
  def add(name: String, email: String, grade: Int): Option[User]
  def getUser(email: String): Option[User]
  def getUserListForGrade(grade: Int): List[User]
  def getCertainGrades(gradeSelector: (Int) => Boolean): List[String]
}

object UserManager extends UserManagerTrait {
 
 val userSet = collection.mutable.Set[User]();

  def add(name: String, email: String, grade: Int): Option[User] = {
    val tempUser = User(name, email, grade);
    if (userSet.find((u:User) => u.email == tempUser.email).size != 0) {
    	
      None;
    }
    else {
    	 userSet +=tempUser;    	 
    	Option(tempUser);
    	
    }
  }
  
  
   def getUser(email: String): Option[User] = {
    val user = userSet.find(user => user.email == email)
    return user
  }
   
   
def getUserListForGrade(grade: Int): List[User] = {
    userSet.filter(user => user.grade == grade).toList
  }

def getCertainGrades(gradeSelector: (Int) => Boolean): List[String] = {
    userSet.filter(user => gradeSelector(user.grade)).map(user => user.name).toList
  }

  
}
