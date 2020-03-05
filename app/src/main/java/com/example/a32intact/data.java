package com.example.a32intact;


class data {
    private String name;

    public data() {
    }

    private String phno;
    private String email;
    public String getName() {
        return name;
    }

    public String getPhno() {
        return phno;
    }

    public String getEmail() {
        return email;
    }

    public data(String name, String phno, String email) {
        this.name = name;
        this.phno = phno;

        this.email = email;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}


