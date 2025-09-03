public class Lista {
    private  int[] vetor;
    private  int tamanhoAtual;
    private  int capacidade;

    public Lista(int capacidade){
        this.capacidade = capacidade;
        this.tamanhoAtual = 0;
        this.vetor = new int[capacidade];
    }

    public boolean listaVazia(){
        return tamanhoAtual == 0;
    }

    public boolean listaCheia(){
        return tamanhoAtual == vetor.length;
    }

    public void tamanhoListaAtual(){
        System.out.println("Tamanho Atual da lista é: " +tamanhoAtual);
        return;
    }

    public void adicionarNoInicio(int dado){
        if (listaCheia()){
            System.out.println("A lista está cheia");
        }
        else{
            for (int i = tamanhoAtual; i >= 1; i--){
                vetor[i] = vetor[i - 1];
            }
            vetor[0] = dado;
            tamanhoAtual++;
        }
    }

    public void removerDoInicio(){
        if (listaVazia()){
            System.out.println("Lista Vazia");
        }
        else{
            int elementoRemovido = vetor[0];
            for(int i = 0; i < tamanhoAtual - 1; i++){
                vetor[i] = vetor[i+1];
            }
            tamanhoAtual--;
        }
    }

    public void adicionarNoFinal(int dado){
        if(listaCheia()){
            System.out.println("Lista Cheia");
        }
        else{
            vetor[tamanhoAtual] = dado;
            tamanhoAtual++;
            System.out.println("Elemento " + dado + " adicionado no final");
        }
    }

    public void removerNoFinal(){
        if (listaVazia()){
            System.out.println("Lista Vazia!!");
            return;
        }
        else{
            System.out.println("Removendo elemento: " +vetor[tamanhoAtual - 1]);
            tamanhoAtual--;
        }
    }

    public void adicionandoDadoPosicao(int dado, int posicao){
        if (listaCheia()){
            System.out.println("Lista Cheia");
            return;
        }
        if (listaVazia()) {
            if (posicao != 0) {
                System.out.println("Erro: Para lista vazia, só pode adicionar na posição 0");
                return;
            }
        }
        else if (posicao < 0 || posicao > tamanhoAtual) {
            System.out.println("Erro: Posição inválida! Posições válidas: 0 a " + tamanhoAtual);
            return;
        }

        for(int i = tamanhoAtual; i > posicao; i--){
            vetor[i] = vetor[i - 1];
        }
        vetor[posicao] = dado;
        tamanhoAtual++;

    }

    public void removendoDadoPosicao(int posicao){
        if (listaVazia()){
            System.out.println("Lista Vazia!");
            return;
        }
        if (posicao < 0 || posicao >= tamanhoAtual) {
            System.out.println("Posição inválida!");
            return;
        }
        else{
            for(int i = posicao; i < tamanhoAtual - 1; i++){
                vetor[i] = vetor[i + 1];

            }
            tamanhoAtual--;
            System.out.println("Elemento da posição "+ posicao + " removido");
        }
    }

    public void adicionarAposAPosicao(int dado, int posicao){
        if (listaCheia()){
            System.out.println("Lista Cheia!");
            return;
        }
        if (posicao< 0 || posicao >= tamanhoAtual){
            System.out.println("Posição invalida!");
            return;
        }

        for (int i = tamanhoAtual; i > posicao + 1; i--){
            vetor[i] = vetor[i - 1];
        }
        vetor[posicao + 1] = dado;
        tamanhoAtual++;

    }

    public void elementoDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanhoAtual) {
            System.out.println("Posição invalida!!");
            return;
        }
        System.out.println("Valor da Posição " + posicao + ": " + vetor[posicao]);
    }


    public int buscarPosicaoDoDado(int dado){
        if (listaVazia()){
            System.out.println("Lista Vazia!");
            return -1;
        }

        for(int i =0; i <= tamanhoAtual; i++){
            if (vetor[i] == dado){
                System.out.println("Dado " + dado + " encontrado na posição " + i);
                return i;
            }
        }
        System.out.println("Dado " + dado + " não encontrado na lista");
        return -1;
    }


    public void exibir(){
        if (listaVazia()){
            System.out.print("Lista vazia!");
            return;
        }
        System.out.print("Lista: [");
        for(int i = 0; i< tamanhoAtual; i++){
            System.out.print(vetor[i]);
            if (i < tamanhoAtual - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

