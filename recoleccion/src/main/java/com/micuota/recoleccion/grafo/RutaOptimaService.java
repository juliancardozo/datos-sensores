package com.micuota.recoleccion.grafo;

import java.util.*;

/**
 * Calcula la ruta óptima hacia el contenedor más conveniente usando
 * el algoritmo de Dijkstra sobre un grafo completo.
 */
public class RutaOptimaService {

    private final List<ContainerNode> nodos;
    private final Map<String, Integer> indexById;
    private final double[][] distancias; // matriz de distancias geográficas

    public RutaOptimaService(List<ContainerNode> nodos) {
        this.nodos = nodos;
        this.indexById = new HashMap<>();
        for (int i = 0; i < nodos.size(); i++) {
            indexById.put(nodos.get(i).id, i);
        }
        this.distancias = calcularDistancias();
    }

    private double[][] calcularDistancias() {
        int n = nodos.size();
        double[][] d = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    d[i][j] = 0.0;
                } else {
                    d[i][j] = distancia(nodos.get(i), nodos.get(j));
                }
            }
        }
        return d;
    }

    private double distancia(ContainerNode a, ContainerNode b) {
        double dx = a.lat - b.lat;
        double dy = a.lon - b.lon;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Encuentra el contenedor más conveniente considerando distancia,
     * nivel de llenado y capacidad.
     *
     * @param startId identificador del nodo de partida
     * @return nodo destino recomendado
     */
    public ContainerNode contenedorMasConveniente(String startId) {
        int start = indexById.get(startId);
        double[] dist = dijkstra(start);
        double mejorScore = Double.POSITIVE_INFINITY;
        ContainerNode mejor = null;
        for (int i = 0; i < nodos.size(); i++) {
            if (i == start) continue;
            ContainerNode n = nodos.get(i);
            // Menor distancia y mayor volumen recolectable reducen el puntaje
            double volumen = n.collectedVolume();
            double score = dist[i] / (volumen > 0 ? volumen : 1);
            if (score < mejorScore) {
                mejorScore = score;
                mejor = n;
            }
        }
        return mejor;
    }

    private double[] dijkstra(int source) {
        int n = nodos.size();
        double[] dist = new double[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[source] = 0.0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            double best = Double.POSITIVE_INFINITY;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && dist[v] < best) {
                    best = dist[v];
                    u = v;
                }
            }
            if (u == -1) break;
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                double alt = dist[u] + distancias[u][v];
                if (alt < dist[v]) {
                    dist[v] = alt;
                }
            }
        }
        return dist;
    }
}
