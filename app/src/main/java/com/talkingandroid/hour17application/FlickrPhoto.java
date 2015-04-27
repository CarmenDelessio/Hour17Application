package com.talkingandroid.hour17application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class FlickrPhoto extends Object {
	String id;
	String owner;
	String secret;
	String server;
	String farm;
	String title;
	Boolean isPublic;
	Boolean isFriend;
	Boolean isFamily;


	public FlickrPhoto(JSONObject jsonPhoto) throws JSONException {
		this.id=(String) jsonPhoto.optString("id","");
		this.secret=(String) jsonPhoto.optString("secret","");
		this.owner=(String) jsonPhoto.optString("owner","");
		this.server=(String) jsonPhoto.optString("server","");
		this.farm=(String) jsonPhoto.optString("farm","");
		this.title=(String) jsonPhoto.optString("title","");
		this.isPublic=(Boolean) jsonPhoto.optBoolean("ispublic", false);
		this.isFriend=(Boolean) jsonPhoto.optBoolean("isfriend", false);
		this.isFamily=(Boolean) jsonPhoto.optBoolean("isfamily", false);

    }
	
	public FlickrPhoto() {
	}

	public static ArrayList<FlickrPhoto> makePhotoList (String photoData ) throws JSONException, NullPointerException {
		ArrayList<FlickrPhoto> flickrPhotos = new ArrayList<FlickrPhoto>();
		JSONObject data  = new JSONObject(photoData);
		JSONObject photos = data.optJSONObject("photos");
		JSONArray photoArray = photos.optJSONArray("photo");
		for(int i = 0; i < photoArray.length(); i++) {
			JSONObject photo=	(JSONObject) photoArray.get(i);
			FlickrPhoto currentPhoto = new FlickrPhoto (photo);
			flickrPhotos.add(currentPhoto);
		}
		return flickrPhotos;
	}

}
