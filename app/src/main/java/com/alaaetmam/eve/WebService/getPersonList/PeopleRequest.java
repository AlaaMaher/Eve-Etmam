package com.alaaetmam.eve.WebService.getPersonList;

import com.alaaetmam.eve.Model.Names;
import com.alaaetmam.eve.Model.Person;
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

public class PeopleRequest {

    private Person[] personList;
    private Person[] persons;

    final String SOAP_ACTION = "http://EveService.eveksa.com/IService1/GetPeopleEn";
    final String METHOD_NAME = "GetPeopleEn";
    final String NAMESPACE = "http://EveService.eveksa.com";
    final String URL = "http://desktop-uaio4oj/TestService/Service1.svc";


    boolean exc = false;

    public Person[] GetPeopleEn(int districtId) {
        return GetPeopleEn(districtId,null);
    }

    public Person[] GetPeopleEn(int districtId, List<HeaderProperty> headers) {

        Object re = null;
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);

        Request.addProperty("DistrictId",districtId);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(Request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_ACTION, envelope);

            re = (Object) envelope.getResponse();
            //      Bean ServiceSampleResult = new Bean(re);
            //      return ServiceSampleResult;

            JsonParser jsonParser = new JsonParser();
            JsonArray objectFromString = jsonParser.parse(re.toString()).getAsJsonArray();
            Gson Parseobj = new Gson();
            Object ob;
            int arrCount = objectFromString.size();
            personList = new Person[arrCount];
            persons = new Person[arrCount];
            for (int i = 0; i < arrCount; i++) {
                ob = objectFromString.get(i);

                personList[i] = Parseobj.fromJson((JsonElement) ob, Person.class);
                persons = personList;
            }



        }
        catch (Exception e) {
            exc = true;
            e.printStackTrace();
        }
        return persons;
    }

}
