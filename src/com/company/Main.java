package com.company;

import com.company.Data;
import com.company.Phone;
import com.company.Search;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main
{

    public static void main(String[] args)
    {
        JSONGetter jsonGetter = new JSONGetter();
        JSONGetter.url = "https://api-mobilespecs.azharimm.site/v2/top-by-interest";
        jsonGetter.run();

        System.out.println("Waiting for data...");
        String jsonString = jsonGetter.jsonIn;
        System.out.println(jsonString);

        // Считываем json
        Object obj = null;
        try
        {
            obj = new JSONParser().parse(jsonString);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println();

        JSONArray jsonArray = (JSONArray) obj;
        System.out.println(jsonArray.toJSONString());
        System.out.println();

        Data data = new Data();

        for (Object jsonObject : jsonArray)
        {
            JSONObject phone = (JSONObject) jsonObject;
            String phone_name = (String) phone.get("phone_name");
            String slug = (String) phone.get("slug");
            int hits = Integer.parseInt((String) phone.get("hits"));
            String detail = (String) phone.get("detail");
            Phone phone1 = new Phone(phone_name, slug, hits, detail);
            data.add(phone1);
        }

        System.out.println("Imported data after parsing:\n" + data);
        System.out.println(data);

        data.getPhones().sort(Phone.byNameAsc);
        System.out.println("After sorting by name ascending:\n" + data);
        data.getPhones().sort(Phone.byNameDesc);
        System.out.println("After sorting by name descending:\n" + data);

        data.getPhones().sort(Phone.byValueAsc);
        System.out.println("After sorting by hits value ascending:\n" + data);
        data.getPhones().sort(Phone.byValueDesc);
        System.out.println("After sorting by hits value descending:\n" + data);

    }
}
