package com.rsk

import java.security.Provider
import java.security.Security

/**
 * Created by Teste2 on 16/12/2016.
 */


//Data class - Helper class que terá a informação de todos os providers, name é o hashimplementation
data class ProviderDetails(val providerName: String, val name: String)


class Providers {

    fun getProviders() : List<Provider>{
        //Não especificando o tipo
        //Retorna um array
        val providers = Security.getProviders()
        //Kotlin prove varios metodos de conversão de array para lista
        val listOfProviders: List<Provider> = providers.asList()

        return listOfProviders
    }

    fun  getAllProvidersRandom(filter: String): List<ProviderDetails> {
         //Filter é outra function dentro da collections library que pega uma High ordered Function
        val providers = Security.getProviders()
        val listOfProviders = mutableListOf<ProviderDetails>()
        //Iremos filtrar a informação que nao precisamos e ai sim mapear essa informação
        providers.forEach { provider ->
            val providerDetails = provider.entries.filter { it ->  it.key.toString().contains(filter, true) } //ver se a key contain a filter string, se contiver retornamos de nao, não, o true é para ser caseSensitive
                    .map {
                ProviderDetails(provider.name, it.key.toString())
            }
            listOfProviders += providerDetails
        } //Fazendo comparação com SQL filter é Where e Map é Select

        return listOfProviders
    }

    fun  getAllProvidersRandomEX(filter: String): List<ProviderDetails> {
        val providers = Security.getProviders()

        //O problema dessa mudança é que forEach nao retorna nada, mas Map sim

        return providers.flatMap { provider ->
             provider.entries.filter { it ->  it.key.toString().contains(filter, true) } //ver se a key contain a filter string, se contiver retornamos de nao, não, o true é para ser caseSensitive
                    .map {
                        ProviderDetails(provider.name, it.key.toString())
                    }
        }
        //Mapeando junto duas collections, mergeando elas e retornando a lista resultante
        /*Como o map gera uma collection de collections quando passamos 2 collections, ex:
        Collection 1[1,2,3]
                Collection2[a,b]

                 Ele irá gerar

             Collection de collection  [ [1a,1b][2a,2b][3a,3b] ]
                Para resolver isso utilizamos flatmap

                Ele irá gerar :
                                [1a, 1b, 2a,2b, 3a,3b] = Single Collection

        */

    }


    fun getAllProviders(): List<ProviderDetails>{
        val providers = Security.getProviders()
        val listOfProviders= mutableListOf<ProviderDetails>() //Com isso irá criar uma lista mutavel listOfProviders do tipo ProviderDetails

        //iterar pelos providers mapeando eles nos providerdetails
        //para cada um desses providers eu quero criar um provider details
        providers.forEach { provider->
            val providerDetails = provider.entries.map {
                //entry->ProviderDetails(provider.name, entry.key.toString())

                //Não há a necessidade de dar um nome à variavel entry, kotlin ja o nomeia como "it", só precisa colcoar o comportamento
                ProviderDetails(provider.name, it.key.toString())

            } //Queremos mapear as "entries"
              //Para cada entry queremos criar um ProviderDetails (data class com os valores providerName e name(hash))
            //para conseguir esses valores, o providername vem de provider.name e o hash daquela entry.key
            //com isso conseguimos um unico ProviderDetail object
            listOfProviders += providerDetails //adicionando à lista com mecanismo de overload
            //Com isso é feito uma filtragem naquela val providers e atraves do map, nos retorna uma nova lista de provider details ao terminar o foreach
            //Em resumo: recebemos a lista de providers, mapeamos para uma lista de ProviderDetails e retornamos para o caller


        }




        return listOfProviders
    }

    //por nao ter metodos static, utilizamos companion objects - singleton object
    companion object {
        fun getProviders() : List<Provider>{
            val providers = Security.getProviders()
            val listOfProviders: List<Provider> = providers.asList()
            return listOfProviders
        }
    }



}