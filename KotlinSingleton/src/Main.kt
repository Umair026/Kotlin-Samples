/**
 * Created by Ramish Hassan on 6/9/2017.
 */

fun main(args: Array<String>){
    var first =Singleton.instance
    first.b="Hello Singleton"

    var second=Singleton.instance
    println(second.b)


}