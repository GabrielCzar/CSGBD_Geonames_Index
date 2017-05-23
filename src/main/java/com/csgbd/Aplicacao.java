package com.csgbd;

import com.csgbd.dao.DaoGeoname;
import com.csgbd.model.Geoname;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gabriel on 09/05/17.
 */
public class Aplicacao {

    private static String corr(String s, int max) {
        int tam = (max - s.length());
        for (int i = 0; i < tam; i++)
            s += ' ';
        return s;
    }

    protected static void showLine (Geoname geoname) {
        System.out.println(
                corr(geoname.getName(), 30) + " | "
                 + corr(geoname.getCountry(), 11) + " | "
                 + corr(geoname.getPopulation().toString(), 14) + " | "
                 + corr(Float.toString(geoname.getLatitude()), 14) + " | "
                 + corr(Float.toString(geoname.getLongitude()), 14) + " | "
                 + corr(geoname.getGeonameid().toString(), 13));

    }

    public static void main (String [] args) {
        DaoGeoname dao = new DaoGeoname(ConnectionFactory.getConnection());
        String op;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Escolha uma das opcoes abaixo: ");
            System.out.println("S - Stop aplication");
            System.out.println("C - Clear cache");
            System.out.println("-----------------------");
            System.out.println("I - Insert index");
            System.out.println("D - Drop index");
            System.out.println("R - Run query");
            System.out.println("E - Explain");
            op = scanner.next();

            switch (op) {
                case "C": DaoGeoname.limparCache(); break;
                case "I":
                    String nome = "index_btree"
                    ,        table = "geoname"
                    ,        tipo = "btree"
                    ,        attr = "country";
                    // System.out.println("Nome do index: "); nome = scanner.next();
                    // System.out.println("Tabela: "); table = scanner.next();
                    // System.out.println("Tipo de index: "); tipo = scanner.next();
                    // System.out.println("Atributo a ser indexado: "); attr = scanner.next();
                    dao.criar_index(nome, table, tipo, attr);
                    break;
                case "D":
                    String nome2 = "index_btree";
                    // System.out.println("Nome do index a ser removido: "); nome = scanner.next();
                    dao.remover_index(nome2);
                    break;
                case "R":
                    String sql = "select * from geoname g where g.country = 'BR' and g.population > 1000000";
                    int limite = 10000000;
                    // System.out.println("Consulta SQL: "); sql = scanner.next();
                    List<Geoname> geonames = dao.getLista(sql, limite);
                    System.out.println("             Nome              |   Country   |   Population   |    Latitude    |    Longitude   |   ID  ");
                    for (Geoname geoname : geonames)
                        showLine(geoname);
                    System.out.println("Quantidade de tuplas: " + String.valueOf(geonames.size()));
                    break;
                case "E":
                    String sql2 = "explain select * from geoname g where g.country = 'BR' and g.population > 1000000";
                    // System.out.println("Plano de consulda da Tabela: "); table = scanner.next();
                    dao.exibirPlanoConsulta(sql2);
                    break;
                default:
                    System.out.println("Saindo...");
                    return;

            }
        }
    }
}
