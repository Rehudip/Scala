import com.sun.org.apache.xpath.internal.functions.FuncFalse

object Main {

  abstract class Person(name: String,age: Int) {
    var x_location: Int = 0
    var y_location: Int = 0

    val basic_speed: Int = 0
    val runnable: Boolean = false
    val swimmable: Boolean = false

    def walk(): Unit = {
      val walk_speed: Int = basic_speed + 1
      this.x_location = this.x_location + walk_speed
      this.y_location = this.y_location + walk_speed
      println(this.name + " Walked to " + this.x_location, this.y_location)
    }

    def run(): Unit = {
      val run_speed: Int = basic_speed + 2
      if (runnable) {
        this.x_location = this.x_location + run_speed
        this.y_location = this.y_location + run_speed
        println(this.name + " Runned to " + this.x_location, this.y_location)
      } else {
        println(this.name + " can't run")
      }
    }

    def swim(): Unit = {
      val swim_speed: Int = basic_speed + 1
      if (swimmable) {
        this.x_location = this.x_location + swim_speed
        this.y_location = this.y_location + swim_speed
        println(this.name + " Swimmed to " + this.x_location, this.y_location)
      } else{
        println(this.name + " can't swim")
      }
    }

    def status(): Unit ={
      println(this.name + "(" + this.age + ")" + " is currently in " + this.x_location, this.y_location)
    }

  }

  class GrandFather(name: String,age: Int) extends Person(name,age){
    override val basic_speed: Int = 1
  }

  class Father(name: String,age: Int) extends Person(name,age){
    override val basic_speed: Int = 3
    override val runnable: Boolean = true
  }

  class Son(name: String,age: Int) extends Person(name,age){
    override val basic_speed: Int = 5
    override val runnable: Boolean = true
    override val swimmable: Boolean = true
  }

  def human(): Unit = {
    val a = new GrandFather("Grandfather", 75)
    val b = new Father("Father",45)
    val c = new Son("Son",15)

    val s = List(a,b,c)

    for (i<-s) {
      i.status()
      i.walk()
      i.run()
      i.swim()
    }

  }

  def main(args: Array[String]): Unit = {
    human()
  }
}