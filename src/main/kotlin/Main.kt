import java.util.Scanner

fun main() {
  /*
  Crie um programa em Kotlin que permita ao usuário digitar o nome e a idade de várias
pessoas, armazenando essas informações em um array de objetos Pessoa. O
programa deve ter as seguintes funcionalidades:

1 - Permitir ao usuário adicionar uma nova pessoa ao array, informando o nome e a
idade. *CONCLUIDO*
2 - Exibir a lista de todas as pessoas adicionadas ao array, mostrando o nome e a
idade de cada uma. *CONCLUIDO*
3 - Exibir a média de idade das pessoas adicionadas ao array. *CONCLUIDO*
4 - Permitir ao usuário buscar uma pessoa pelo nome, exibindo o nome e a idade
correspondentes.
5 - Permitir ao usuário remover uma pessoa pelo nome, atualizando o array e exibindo
a lista atualizada.
   */
    val teclado=Scanner(System.`in`)

    var pessoasNome = arrayListOf<String>()
    var pessoasIdade = arrayListOf<Int>()
    var condicaoCadastro:Char
    var menu :Int

    println("Bem vindo!")
    do {
        println("O que você deseja fazer:\n1- Cadastrar pessoas\n2- Exibir pessoas cadastradas, a idade de cada uma e a média de suas idades\n3- Pesquisar uma pessoa\n4- Remover uma pessoa\n5- Sair")
        menu = teclado.nextInt()
        if (menu == 1) {
            println("Bem vindo ao cadastro de pessoas!\nDeseja cadastrar pessoas?(S/N) ")
            condicaoCadastro = teclado.next().uppercase()[0]
            teclado.nextLine()
            while (condicaoCadastro == 'S') {
                println("Nome da pessoa: ")
                pessoasNome.add(teclado.nextLine().uppercase())
                println("Idade da mesma: ")
                pessoasIdade.add(teclado.nextInt())
                println("Cadastro concluído! Deseja cadastrar mais alguem? (S/N)")
                condicaoCadastro = teclado.next().uppercase()[0]
                teclado.nextLine()
            }
        } else {
            if (menu == 2) {//Exibir pessoas cadastradas, a idade de cada uma e a média de suas idades
                var contadorIdade=0
                var mediaIdade:Double
                for(i in 0.. (pessoasNome.size-1)){
                    println("${pessoasNome[i]}\nIdade: ${pessoasIdade[i]}\n")
                    contadorIdade+=pessoasIdade[i]
                }
                mediaIdade=contadorIdade.toDouble()/pessoasIdade.size
                println("Media da idade das pessoas informadas: $mediaIdade")
            } else {
                if (menu == 3) { //3- Pesquisar uma pessoa
                    var indexPessoaPesquisa:Int? = null
                    var encontrou:Boolean=false
                    teclado.nextLine()
                    println("Informe o nome da pessoa: ")
                    val nomePessoaPesquisa=teclado.nextLine().uppercase()
                    for(i in 0..(pessoasNome.size-1)){
                        if (pessoasNome[i].equals(nomePessoaPesquisa)){
                            encontrou=true
                            indexPessoaPesquisa=i
                        }
                    }
                    if(encontrou){
                        println("A pessoa foi encontrada!\nNome: ${pessoasNome.get(indexPessoaPesquisa!!)}\nIdade:${pessoasIdade.get(indexPessoaPesquisa)}")
                    } else{
                        println("A pessoa não foi encontrada.")
                    }
                } else {
                    if (menu == 4) {//4- Remover uma pessoa
                        val nomePesssoaExclusao:String
                        var indexPessoaExclusao:Int
                        println("Informe o nome da pessoa a ser removida: ")
                        teclado.nextLine()
                        nomePesssoaExclusao=teclado.nextLine().uppercase()
                        for(i in 0..(pessoasNome.lastIndex)){
                            if(pessoasNome[i].equals(nomePesssoaExclusao)){
                                indexPessoaExclusao=i
                                for(i2 in i..(pessoasNome.lastIndex)){
                                    if(i2<pessoasNome.lastIndex){
                                        pessoasNome.set(i2,pessoasNome[(i2+1)])
                                        pessoasIdade.set(i2,pessoasIdade[(i2+1)])
                                    }
                                }
                                pessoasNome.removeAt(pessoasNome.lastIndex)
                                pessoasNome.trimToSize()
                                pessoasIdade.removeAt(pessoasIdade.lastIndex)
                                pessoasIdade.trimToSize()
                                break
                            }
                        }
                    } else {
                        if(menu!=5){// 5- sair
                            println("Foi digitado um número inválido!")
                        }
                    }
                }
            }
        }
    }while(menu!=5)
}