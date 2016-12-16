package com.rsk

import java.security.Provider
import java.security.Security

/**
 * Created by Teste2 on 16/12/2016.
 */
class Providers {

    fun getProviders() : List<Provider>{
        //Não especificando o tipo
        //Retorna um array
        val providers = Security.getProviders()
        //Kotlin prove varios metodos de conversão de array para lista
        val listOfProviders: List<Provider> = providers.asList()

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