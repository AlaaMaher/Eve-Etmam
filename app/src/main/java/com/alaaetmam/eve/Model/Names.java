package com.alaaetmam.eve.Model;

import java.io.Serializable;

public class Names implements Serializable   {


        private int Id;
        private String Name;

        public Names(int Id,String Name){
            this.Id = Id;
            this.Name =Name;
        }

        public void setId(int id){
            this.Id = id;
        }

        public int getId(){
            return this.Id;
        }

        public void setName(String name){
            this.Name = name;
        }

        public String getName(){
            return this.Name;
        }
    }
