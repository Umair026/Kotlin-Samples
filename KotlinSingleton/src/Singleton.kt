/**
 * Created by Ramish Hassan on 6/9/2017.
 */


class Singleton
private constructor(){
    init {
        println("This ($this) is a singleton")
    }

    private object Holder{
        val INSTANCE= Singleton()
    }

    companion object{
        val instance : Singleton by lazy { Holder.INSTANCE }
    }

    var b : String? = null
}
