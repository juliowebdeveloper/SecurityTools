import com.rsk.Providers

/**
 * Created by Teste2 on 16/12/2016.
 */


fun main(args: Array<String>){

    listProvidersNoInstance()
}




fun  listProvidersInstance(){
    val providers = Providers()

    //Chamando a instancia da classe Providers que possui o metodo getProviders
    val allProviders = providers.getProviders()

    val it =  allProviders.iterator()
    while (it.hasNext()){
        val provider  = it.next()
        println(provider.name)
        //Para cada provider, é exibido uma key, value , utilizando um formato lambda no foreach
        provider.forEach { key, value -> println("\t$key : $value")  }
    }
}

//Acessando de forma estatica
fun listProvidersNoInstance(){
    val allProviders = Providers.getProviders()//static
    val it =  allProviders.iterator()
    while (it.hasNext()){
        val provider  = it.next()
        println(provider.name)
        //Para cada provider, é exibido uma key, value , utilizando um formato lambda no foreach
        provider.forEach { key, value -> println("\t$key: $value")  }
    }
}

fun listProviders(){
    val providers = getProviders()

    val it =  providers.iterator()
    while (it.hasNext()){
        val provider  = it.next()
        println(provider.name)
        //Para cada provider, é exibido uma key, value , utilizando um formato lambda no foreach
        provider.forEach { key, value -> println("\t$key: $value")  }
    }

}