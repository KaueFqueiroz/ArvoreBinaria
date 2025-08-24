public class Pilha {
        private int capacidade;
        private Object array[];
        private int t = -1;

        public Pilha(){
            this.capacidade = capacidade;
            this.array = new Object[capacidade];
            this.t = -1;
        }

        public int size(){
            return t + 1;
        }

        public boolean isEmpty(){
            return t == -1;
        }

        public boolean isFull(){
            return t == capacidade - 1;
        }

        public void push(Object obj){
            if (!isFull()) {
                array[++t] = obj;
                System.out.println("Elemento " +obj + " adicionado à pilha");
            }
            else{
                System.out.println("A pilha está cheia");
            }
        }

        public Object pop(){
            if (isEmpty()) {
                System.out.println("A pilha está vazia");
                return null;
            }
            else{
                Object removido = array[t--];
                System.out.println("Elemento " + removido + " removido da pilha");
                return removido;
            }

        }

        public Object top(){
            if (isEmpty()){
                System.out.println("A pilha está vazia");
                return null;
            }
            System.out.println("Elemento no topo: " + array[t]);
            return array[t];
        }

        public void exibirPilha() {
            if (isEmpty()) {
                System.out.println("Pilha vazia.");
                return;
            }

            System.out.print("Pilha: [");
            for (int i = 0; i <= t; i++) {
                System.out.print(array[i]);
                if (i < t) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println("Tamanho atual: " +size());


        }
}
