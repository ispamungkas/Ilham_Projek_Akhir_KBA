package com.example.ilham_projek_akhir_kba.models.event;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseEvent{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("dataEventHimti")
	private List<DataEventHimtiItem> dataEventHimti;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataEventHimti(List<DataEventHimtiItem> dataEventHimti){
		this.dataEventHimti = dataEventHimti;
	}

	public List<DataEventHimtiItem> getDataEventHimti(){
		return dataEventHimti;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseEvent{" + 
			"pesan = '" + pesan + '\'' + 
			",dataEventHimti = '" + dataEventHimti + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}