package edlista;

import java.util.Scanner;

public class EdLista {

    public static Scanner sc = new Scanner(System.in);

    static public int menu() {

        System.out.println("Digite");
        System.out.println("1-Para adicinar");
        System.out.println("2-Para retirar");
        System.out.println("3-Para consultar");
        System.out.println("4-Para Modificar");
        System.out.println("5-Para terminar");

        int n = sc.nextInt();

        return n;

    }

    static public Item obeterItem() {

        Item novo = new Item();
        sc.nextLine();
        System.out.println("Descrição");

        String aux = sc.nextLine();

        novo.setDescricao(aux);

        int valor = 0;

        //aqui
        do {
            System.out.println("Quantidade");
            valor = sc.nextInt();

        } while (valor <= 0 || valor > 10);

        novo.setQuant(valor);

        do {
            System.out.println("Prioridade");
            valor = sc.nextInt();

        } while (valor <= 0 || valor > 5);

        novo.setPrioridade(valor);
        return novo;
    }

    public static void main(String[] args) {

        ListaDv lista = new ListaDv();
        int n;
        Item novo = null;

        do {
            System.out.println("Tamanho");
            n = sc.nextInt();
        } while (!lista.setTamanho(n));

        do {
            n = menu();

            switch (n) {

                case 1:

                    novo = obeterItem();
                    if (lista.AdicionaFinal(novo)) {
                        System.out.println("Susceso");
                    } else {
                        System.out.println("lista cheia");
                    }
                    break;

                case 2:
                    novo = obeterItem();
                    novo = lista.retira(novo);

                    if (novo == null) {
                        System.out.println("suscesso!!");

                    } else {

                        System.out.println(novo.toString());
                    }
                    break;

                case 3:
                    novo = obeterItem();
                    novo = lista.consultar(novo);
                    if (novo == null) {
                        System.out.println("");
                    } else {
                        System.out.println(novo.toString());
                    }
                    break;

                case 4:

                    novo = obeterItem();
                    novo = lista.consultar(novo);

                    if (novo == null) {
                        System.out.println("sucesso");
                    } else {
                        System.out.println(novo.toString());
                        novo = obeterItem();
                        lista.modificarItem(novo, novo);
                    }
                    break;

                case 5:
                    System.out.println("terminado");
            }
        } while (n != 5);

    }

}

