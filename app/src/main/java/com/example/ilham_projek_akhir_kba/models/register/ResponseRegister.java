package com.example.ilham_projek_akhir_kba.models.register;

public class ResponseRegister{
	private String pesan;
	private boolean sukses;
	private int status;

	public String getPesan(){
		return pesan;
	}

	public boolean isSukses(){
		return sukses;
	}

	public int getStatus(){
		return status;
	}
}
