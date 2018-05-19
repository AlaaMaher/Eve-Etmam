package com.alaaetmam.eve.WebService.getPersonCountry;

import com.alaaetmam.eve.Model.Names;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import java.util.Date;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.HeaderProperty;
import java.util.List;

public class CountriesRequest {

    private Names[] countrylist;
    private Names[] countryNames;

    private Names[] countrylistAr;
    private Names[] countryNamesAr;


    final String SOAP_ACTION_AR = "http://EveService.eveksa.com/IService1/GetCountriesAr";
    final String METHOD_NAME_AR = "GetCountriesAr";

    final String SOAP_ACTION_EN = "http://EveService.eveksa.com/IService1/GetCountriesEn";
    final String METHOD_NAME_EN = "GetCountriesEn";
    final String NAMESPACE = "http://EveService.eveksa.com";
    final String URL = "http://desktop-uaio4oj/TestService/Service1.svc";

    boolean exc = false;



    public Names[] GetCountriesEn() {
        return GetCountriesEn(null);
    }

    public Names[] GetCountriesEn(List<HeaderProperty> headers) {
        Object re = null;
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_EN);

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
                countrylist = new Names[arrCount];
                countryNames = new Names[arrCount];
                for (int i = 0; i < arrCount; i++) {
                    ob = objectFromString.get(i);

                    countrylist[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                    countryNames = countrylist;
                }



        }
        catch (Exception e) {
            exc = true;
            e.printStackTrace();
        }
        return countryNames;
    }


    public Names[] GetCountriesAr() {
        return GetCountriesAr(null);
    }

    public Names[] GetCountriesAr(List<HeaderProperty> headers) {
        Object re = null;
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_AR);

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
            countrylistAr = new Names[arrCount];
            countryNamesAr = new Names[arrCount];
            for (int i = 0; i < arrCount; i++) {
                ob = objectFromString.get(i);

                countrylistAr[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                countryNamesAr = countrylistAr;
            }



        }
        catch (Exception e) {
            exc = true;
            e.printStackTrace();
        }
        return countryNamesAr;
    }

}

//        soapEnvelope.implicitTypes = true;
//        soapEnvelope.dotNet = true;
//        SoapObject soapReq = new SoapObject("http://EveService.eveksa.com","GetCountriesEn");
//        soapEnvelope.addMapping("http://EveService.eveksa.com","Response",new Response().getClass());
//        soapEnvelope.addMapping("http://EveService.eveksa.com","req",new Request().getClass());
//        //soapReq.addProperty("req",req);
//
//        soapEnvelope.setOutputSoapObject(soapReq);
//        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
//        try{
//
//            if (headers!=null){
//                httpTransport.call("http://EveService.eveksa.com/IService1/GetCountriesEn", soapEnvelope,headers);
//            }else{
//                httpTransport.call("http://EveService.eveksa.com/IService1/GetCountriesEn", soapEnvelope);
//            }
//            SoapObject result=(SoapObject)soapEnvelope.bodyIn;
//
//            //  SoapObject soapObject =(SoapObject) result.getPropertySafely("ServiceSampleResult");
//            Response ServiceSampleResult = new Response(result);
//            return ServiceSampleResult;
//        }catch (Exception e) {
//            e.printStackTrace();
//        }


//
//    public Response GetCitiesEn(Request req){
//        return GetCitiesEn(req,null);
//    }
//
//
//    public Response GetCitiesEn(Request req,List<HeaderProperty> headers){
//
//        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//        soapEnvelope.implicitTypes = true;
//        soapEnvelope.dotNet = true;
//        SoapObject soapReq = new SoapObject("http://EveService.eveksa.com","GetCitiesEn");
//        soapEnvelope.addMapping("http://EveService.eveksa.com","Response",new Response().getClass());
//        soapEnvelope.addMapping("http://EveService.eveksa.com","req",new Request().getClass());
//        soapReq.addProperty("req",req);
//
//        soapEnvelope.setOutputSoapObject(soapReq);
//        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
//        try{
//
//            if (headers!=null){
//                httpTransport.call("http://EveService.eveksa.com/IService1/GetCitiesEn", soapEnvelope,headers);
//            }else{
//                httpTransport.call("http://EveService.eveksa.com/IService1/GetCitiesEn", soapEnvelope);
//            }
//            SoapObject result=(SoapObject)soapEnvelope.bodyIn;
//
//          //  SoapObject soapObject =(SoapObject) result.getPropertySafely("ServiceSampleResult");
//            Response ServiceSampleResult = new Response(result);
//            return ServiceSampleResult;
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


