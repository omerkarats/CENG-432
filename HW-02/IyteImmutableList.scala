class IyteImmutableList(node:Node) {
val root = node
def add(newVal: String, root:Node): IyteImmutableList = {
val newNode = new Node(newVal)
if(root == null)
new IyteImmutableList(newNode)
else{
add(newVal,root.next)
}
}
def write(ls:Node): String = {
var str = "["
if(ls == null)
str + "]"
else {
ls.value + write(ls.next)
}
}
}
object IyteImmutableList {
def apply(node:Node) = new IyteImmutableList(node)
}
class Node(newVal: String) {
var value:String = newVal
var next: Node = null
}
class List {
val root : Node = null
} 
