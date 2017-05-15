package filterorder

import org.codehaus.groovy.grails.web.json.JSONArray

import javax.net.ssl.HttpsURLConnection
import java.sql.ClientInfoStatus
import java.text.SimpleDateFormat

class SampleController {


    def sample = {
        int ld,lw,bf,open =0;

        try {
            int count =1;
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            while(true){
                JSONArray js;
                String output;
                List<Date> dlist = new ArrayList<Date>();

                URL url = new URL("https://api.github.com/repos/Shippable/support/issues?page="+count);//("https://api.github.com/gists/ce859a3af899b85640fb6881df3ef03b/comments");
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                while ((output = br.readLine()) != null) {
                    js = new JSONArray(output);
                }
                if(js.size() == 0){
                    break;
                }

                for (int i = 0; i < js.size(); i++) {
                    if(js[i]."state".equals("open")){
                        dlist.add(isoFormat.parse(js[i]."created_at"));
                        open++;
                    }
                }
                for (int i = 0; i < dlist.size(); i++) {
                    boolean ild = inLastDay((dlist.get(i)));
                    if(ild){
                        ld++;
                        continue;
                    }else if(inLastWeek(dlist.get(i))){
                        lw++;
                        continue;
                    }else {
                        bf++;
                    }
                }
                count++;
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        [openIssues :open, lastDay :ld ,lastWeek:lw,earlier : bf]
    }

    boolean inLastDay(Date aDate) {
        final long DAY = 24 * 60 * 60 * 1000;
        return aDate.getTime() > System.currentTimeMillis() - DAY;
    }
    boolean inLastWeek(Date aDate) {
        final long WEEK = 7 * 24 * 60 * 60 * 1000;
        return aDate.getTime() > System.currentTimeMillis() - WEEK;
    }
}
