import javax.swing.*;
import java.util.Stack;
public class Arvore {

    public Node root;

    public Arvore(){
        root = null;
    }

    public boolean arvoreVazia(){
        if(root == null){
            return true;
        }
        else
            return false;
    }

    public Node buscarElemento(Object elemento){
        if (arvoreVazia()){
            return null;
        }
        else{

            Stack<Node> pilha = new Stack<>();
            pilha.push(root);

            while(!pilha.isEmpty()){
                Node auxiliar = pilha.pop();

                if (auxiliar.elemento == elemento) {
                    return auxiliar;
                }

                if (auxiliar.filho_direita != null ){
                    pilha.push(auxiliar.filho_direita);
                }

                if (auxiliar.filho_esquerda != null ){
                    pilha.push(auxiliar.filho_esquerda);
                }
            }
        }
        return null;
    }

    public void adicionarEsquerda(Object elemento, Object p){
        Node novo_no = new Node(elemento);

        if (!arvoreVazia()){
            Node pai = buscarElemento(p);

            if (pai != null){
                if (pai.filho_esquerda == null) {
                    pai.filho_esquerda = novo_no;
                }
                else {
                    System.out.println("Erro: Nó já possui filho a esquerda");
                }
            }
            else {
                System.out.println("Erro: Elemento inexistente!");
            }
        }

        else {
            root = novo_no;
        }
    }

    public void adicionarDireita(Object elemento, Object p){
        Node novo_no = new Node(elemento);

        if (!arvoreVazia()){
            Node pai = buscarElemento(p);

            if (pai != null){
                if (pai.filho_direita == null){
                    pai.filho_direita = novo_no;
                }
                else {
                    System.out.println("Erro: Nó já possuí filho");
                }
            }
            else {
                System.out.println("Erro: Elemento pai inexiste!!");
            }
        }

        // Se a arvore estiver vazia, o novo nó vira o root
        else {
            root = novo_no;
        }
    }

    public Node buscarPai(Object elemento){
        if (arvoreVazia()){
            return null;
        }

        Stack<Node> pilha = new Stack<>();
        pilha.push(root);

        while (!pilha.isEmpty()){
            Node auxilar = pilha.pop();

            if(auxilar.filho_direita.elemento == elemento || auxilar.filho_esquerda.elemento == elemento){
                return auxilar;
            }

            if (auxilar.filho_direita != null){
                pilha.push(auxilar.filho_direita);
            }

            if (auxilar.filho_esquerda != null){
                pilha.push(auxilar.filho_esquerda);
            }
        }

        return null;

    }

    public Node removerElemento(Object elemento){
        Node removido = null;

        // verificar se a arvore está diferente de vazia!!
        if (!arvoreVazia()){
            // aqui ele busca o nó a ser removido
            removido = buscarElemento(elemento);
        }

        if (removido != null){
            Node esquerda = removido.filho_esquerda;
            Node direita = removido.filho_direita;
            Node pai = buscarPai(elemento);

            //Remoção de um Nó folha (sem filhos)

            if (esquerda == null && direita == null){
                if (pai == null){
                    root = null;
                }
                else if (pai.filho_esquerda == removido){
                    pai.filho_esquerda = null;
                }
                else {
                    pai.filho_direita = null;
                }
            }

            // Nó a ser removido com dois filhos

            else if (removido.filho_esquerda != null && removido.filho_direita != null ) {
                if (pai.filho_esquerda == removido){
                    pai.filho_esquerda = esquerda;


                    Node auxilar = esquerda;
                    while(auxilar.filho_esquerda != null){
                        auxilar = auxilar.filho_esquerda;
                    }
                    auxilar.filho_esquerda = direita;
                }

                else if (pai.filho_direita == removido) {
                    pai.filho_direita = direita;

                    Node auxiliar = direita;
                    while(auxiliar.filho_direita != null){
                        auxiliar = auxiliar.filho_direita;
                    }

                    auxiliar.filho_direita = esquerda;
                }
            }

            // Nó com apenas um filho
            else {
                if (pai.filho_esquerda == removido){
                    if (esquerda == null){
                        pai.filho_esquerda = direita;
                    }
                    else {
                        pai.filho_esquerda = esquerda;
                    }
                }
                else if (pai.filho_direita == removido) {
                    if (direita == null){
                        pai.filho_direita = esquerda;
                    }
                    else {
                        pai.filho_direita = direita;
                    }
                }
            }
        }

        else {
            System.out.println("Erro: Estrutura Vazia!");
        }

        return removido;

    }




}