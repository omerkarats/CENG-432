package IyteMutableList
class IyteMutableList {
var list: Node = null
def add(newVal: String): Unit = {
val newNode = new Node(newVal)
if(list == null)
list = newNode
else{
var tmp = list
while(tmp.next!=null){
tmp = tmp.next
}
newNode.next = tmp.next
tmp.next = newNode
}
}
def write(): String = {
var str = "["
if(list == null)
return str
else {
var tmp = list
while(tmp != null){
str += tmp.value
str += ", "
tmp = tmp.next
}
str
}
}
}
object IyteMutableList {
def apply() = new IyteMutableList()
}
class Node(newVal: String) {
var value:String = newVal
var next: Node = null
}
