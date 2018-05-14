
public class Dijkstra {

	
	public static void main (String[] args) {
		
		//Inicio conexiones entre nodos
		int [] g_from = {1,1,2,2,3};//Nodos de partida
		int [] g_to = {2,4,4,3,4};//Nodos de Finç
		//fin conexxiones entre nodos
		int [] g_weight = {1,3,2,3,7};//Distancia entre nodo de partida y de fin
		int g_nodes = 4;//numero de nodos
		boolean infinito = false;


		//rellenar con 1 donde haga falta
		int [][] matriz = new int [g_nodes][g_nodes];
	
		for(int i=0; i<g_nodes; i++) {//inicializamos matriz (si no se ha especificado la distancia entre dos nodos, se pone distancia 1)
		    for (int j = 0; j < g_nodes; j++) {
		        if(i==j){
		            matriz[i][j]=0;
		        }else{
		            matriz[i][j]=1;
		        }
		    }
		}
	
		for(int i = 0; i<g_from.length; i++){//añadimos los valores reales
		    matriz[g_from[i]-1][g_to[i]-1] = g_weight[i];
		    matriz[g_to[i]-1][g_from[i]-1] = -1; // para simular el infinito
		}
	
		for(int i=0; i<g_nodes; i++){
		    for(int j=0; j<g_nodes; j++){
		        for(int x=0; x<g_nodes; x++){
	
		            if(matriz[j][i]==-1 || matriz[i][x]==-1){ //miramos que ninguno de los sumantes sea infinito
		                infinito = true;
		            }
	
		            if(!infinito && (((matriz[j][i] + matriz[i][x]) < matriz[j][x]) || matriz[j][x]==-1)){
		                matriz[j][x] = matriz[j][i] + matriz[i][x];
		            }
		            infinito = false;
		        }
		    }
		}
	
		System.out.println( matriz[0][g_nodes-1]);
	}
}
