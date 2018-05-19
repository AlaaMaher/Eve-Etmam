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

public class CitiesRequest {



    private Names[] citylist;
    private Names[] cityNames;

    final String SOAP_ACTION_AR = "http://EveService.eveksa.com/IService1/GetCitiesAr";
    final String METHOD_NAME_AR = "GetCitiesAr";

    final String SOAP_ACTION_EN = "http://EveService.eveksa.com/IService1/GetCitiesEn";
    final String METHOD_NAME_EN = "GetCitiesEn";
    final String NAMESPACE = "http://EveService.eveksa.com";
    final String URL = "http://desktop-uaio4oj/TestService/Service1.svc";



    boolean exc = false;

    public Names[] GetCitiesEn(int countryId) {
        return GetCitiesEn(countryId,null);
    }

    public Names[] GetCitiesEn(int countryId, List<HeaderProperty> headers) {

        Object re = null;
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_EN);

        Request.addProperty("CountryId",countryId);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(Request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_ACTION_EN, envelope);

            re = (Object) envelope.getResponse();
            //      Bean ServiceSampleResult = new Bean(re);
            //      return ServiceSampleResult;

            JsonParser jsonParser = new JsonParser();
            JsonArray objectFromString = jsonParser.parse(re.toString()).getAsJsonArray();
            Gson Parseobj = new Gson();
            Object ob;
            int arrCount = objectFromString.size();
            citylist = new Names[arrCount];
            cityNames = new Names[arrCount];
            for (int i = 0; i < arrCount; i++) {
                ob = objectFromString.get(i);

                citylist[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                cityNames = citylist;
            }



        }
        catch (Exception e) {
            exc = true;
            e.printStackTrace();
        }
        return cityNames;
    }

    public Names[] GetCitiesAr(int countryId) {
        return GetCitiesAr(countryId,null);
    }

    public Names[] GetCitiesAr(int countryId, List<HeaderProperty> headers) {

        Object re = null;
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_AR);

        Request.addProperty("CountryId",countryId);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(Request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_ACTION_AR, envelope);

            re = (Object) envelope.getResponse();
            //      Bean ServiceSampleResult = new Bean(re);
            //      return ServiceSampleResult;

            JsonParser jsonParser = new JsonParser();
            JsonArray objectFromString = jsonParser.parse(re.toString()).getAsJsonArray();
            Gson Parseobj = new Gson();
            Object ob;
            int arrCount = objectFromString.size();
            citylist = new Names[arrCount];
            cityNames = new Names[arrCount];
            for (int i = 0; i < arrCount; i++) {
                ob = objectFromString.get(i);

                citylist[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                cityNames = citylist;
            }



        }
        catch (Exception e) {
            exc = true;
            e.printStackTrace();
        }
        return cityNames;
    }
}