package coreframework;

public enum Environment {
    Select(""), SYST("");
    private  String env;

    Environment(String env){this.env=env;}
    public  String getEnvironmentURL(){return this.env;}
}
