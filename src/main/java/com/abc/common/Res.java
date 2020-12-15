package com.abc.common;


public class Res<T>{
    private int status;
    private String msg;
    private T data;


    private Res(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private Res(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Res{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    //sucess
    public static<T>  Res<T> sucess(ResEnum re, T data){
        return  new Res<T>(re.getStatus(),re.getMsg(),data);
    }
    public static Res sucess(ResEnum re,String msg){
        return  new Res(re.getStatus(),msg);
    }
    public static Res sucess(){
        return  new Res(ResEnum.SUCCESS.getStatus(),ResEnum.SUCCESS.getMsg());
    }
    public static Res sucess(ResEnum re){
        return  new Res(re.getStatus(),re.getMsg());
    }
    //error
    public static<T>  Res<T> error(ResEnum re, T data){
        return  new Res<T>(re.getStatus(),re.getMsg(),data);
    }
    public static Res error(ResEnum re,String msg){
        return  new Res(re.getStatus(),msg);
    }
    public static Res error(ResEnum re){
        return  new Res(re.getStatus(),re.getMsg());
    }
    public static Res error(){
        return  new Res(ResEnum.ERROR.getStatus(),ResEnum.ERROR.getMsg());
    }
}
