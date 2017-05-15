package filterorder

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONElement

import javax.net.ssl.HttpsURLConnection
import java.text.SimpleDateFormat


class GoogleController {

    def zomato = {
        List resUrls = new ArrayList()
        try {
            JSONArray js;
            URL url = new URL("https://developers.zomato.com/api/v2.1/cities?q=bangalore");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("user-key", "9b00889d8ba60ecd383e2e8d71189435");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            JSONElement data
            String output
            while ((output = br.readLine()) != null) {
                data = JSON.parse(output)
            }
            Integer cityId = data.location_suggestions.get(0).id











            url = new URL("https://developers.zomato.com/api/v2.1/collections?city_id=$cityId");
            conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("user-key", "9b00889d8ba60ecd383e2e8d71189435");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            while ((output = br.readLine()) != null) {
                data = JSON.parse(output)
            }
            def collId = data.collections.get(4).collection.get("collection_id")//


            url = new URL("https://developers.zomato.com/api/v2.1/search?entity_id=$cityId&collection_id=$collId&entity_type=city");
            conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("user-key", "9b00889d8ba60ecd383e2e8d71189435");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            while ((output = br.readLine()) != null) {
                data = JSON.parse(output)
            }
            JSONArray restaurants = data.restaurants
            List list = new ArrayList()
            restaurants.each {
                def res = it.restaurant
                if (res.average_cost_for_two <= 2200 && Double.parseDouble(res.user_rating.aggregate_rating) > 4.0)
                    list.add(res.id)
            }





            list.each {
                url = new URL("https://developers.zomato.com/api/v2.1/restaurant?res_id=$it");
                conn = (HttpsURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("user-key", "9b00889d8ba60ecd383e2e8d71189435");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
                br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                while ((output = br.readLine()) != null) {
                    data = JSON.parse(output)
                }
                resUrls.add(data.url)
            }












            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace()
        }
        [resUrls: resUrls]
    }
}
