package com.example.ilham_projek_akhir_kba.models.event;

import com.google.gson.annotations.SerializedName;

public class DataEventHimtiItem{

	@SerializedName("Lokasi")
	private String lokasi;

	@SerializedName("image")
	private String image;

	@SerializedName("id")
	private String id;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("nama_event")
	private String namaEvent;

	public void setLokasi(String lokasi){
		this.lokasi = lokasi;
	}

	public String getLokasi(){
		return lokasi;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setNamaEvent(String namaEvent){
		this.namaEvent = namaEvent;
	}

	public String getNamaEvent(){
		return namaEvent;
	}

	@Override
 	public String toString(){
		return 
			"DataEventHimtiItem{" + 
			"lokasi = '" + lokasi + '\'' + 
			",image = '" + image + '\'' + 
			",id = '" + id + '\'' + 
			",tanggal = '" + tanggal + '\'' + 
			",nama_event = '" + namaEvent + '\'' + 
			"}";
		}
}