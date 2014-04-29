package com.spnotes;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;


import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

/**
 * Created by gpzpati on 2/10/14.
 */
public class GeoIP {

    private void getIPLocation(String ipStr) throws IOException, GeoIp2Exception{
        File file = new File("/temp/data/GeoLite2-City.mmdb");
        DatabaseReader reader = new DatabaseReader.Builder(file).build();
        CityResponse response = reader.city(InetAddress.getByName(ipStr));


        System.out.println("City " +response.getCity());
        System.out.println("ZIP Code " +response.getPostal().getCode());
        System.out.println("Country " +response.getCountry());
        System.out.println("Location " +response.getLocation());
    }

    public static void main(String[] argv)throws Exception {
        GeoIP gih = new GeoIP();
        gih.getIPLocation("210.128.115.149");
        gih.getIPLocation("67.188.26.1");

    }
}
