package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.awt.*;

public class ChartData {
    private static ChartData s_instance;

    private int Site_M_B_G;
    private MelonChartParser melon;
    private BugsChartParser bugs;
    private GenieChartParser genie;
    private JSONArray[] chartData;
    private ChartData(){
        s_instance = this;
        Site_M_B_G = 1;
        chartData = new JSONArray[4];
        chartData[1] = new JSONArray();
        chartData[2] = new JSONArray();
        chartData[3] = new JSONArray();

        melon = new MelonChartParser();
        bugs = new BugsChartParser();
        genie = new GenieChartParser();
    }
    public void setSite_M_B_G(int M_B_G){
        Site_M_B_G = M_B_G;
    }
    public int getSite_M_B_G() {
        return Site_M_B_G;
    }

    public MelonChartParser getMelonChartParser() {
        return melon;
    }
    public BugsChartParser getBugsChartParser() {
        return bugs;
    }
    public GenieChartParser getGenieChartParser() {
        return genie;
    }

    public MusicChartParser getParser() {
        switch (Site_M_B_G) {
            case 1:
                return melon;
            case 2:
                return bugs;
            case 3:
                return genie;
            default:
                return null;
        }
    }

    public void DataPassing(Component parentComponent) {
        System.out.println("Parsing Data");
        switch (Site_M_B_G) {
            case 1:
                melon.chartDataParsing(parentComponent);
                break;
            case 2:
                bugs.chartDataParsing(parentComponent);
                break;
            case 3:
                genie.chartDataParsing(parentComponent);
                break;
        }
    }

    public void setJSONArray(JSONArray arr, int index) {
        switch(index) {
            case 0:
                chartData[0] = arr;
                return;
            case 1:
                chartData[1] = arr;
                return;
            case 2:
                chartData[2] = arr;
                return;
            default:
                throw new IndexOutOfBoundsException("the length of chartData is 3");
        }
    }
    public JSONArray getJSONArray(int index) {
        switch(index) {
            case 1:
                return chartData[1];
            case 2:
                return chartData[2];
            case 3:
                return chartData[3];
            default:
                throw new IndexOutOfBoundsException("the length of chartData is 3");
        }
    }

    public JSONArray getJSONArray() {
        switch(Site_M_B_G) {
            case 0:
                return chartData[1];
            case 1:
                return chartData[2];
            case 2:
                return chartData[3];
            default:
                throw new IndexOutOfBoundsException("the length of chartData is 3");
        }
    }

    public JSONArray getDisplayedJSONArray() {
        return chartData[Site_M_B_G];
    }
    public static ChartData getS_instance() {
        if(s_instance == null) s_instance = new ChartData();
        return s_instance;
    }
}
