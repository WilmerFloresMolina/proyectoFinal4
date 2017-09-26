package projecto_final;

import java.util.*;

/*
EJEMPLO DE INPUT
5 9
1 2 7
1 4 2
2 3 1
2 4 2
3 5 4
4 2 3
4 3 8
4 5 5
5 3 5
1
5
*/
class Dijkstra {

    private final int MAX = 10005;
    private final int INF = 1 << 30;

    private List< List< Node>> adyacncia = new ArrayList< List< Node>>();
    private int distancia[] = new int[MAX];
    private boolean vertice_visitado[] = new boolean[MAX];
    private PriorityQueue< Node> Q = new PriorityQueue<Node>();//usamos el comparador definido de java para que el de menor valor este en el tope
    private int vertic;
    private int impresion_caminoPrevio[] = new int[MAX];
    private boolean dijkstraEjecutado;

    public Dijkstra() {
    }

    Dijkstra(int V) {
        this.vertic = V;
        for (int i = 0; i <= V; ++i) {
            adyacncia.add(new ArrayList<Node>());
        }
        dijkstraEjecutado = false;
    }
    
    class Node implements Comparable<Node> {
        int first, second;
        
        Node(int d, int p){
            this.first = d;
            this.second = p;
        }

        public int compareTo(Node other){ //es necesario definir un comparador para el correcto funcionamiento del PriorityQueue
            if (second > other.second) {
                return 1;
            }
            if (second == other.second) {
                return 0;
            }
            return -1;
        }
    };

    private void inicializacion() {
        for (int i = 0; i <= vertic; ++i) {
            distancia[i] = INF;
            vertice_visitado[i] = false;
            impresion_caminoPrevio[i] = -1;
        }
    }

    private void relajacion(int actual, int adyacente, int peso){
        if (distancia[actual] + peso < distancia[adyacente]) {
            distancia[adyacente] = distancia[actual] + peso;
            impresion_caminoPrevio[adyacente] = actual;
            Q.add(new Node(adyacente, distancia[adyacente])); //adyacente en cola de prioridad
        }
    }

    void dijkstra(int inicial) {
        inicializacion();
        Q.add(new Node(inicial, 0));
        distancia[inicial] = 0;
        int actual, adyacente, peso;
        
        while (!Q.isEmpty()) {
            actual = Q.element().first; //obtener de la cola el nodo con menor peso, en un comienzo sera el inicial
            Q.remove();
            if (vertice_visitado[actual]) {
                continue;
            }
            vertice_visitado[actual] = true;

            for (int i = 0; i < adyacncia.get(actual).size(); ++i) {
                adyacente = adyacncia.get(actual).get(i).first;
                peso = adyacncia.get(actual).get(i).second; //( actual , adyacente )
                if (!vertice_visitado[adyacente]) {
                    relajacion(actual, adyacente, peso);
                }
            }
        }

        System.out.println("\033[30mDistancias mas cortas iniciando en vertice: "+"\033[34m"+inicial);
        //System.out.printf("\033[34m"+inicial);
        for (int i = 1; i <= vertic; ++i) {
            System.out.print("\033[30mVertice ");
            System.out.printf("\033[31m"+i);
            System.out.print(" , \033[30mdistancia mas corta = ");
            System.out.printf("\033[34m"+distancia[i]);
            //System.out.printf("\033[30mVertice %d , distancia mas corta = %d\n",i,distancia[i]);
            System.out.println("");
        }
        dijkstraEjecutado = true;
    }

    void addEdge(int origen, int destino, int peso, boolean dirigido) {
        adyacncia.get(origen).add(new Node(destino, peso)); //grafo diridigo
        if (!dirigido) {
            adyacncia.get(destino).add(new Node(origen, peso)); //grafo no dirigido
        }
    }

    void printShortestPath() {
        if (!dijkstraEjecutado) {
            System.out.println("\033[30mEs necesario ejecutar el algorithmo de Dijkstra antes de poder imprimir el camino mas corto");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\033[31m**************Impresion de camino mas corto**************");
        System.out.print("\033[30mIngrese vertice destino: ");
        System.out.println("\033[34m");
        destino = sc.nextInt();
        System.out.print("\033[31m");
        print(destino);
        System.out.println("\n");
    }

    int destino;
    
    void print(int destino) {
        if (impresion_caminoPrevio[destino] != -1){
            print(impresion_caminoPrevio[destino]);
        }
        System.out.printf("%d ", destino); //imprimir los caminos recorridos
    }

    public int getNumberOfVertices() {
        return vertic;
    }

    public void setNumberOfVertices(int numeroDeVertices) {
        vertic = numeroDeVertices;
    }

    public void dij() {
        int E, origen, destino, peso, inicial, V;
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[30mIngrese el numero de vertices: ");
        System.out.print("\033[34m");
        V =sc.nextInt();
        System.out.print("\033[30mIngrese el numero de aristas: ");
        E = sc.nextInt();
        Dijkstra dijkstraAlgorithm = new Dijkstra(V);
        for (int i = 0; i < E; ++i) {
            origen = sc.nextInt();
            destino = sc.nextInt();
            peso = sc.nextInt();
            dijkstraAlgorithm.addEdge(origen, destino, peso, true);
        }// fin for
        System.out.print("\033[30mIngrese el vertice inicial: ");
        System.out.print("\033[34m");
        inicial = sc.nextInt();
        dijkstraAlgorithm.dijkstra(inicial);
        dijkstraAlgorithm.printShortestPath();

    }
}
