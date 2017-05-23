package com.csgbd.dao;

import com.csgbd.model.Geoname;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gabriel on 09/05/17.
 */

public class DaoGeoname {
    private Connection connection;

    public DaoGeoname (Connection connection) {
        this.connection = connection;
    }

    public List<Geoname> getLista(String sql, int limite) {
        try{
            Long tempoDeExecucao = System.currentTimeMillis();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            tempoDeExecucao = System.currentTimeMillis() - tempoDeExecucao;

            System.out.println("O tempo de execucao da consulta foi de " + tempoDeExecucao + "ms");
            // itera no ResultSet
            ArrayList<Geoname> geonames = new ArrayList<>();
            while (rs.next()) {
                if (limite <= 0)
                    break;
                //adiciona a lista
                Geoname geoname = new Geoname();
                geoname.setGeonameid(rs.getLong("geonameid"));
                geoname.setName(rs.getString("name"));
                geoname.setAsciiname(rs.getString("asciiname"));
                geoname.setAlternatenames(rs.getString("alternatenames"));
                geoname.setLatitude(rs.getFloat("latitude"));
                geoname.setLongitude(rs.getFloat("longitude"));
                geoname.setFclass(rs.getString("fclass"));
                geoname.setFcode(rs.getString("fcode"));
                geoname.setCountry(rs.getString("country"));
                geoname.setCc2(rs.getString("cc2"));
                geoname.setAdmin1(rs.getString("admin1"));
                geoname.setAdmin1(rs.getString("admin2"));
                geoname.setAdmin1(rs.getString("admin3"));
                geoname.setAdmin1(rs.getString("admin4"));
                geoname.setPopulation(rs.getLong("population"));
                geoname.setElevation(rs.getInt("elevation"));
                geoname.setGtopo30(rs.getInt("gtopo30"));
                geoname.setTimezone(rs.getString("timezone"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("moddate"));
                geoname.setModdate(data);

                geonames.add(geoname);
                limite --;
            }
            rs.close();
            stmt.close();
            return geonames;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void exibirPlanoConsulta (String sql) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            System.out.println(rs.getString(1));
            rs.close();
            stmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void criar_index (String nome_index, String table_name, String tipo_index, String atributo) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                "create index " + nome_index + " on " + table_name + " using " + tipo_index + "(" + atributo + ")");

            stmt.executeQuery();

            System.out.println("Index " + nome_index + " criado!");
            stmt.close();
        } catch (SQLException e) {
            //
        }
    }

    public void remover_index (String nome_index) {
        try {
            PreparedStatement stmt = connection.prepareStatement("drop index " + nome_index);
            stmt.executeQuery();
            System.out.println("Index " + nome_index + "removido!");
            stmt.close();
        } catch (SQLException e){
            //
        }
    }

    public static void limparCache () {
        try {
            Scanner scanner = new Scanner(System.in);
            String pass = scanner.next();
            
            String comando = "sudo su \r\n" + pass + "\r\n /etc/init.d/postgresql stop; echo 3 > /proc/sys/vm/drop_caches; /etc/init.d/postgresql start";
            Runtime.getRuntime().exec(comando);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
