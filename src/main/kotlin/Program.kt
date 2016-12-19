 import com.rsk.Providers

/**
 * Created by Teste2 on 16/12/2016.
 */


fun main(args: Array<String>){
    val providers = Providers()
    val details = providers.getAllProviders() //Trazendo uma lista de providerDetails a partir do dataclass
    details.forEach { detail -> println("${detail.providerName} ------ ${detail.name}")}
                        //fazendo o foreach nessa lista de provider details e para cada detail, é exibido suas propriedades

    details.forEach{ println("${it.providerName} --- ${it.name}")} //Omitindo o nome da variavel detail - deixa o codigo mais limpo

    //Já que o ProviderDetails é uma dataClass ele já possui tostring ou seja não precisa printar todos os atributos
    println("_-__-__--_-_-----_--_-------________---")
    details.forEach { println(it) }

    //Nesse caso por estarmos passando um unico parametro para a function, podemos mudar para referencia à function
    details.forEach (::println)


    val details2 = providers.getAllProvidersRandomEX("Random")//queremos uma funcao que gere numeros random
    println("-----------------------------Filter--------------------------------")

    details2.forEach ( ::println )




    /*
    //listProvidersNoInstance()
        getAllProviders{
            key, value -> println("\t--------$key:         $value")
        }//Ao inves de passar como um parametros para a function, utilizamos {}
                     //{} é um indicador que o que estamos passando é uma function
              //então nesse ponto precisamos definir uma function que recebe duas strings e retorna nada*/
}
//key, value = nome das variaveis strings
//-> go to especificamos o que faremos com elas, no caso o mesmo que o println
//Isso é a passada de High Ordered Functions
//Com isso estamos passando uma strategy que será executada



//Map: a idéia é mapear no sentido de, passamos uma lista de nomes e ele mapeia numa lista de usuários, collection de uma coisa para uma collection que outra







//fn = function type
//queremos replicar o que passamos para o foreach - passamos 2 strings e retorna nada (void)
fun getAllProviders(fn: (String, String) -> Unit) {
    val allProviders = Providers.getProviders()//static
    val it = allProviders.iterator()
    while (it.hasNext()) {
        val provider = it.next()
        println(provider.name)
        //Para cada provider, é exibido uma key, value , utilizando um formato lambda no foreach
      /*  provider.forEach { key, value ->
            println("\t$key: $value")   //Foreach recebe uma function
            //fun callback(va1:String, val2:String):Unit - recebe duas strings e retorna nada
        }*/
        
        //Ao inves de chamar o println, chamaremos a function que recebemos como parametro(Na verdade definida na chamada desse metodo)
        //os toString são para que nao sejam tratados como objeto
        //Quando chamamos o forEach nos temos o key, value que será passado para a chamada do foreach
        //E nós chamamos o fn, que é a função passada ao chamar o getAllProviders e essa function irá printar os valores
        provider.forEach { key, value ->
            fn(key.toString(), value.toString())
        }




    }
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