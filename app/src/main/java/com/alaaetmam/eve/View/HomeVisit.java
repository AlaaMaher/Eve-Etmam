package com.alaaetmam.eve.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;

import com.alaaetmam.eve.Model.Names;
import com.alaaetmam.eve.R;
import com.alaaetmam.eve.Adapters.SpinnerAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

public class HomeVisit extends AppCompatActivity {


    boolean exc = false;

    private int countryId;
    private String  countryName;
    private Names[] countrylist;
    private Names[] countryNames;
    private SpinnerAdapter spinnerCountryAdapter;

    private int cityId;
    private String cityName;
    private Names[] citylist;
    private Names[] cityNames;
    private SpinnerAdapter spinnerCityAdapter;

    private int districtId;
    private String districtName;
    private Names[] districtlist;
    private Names[] districtNames;
    private SpinnerAdapter spinnerDistrictAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_visit);

        new country().execute();
    }

    class country extends AsyncTask<Void, Void, Void> {

        private final ProgressDialog dialog = new ProgressDialog(HomeVisit.this);


        final String SOAP_ACTION = "http://EveService.eveksa.com/IService1/GetCountriesEn";
        final String METHOD_NAME = "GetCountriesEn";
        final String NAMESPACE = "http://EveService.eveksa.com";
        final String URL = "http://192.168.1.10/TestService/Service1.svc";


        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Loading data");
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... unused) {

            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(Request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

            try {
                androidHttpTransport.call(SOAP_ACTION, envelope);

                Object re = (Object) envelope.getResponse();
                JsonParser jsonParser = new JsonParser();
                JsonArray objectFromString = jsonParser.parse(re.toString()).getAsJsonArray();
                Gson Parseobj = new Gson();
                Object ob;
                int arrCount = objectFromString.size();
                countrylist = new Names[arrCount];
                countryNames=new Names[arrCount];
                for (int i = 0; i < arrCount; i++) {
                    ob = objectFromString.get(i);

                    countrylist[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                    countryNames = countrylist;

                }
            } catch (Exception e) {
                exc = true;
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (exc) {
                Toast.makeText(HomeVisit.this, "Error", Toast.LENGTH_SHORT).show();
            } else {
                spinnerCountry();
                exc = false;
            }
        }
    }

    public void spinnerCountry() {

        Spinner spinner1 = (Spinner) findViewById(R.id.spnner1);

       // ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        spinnerCountryAdapter=new SpinnerAdapter(this, android.R.layout.simple_spinner_item,countryNames);
        //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinnerCountryAdapter);

        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int pos, long id) {

                Names name = spinnerCountryAdapter.getItem(pos);
                countryName=name.getName();
                countryId=name.getId();
                // Here you can do the action you want to...
                Toast.makeText(HomeVisit.this, "ID: " + countryId + "\nName: " + countryName,
                        Toast.LENGTH_SHORT).show();


             //   country= (String) parent.getItemAtPosition(pos);
              //  country = String.valueOf(adapterView.getItemAtPosition(pos).toString());
             //   Toast.makeText(HomeVisit.this,country, Toast.LENGTH_SHORT).show();

               new city().execute();

            }
        });
    }


    //////

    class city extends AsyncTask<Void, Void, Void> {

        private final ProgressDialog dialog = new ProgressDialog(HomeVisit.this);


        final String SOAP_ACTION = "http://EveService.eveksa.com/IService1/GetCitiesEn";
        final String METHOD_NAME = "GetCitiesEn";
        final String NAMESPACE = "http://EveService.eveksa.com";
        final String URL = "http://192.168.1.10/TestService/Service1.svc";


        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Loading data");
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... unused) {

            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Request.addProperty("CountryId", countryId);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(Request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

            try {
                androidHttpTransport.call(SOAP_ACTION, envelope);

                Object re = (Object) envelope.getResponse();
                JsonParser jsonParser = new JsonParser();
                JsonArray objectFromString = jsonParser.parse(re.toString()).getAsJsonArray();
                Gson Parseobj = new Gson();
                Object ob;
                int arrCount = objectFromString.size();
                citylist = new Names[arrCount];
                cityNames=new Names[arrCount];
                for (int i = 0; i < arrCount; i++) {
                    ob = objectFromString.get(i);
                    citylist[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                    cityNames= citylist;

                }
            } catch (Exception e) {
                exc = true;
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (exc) {
                Toast.makeText(HomeVisit.this, "Error", Toast.LENGTH_SHORT).show();
            } else {
                spinnerCity();
                exc = false;
            }
        }
    }

    public void spinnerCity() {

        Spinner spinner2 = (Spinner) findViewById(R.id.spnner2);

        // ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        spinnerCityAdapter=new SpinnerAdapter(this, android.R.layout.simple_spinner_item,cityNames);
        //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinnerCityAdapter);

        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {

                Names name = spinnerCityAdapter.getItem(pos);
                cityName=name.getName();
                cityId=name.getId();
                // Here you can do the action you want to...
                Toast.makeText(HomeVisit.this, "ID: " + cityId + "\nName: " + cityName,
                        Toast.LENGTH_SHORT).show();



                new district().execute();


            }
        });
    }

    /////////////


    class district extends AsyncTask<Void, Void, Void> {

        private final ProgressDialog dialog = new ProgressDialog(HomeVisit.this);


        final String SOAP_ACTION = "http://EveService.eveksa.com/IService1/GetDistrictsEn";
        final String METHOD_NAME = "GetDistrictsEn";
        final String NAMESPACE = "http://EveService.eveksa.com";
        final String URL = "http://192.168.1.10/TestService/Service1.svc";


        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Loading data");
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... unused) {

            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Request.addProperty("CityId", cityId);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(Request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

            try {
                androidHttpTransport.call(SOAP_ACTION, envelope);

                Object re = (Object) envelope.getResponse();
                JsonParser jsonParser = new JsonParser();
                JsonArray objectFromString = jsonParser.parse(re.toString()).getAsJsonArray();
                Gson Parseobj = new Gson();
                Object ob;
                int arrCount = objectFromString.size();
                districtlist = new Names[arrCount];
                districtNames=new Names[arrCount];
                for (int i = 0; i < arrCount; i++) {
                    ob = objectFromString.get(i);
                    districtlist[i] = Parseobj.fromJson((JsonElement) ob, Names.class);
                    districtNames= districtlist;

                }
            } catch (Exception e) {
                exc = true;
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (exc) {
                Toast.makeText(HomeVisit.this, "Error", Toast.LENGTH_SHORT).show();
            } else {
                spinnerDistrict();
                exc = false;
            }
        }
    }

    public void spinnerDistrict() {

        Spinner spinner3 = (Spinner) findViewById(R.id.spnner3);

        // ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        spinnerDistrictAdapter=new SpinnerAdapter(this, android.R.layout.simple_spinner_item,districtNames);
        //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(spinnerDistrictAdapter);

        spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {


                Names name = spinnerDistrictAdapter.getItem(pos);
                districtName=name.getName();
                districtId=name.getId();
                // Here you can do the action you want to...
                Toast.makeText(HomeVisit.this, "ID: " + districtId + "\nName: " + districtName,
                        Toast.LENGTH_SHORT).show();

            }
        });
    }






}
