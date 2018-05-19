package com.alaaetmam.eve.WebService.getPersonCountry;

import com.alaaetmam.eve.Model.Names;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

public class DistrictRequest {
    boolean exc = false;

    private Names[] districtlist;
    private Names[] districtNames;


    final String SOAP_ACTION_AR = "http://EveService.eveksa.com/IService1/GetDistrictsAr";
    final String METHOD_NAME_AR = "GetDistrictsAr";

    final String SOAP_ACTION_EN = "http://EveService.eveksa.com/IService1/GetDistrictsEn";
    final String METHOD_NAME_EN = "GetDistrictsEn";
    final String NAMESPACE = "http://EveService.eveksa.com";
    final String URL = "http://desktop-uaio4oj/TestService/Service1.svc";

    public Names[] GetDistrictEn(int cityId) {
        return GetDistrictEn(cityId,null);
    }

    public Names[] GetDistrictEn(int cityId, List<HeaderProperty> headers) {

        Object re = null;
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_EN);

        Request.addProperty("CityId",cityId);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(Request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_ACTION_EN, envelope);

            re = (Object) envelope.getResponse();

            JsonParser jsonParser = new JsonParser();
            JsonArray objectFromString = jsonParser.parse(re.toString()).getAsJsonArray();
            Gson Parseobj = new Gson();
            Object ob;
            int arrCount = objectFromString.size();
            districtlist = new Names[arrCount];
            districtNames = new Names[arrCount];
            for (int i = 0; i < arrCount; i++) {
                ob = objectFromString.get(i);

                districtlist[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                districtNames = districtlist;
            }



        }
        catch (Exception e) {
            exc = true;
            e.printStackTrace();
        }
        return districtNames;
    }


    public Names[] GetDistrictAr(int cityId) {
        return GetDistrictAr(cityId,null);
    }

    public Names[] GetDistrictAr(int cityId, List<HeaderProperty> headers) {

        Object re = null;
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_AR);

        Request.addProperty("CityId",cityId);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(Request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_ACTION_AR, envelope);

            re = (Object) envelope.getResponse();

            JsonParser jsonParser = new JsonParser();
            JsonArray objectFromString = jsonParser.parse(re.toString()).getAsJsonArray();
            Gson Parseobj = new Gson();
            Object ob;
            int arrCount = objectFromString.size();
            districtlist = new Names[arrCount];
            districtNames = new Names[arrCount];
            for (int i = 0; i < arrCount; i++) {
                ob = objectFromString.get(i);

                districtlist[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                districtNames = districtlist;
            }



        }
        catch (Exception e) {
            exc = true;
            e.printStackTrace();
        }
        return districtNames;
    }
}