package com.example.ilham_projek_akhir_kba.models.login;

public class ResponseLogin{
	private String pesan;
	private DataLogin dataLogin;
	private boolean sukses;
	private int status;

	public String getPesan(){
		return pesan;
	}

	public DataLogin getDataLogin(){
		return dataLogin;
	}

	public boolean isSukses(){
		return sukses;
	}

	public int getStatus(){
		return status;
	}
}
